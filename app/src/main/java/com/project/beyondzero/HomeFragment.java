package com.project.beyondzero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.beyondzero.Adapter.DoctorsAdapter;
import com.project.beyondzero.Adapter.NewsFeedAdapter;
import com.project.beyondzero.Model.DoctorsModel;
import com.project.beyondzero.Model.NewsFeedModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView doctorRec, newsFeedRec;
    DoctorsAdapter doctorsAdapter;
    ArrayList<DoctorsModel> doctorsModelList;

    //News Feed
    NewsFeedAdapter newsFeedAdapter;
    ArrayList<NewsFeedModel> newsFeedModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        doctorRec = root.findViewById(R.id.doc_recyclerview);
        doctorsModelList = new ArrayList<>();

        doctorsModelList.add(new DoctorsModel(R.drawable.doc1,R.drawable.heart,"Dr. John Kimm","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc2,R.drawable.legs,"Dr. Mary Tiana","5","3:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc3,R.drawable.brain,"Dr. Joan Kenny","1","11:00am","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc4,R.drawable.tooth,"Dr. Joseph Killstone","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc5,R.drawable.heart,"Dr. Joshua Turner","3","1:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc6,R.drawable.heart,"Dr. Angela Kith","3","1:00pm","Cardiologist"));
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


        newsFeedRec = root.findViewById(R.id.news_feed);
        newsFeedModelList = new ArrayList<>();

        newsFeedModelList.add(new NewsFeedModel(R.drawable.news1,"MAY 24, 2018","First Lady Calls on Kenyans to Embrace Universal Healthcare Initiatives"));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.news2,"APRIL 28, 2018","First Lady Opens Heart Management Conference"));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.news3,"MAY 22, 2018","First Lady Delivers Medical Equipment to Bungoma County"));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.news4,"APRIL 25, 2018","Beyond Zero Commended for Championing Quality Medical Services for Women and Children"));


        newsFeedAdapter = new NewsFeedAdapter(getActivity(), newsFeedModelList, this);
        newsFeedRec.setAdapter(newsFeedAdapter);
        newsFeedRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
        newsFeedRec.setHasFixedSize(true);
        newsFeedRec.setNestedScrollingEnabled(false);

        return root;
    }
}