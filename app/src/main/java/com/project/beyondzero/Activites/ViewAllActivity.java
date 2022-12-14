package com.project.beyondzero.Activites;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.beyondzero.Adapter.AppointmentsAdapter;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;

import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity {

    RecyclerView appointmentRec;
    AppointmentsAdapter appointmentsAdapter ;
    ArrayList<AppointmentsModel> list;
    Query databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        appointmentRec =findViewById(R.id.view_all);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("AppointmentDetails");
        appointmentRec.setHasFixedSize(true);
        appointmentRec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        appointmentsAdapter = new AppointmentsAdapter(this,list);
        appointmentRec.setAdapter(appointmentsAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    AppointmentsModel appointmentsModel = dataSnapshot.getValue(AppointmentsModel.class);
                    list.add(appointmentsModel);
                }
                appointmentsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}