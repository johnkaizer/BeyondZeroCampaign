package com.project.beyondzero.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.project.beyondzero.Adapter.DoctorsAdapter;
import com.project.beyondzero.Adapter.DoctorsAdapter1;

import com.project.beyondzero.Model.DoctorsModel;
import com.project.beyondzero.Model.DoctorsModel1;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class CreateAppointmentActivity extends AppCompatActivity {
    RecyclerView doctorRec;
    DoctorsAdapter1 doctorsAdapter1;
    ArrayList<DoctorsModel1> doctorsModel1List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment);
        doctorRec = findViewById(R.id.doc_recyclerview);
        doctorsModel1List = new ArrayList<>();

        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc1,R.drawable.bab,"Dr. John Kimm","4","1:00pm-5:00pm","Mid-Wife"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc2,R.drawable.uterus,"Dr. Mary Tiana","3","8:00am-12:00pm","gynaecologist"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc3,R.drawable.heart,"Dr. Joan Kenny","3","2:00pm-5:00pm","Cardiologist"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc4,R.drawable.obstetrical,"Dr. Joseph Killstone","2","4:00pm-6:00pm","Obstetrician"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc5,R.drawable.bab,"Dr. Joshua Turner","5","11:00am-5:00pm","Mid-Wife"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc6,R.drawable.obstetrical,"Dr. Angela Kith","4","7:00pm-10:00pm","Obstetrician"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc7,R.drawable.heart,"Dr. John Joshua","3","11:00pm-1:00am","Cardiologist"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc8,R.drawable.bab,"Dr. Manthera Kimithri","5","10:00am-5:00pm","Mid-Wife"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc9,R.drawable.obstetrical,"Dr. Timmy Turner ","3","9:00am-5:00pm","Obstetrician"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc10,R.drawable.uterus,"Dr. James Jason ","5","7:00am-3:00pm","gynaecologist"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc11,R.drawable.bab,"Dr. Ezra Kanjo ","2","3:00pm-5:00pm","Mid-Wife"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc12,R.drawable.uterus,"Dr. Sasha Barnice ","3","1:00pm-5:00pm","gynaecologist"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc13,R.drawable.obstetrical,"Dr. Shalom Mental","3","12:00pm-2:00pm","Obstetrician"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc14,R.drawable.bab,"Dr. Evans Kanairo","3","2:00pm-6:00pm","Mid-Wife"));
        doctorsModel1List.add(new DoctorsModel1(R.drawable.doc15,R.drawable.uterus,"Dr. Mary Mitchelle ","4","5:00pm-9:00pm","gynaecologist"));

        doctorsAdapter1 = new DoctorsAdapter1(this, doctorsModel1List, this);
        doctorRec.setAdapter(doctorsAdapter1);
        doctorRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        doctorRec.setHasFixedSize(true);
        doctorRec.setNestedScrollingEnabled(false);

    }
}