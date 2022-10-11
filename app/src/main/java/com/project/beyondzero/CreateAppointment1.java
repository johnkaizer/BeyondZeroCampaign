package com.project.beyondzero;

import static com.project.beyondzero.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.beyondzero.Activites.SignInActivity;

import java.io.ByteArrayOutputStream;

public class CreateAppointment1 extends AppCompatActivity {
    DBmain dBmain;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    TextView title,time,name,patients;
    ImageView image;
    EditText pat_name, pat_time,pat_phone,pat_date;
    Button submit_btn;
    int id =0;
    public static final int STORAGE_REQUEST = 101;
    String[]storagePermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment1);

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

        dBmain = new DBmain(this);

        name.setText(getIntent().getExtras().getString("name"));
        title.setText(getIntent().getExtras().getString("title"));
        patients.setText(getIntent().getExtras().getString("patients"));
        time.setText(getIntent().getExtras().getString("time"));
        Integer ImageUrl = getIntent().getIntExtra("image",0);
        image.setImageResource(ImageUrl);

        insertData();


    }

    private void insertData() {

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("avatar",ImageViewToByte(image));
                cv.put("name",name.getText().toString());
                cv.put("title",title.getText().toString());
                cv.put("patient",pat_name.getText().toString());
                cv.put("time",time.getText().toString());
                cv.put("phone",pat_phone.getText().toString());
                cv.put("date",pat_date.getText().toString());
                sqLiteDatabase= dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(TABLENAME,null,cv);
                if (recinsert!= null){
                    Toast.makeText(CreateAppointment1.this,"Booked successfully",Toast.LENGTH_SHORT).show();
                    finish();
                    display();

                }

            }
        });
    }

    private void display() {
        startActivity(new Intent(CreateAppointment1.this, MainActivity.class));
    }

    private byte[] ImageViewToByte(ImageView image) {

        Bitmap bitmap= ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        byte[]bytes= stream.toByteArray();
        return bytes;
    }
}