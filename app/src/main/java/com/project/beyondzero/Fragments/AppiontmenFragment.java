package com.project.beyondzero.Fragments;

import static com.project.beyondzero.DBmain.TABLENAME;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.beyondzero.Adapter.AppointmentsAdapter;
import com.project.beyondzero.Activites.CreateAppointmentActivity;
import com.project.beyondzero.DBmain;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;
import com.project.beyondzero.Activites.ViewAllActivity;

import java.util.ArrayList;


public class AppiontmenFragment extends Fragment {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView appointmentRec;
    AppointmentsAdapter appointmentsAdapter ;
    ArrayList<AppointmentsModel> appointmentsModelList;

    CardView cardView2;
    Button all_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_appiontmen, container, false);
        appointmentRec = root.findViewById(R.id.Appointments);
        dBmain = new DBmain(getContext());
        displayData();

        all_btn= root.findViewById(R.id.all);
        appointmentRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));

        cardView2=root.findViewById(R.id.cardView1);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreateAppointmentActivity.class));
            }
        });
        all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ViewAllActivity.class));

            }
        });

        return root;
    }


    private void displayData() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor  = sqLiteDatabase.rawQuery("select * from "+TABLENAME+"",null);
        ArrayList<AppointmentsModel>list = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            byte[]avatar = cursor.getBlob(1);
            String name = cursor.getString(2);
            String date = cursor.getString(3);
            String time = cursor.getString(4);
            String title = cursor.getString(5);
            String patient = cursor.getString(6);
            int phone = cursor.getInt(7);
            list.add(new AppointmentsModel(id,avatar,name,title,patient,time,phone,date));
        }
        cursor.close();
        appointmentsAdapter = new AppointmentsAdapter(getContext(), list, sqLiteDatabase, R.layout.appointment_item);
        appointmentRec.setAdapter(appointmentsAdapter);
    }
}