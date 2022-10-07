package com.project.beyondzero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateAppointment1 extends AppCompatActivity {

    TextView title,time,name,patients;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment1);

        name= findViewById(R.id.name);
        image = findViewById(R.id.image_doc);
        title = findViewById(R.id.title);
        patients = findViewById(R.id.patients);
        time = findViewById(R.id.time);

        name.setText(getIntent().getExtras().getString("name"));
        title.setText(getIntent().getExtras().getString("title"));
        patients.setText(getIntent().getExtras().getString("patients"));
        time.setText(getIntent().getExtras().getString("time"));
        Integer ImageUrl = getIntent().getIntExtra("image",0);
        image.setImageResource(ImageUrl);


    }
}