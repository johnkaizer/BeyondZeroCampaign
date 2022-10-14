package com.project.beyondzero.Activites;

import static com.project.beyondzero.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.project.beyondzero.Adapter.AppointmentsAdapter;
import com.project.beyondzero.DBmain;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView appointmentRec;
    AppointmentsAdapter appointmentsAdapter ;
    ArrayList<AppointmentsModel> appointmentsModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        appointmentRec =findViewById(R.id.view_all);
        dBmain = new DBmain(this);
        appointmentRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        displayData();
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
        appointmentsAdapter = new AppointmentsAdapter(this, list, sqLiteDatabase, R.layout.appointment_item);
        appointmentRec.setAdapter(appointmentsAdapter);
    }
}