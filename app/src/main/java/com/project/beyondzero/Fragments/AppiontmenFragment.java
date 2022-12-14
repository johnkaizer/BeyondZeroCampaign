package com.project.beyondzero.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.beyondzero.Adapter.AppointmentsAdapter;
import com.project.beyondzero.Activites.CreateAppointmentActivity;
import com.project.beyondzero.Model.AppointmentsModel;
import com.project.beyondzero.R;
import com.project.beyondzero.Activites.ViewAllActivity;

import java.util.ArrayList;


public class AppiontmenFragment extends Fragment {
    RecyclerView appointmentRec;
    CardView cardView2;
    Button all_btn;
    AppointmentsAdapter appointmentsAdapter ;
    ArrayList<AppointmentsModel> list;
    Query databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_appiontmen, container, false);
        appointmentRec = root.findViewById(R.id.Appointments);
        all_btn= root.findViewById(R.id.all);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("AppointmentDetails");
        appointmentRec.setHasFixedSize(true);
        appointmentRec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        appointmentsAdapter = new AppointmentsAdapter(getContext(),list);
        appointmentRec.setAdapter(appointmentsAdapter);
        appointmentsAdapter.setOnItemClickListener(new AppointmentsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                list.remove(position);
                appointmentsAdapter.notifyItemRemoved(position);
                Toast.makeText(getContext(),"Successfully Canceled Appointment",Toast.LENGTH_SHORT).show();
            }
        });

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
}