package com.project.beyondzero;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.beyondzero.Adapter.AppointmentsAdapter;
import com.project.beyondzero.Model.AppointmentsModel;

import java.util.ArrayList;


public class AppiontmenFragment extends Fragment {
    RecyclerView appointmentRec;
    AppointmentsAdapter appointmentsAdapter ;
    ArrayList<AppointmentsModel> appointmentsModelList;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_appiontmen, container, false);

        appointmentRec = root.findViewById(R.id.Appointments);
        appointmentsModelList = new ArrayList<>();

        appointmentsModelList.add(new AppointmentsModel(R.drawable.doc1,"Dr.Micheal Kean","29th Sept 2022","12:00pm","Gynaecologist"));
        appointmentsModelList.add(new AppointmentsModel(R.drawable.doc2,"Dr.Mary Anne ","1st Oct 2022","2:00pm","Gynaecologist"));
        appointmentsModelList.add(new AppointmentsModel(R.drawable.doc3,"Dr.Shingih Shrwata","5th Oct 2022","2:00pm","Gynaecologist"));
        appointmentsModelList.add(new AppointmentsModel(R.drawable.doc4,"Dr.Joseph Kante","8th Oct 2022","11:00am","Gynaecologist"));
        appointmentsModelList.add(new AppointmentsModel(R.drawable.doc5,"Dr.Steve GreyHood ","10th Oct 2022","10:00am","Gynaecologist"));


        appointmentsAdapter = new AppointmentsAdapter(getActivity(), appointmentsModelList, this);
        appointmentRec.setAdapter(appointmentsAdapter);
        appointmentRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        appointmentRec.setHasFixedSize(true);
        appointmentRec.setNestedScrollingEnabled(false);

        return root;
    }
}