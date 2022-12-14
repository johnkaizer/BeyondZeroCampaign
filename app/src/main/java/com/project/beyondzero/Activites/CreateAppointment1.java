package com.project.beyondzero.Activites;



import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.beyondzero.MainActivity;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CreateAppointment1 extends AppCompatActivity {
    TextView title,time,name,patients;
    ImageView image;
    EditText pat_name, pat_time,pat_phone,pat_date;
    Button submit_btn,edit;
    private DatePickerDialog picker;
    TimePickerDialog picker1;
    DatabaseReference dataRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment1);
        dataRef= FirebaseDatabase.getInstance().getReference().child("AppointmentDetails");
        name= findViewById(R.id.name);
        image = findViewById(R.id.image_doc);
        title = findViewById(R.id.title);
        patients = findViewById(R.id.patients);
        time = findViewById(R.id.time);
        pat_name = findViewById(R.id.pat_name);
        pat_time = findViewById(R.id.pat_time);
        pat_phone = findViewById(R.id.pat_phone);
        pat_date = findViewById(R.id.date);
        submit_btn = findViewById(R.id.submit_btn);
        name.setText(getIntent().getExtras().getString("name"));
        title.setText(getIntent().getExtras().getString("title"));
        patients.setText(getIntent().getExtras().getString("patients"));
        time.setText(getIntent().getExtras().getString("time"));
        Integer ImageUrl = getIntent().getIntExtra("image",0);
        image.setImageResource(ImageUrl);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookAppointment();
            }
        });
        pat_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(CreateAppointment1.this,  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        pat_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                },year, month,day);
                picker.show();
            }
        });
        pat_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour= calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                picker1 = new TimePickerDialog(CreateAppointment1.this,  new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                        String time= format.format(c.getTime());
                        pat_time.setText(time);

                    }
                },hour, min,false);
                picker1.show();
            }
        });
    }

    private void BookAppointment() {
        String AppointmentDate =  pat_date.getText().toString();
        String DoctorName =  name.getText().toString();
        String DoctorTitle =  title.getText().toString();
        String DoctorPhone =  patients.getText().toString();
        String AppointmentTime =  pat_time.getText().toString();
        String PatPhone =  pat_phone.getText().toString();
        String PatName =  pat_name.getText().toString();

        AppointmentsModel appointments = new AppointmentsModel(AppointmentDate,DoctorName,DoctorTitle,DoctorPhone,AppointmentTime,PatPhone,PatName);
        dataRef.push().setValue(appointments);
        Toast.makeText(CreateAppointment1.this,"Successfully created appointment",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CreateAppointment1.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}