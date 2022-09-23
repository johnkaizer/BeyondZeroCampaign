package com.project.beyondzero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.beyondzero.Adapter.DoctorsAdapter;
import com.project.beyondzero.Model.DoctorsModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView doctorRec;
    DoctorsAdapter doctorsAdapter;
    ArrayList<DoctorsModel> doctorsModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        doctorRec = root.findViewById(R.id.doc_recyclerview);
        doctorsModelList = new ArrayList<>();

        doctorsModelList.add(new DoctorsModel(R.drawable.doc1,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc2,R.drawable.legs,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc3,R.drawable.brain,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc4,R.drawable.tooth,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc5,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc6,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc7,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc8,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc9,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc10,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc11,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc12,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc13,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc14,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc15,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));



        doctorsAdapter = new DoctorsAdapter(getActivity(), doctorsModelList, this);
        doctorRec.setAdapter(doctorsAdapter);
        doctorRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        doctorRec.setHasFixedSize(true);
        doctorRec.setNestedScrollingEnabled(false);

        return root;
    }
}