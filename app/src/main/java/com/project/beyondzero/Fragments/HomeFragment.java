package com.project.beyondzero.Fragments;

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
import com.project.beyondzero.R;

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

        doctorsModelList.add(new DoctorsModel(R.drawable.doc1,R.drawable.bab,"Dr. John Kimm","0789456734","1:00pm-5:00pm","Mid-Wife"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc2,R.drawable.uterus,"Dr. Mary Tiana","0723457890","8:00am-12:00pm","gynaecologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc3,R.drawable.heart,"Dr. Joan Kenny","0758200909","2:00pm-5:00pm","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc4,R.drawable.obstetrical,"Dr. Joseph Killstone","0723456723","4:00pm-6:00pm","Obstetrician"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc5,R.drawable.bab,"Dr. Joshua Turner","0789005678","11:00am-5:00pm","Mid-Wife"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc6,R.drawable.obstetrical,"Dr. Angela Kith","0767984563","7:00pm-10:00pm","Obstetrician"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc7,R.drawable.heart,"Dr. John Joshua","0743234567","11:00pm-1:00am","Cardiologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc8,R.drawable.bab,"Dr. Manthera Kimithri","0790095678","10:00am-5:00pm","Mid-Wife"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc9,R.drawable.obstetrical,"Dr. Timmy Turner ","0754324567","9:00am-5:00pm","Obstetrician"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc10,R.drawable.uterus,"Dr. James Jason ","0700984455","7:00am-3:00pm","gynaecologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc11,R.drawable.bab,"Dr. Ezra Kanjo ","0787903322","3:00pm-5:00pm","Mid-Wife"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc12,R.drawable.uterus,"Dr. Sasha Barnice ","0711223345","1:00pm-5:00pm","gynaecologist"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc13,R.drawable.obstetrical,"Dr. Shalom Mental","078348373763","12:00pm-2:00pm","Obstetrician"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc14,R.drawable.bab,"Dr. Evans Kanairo","0748473472","2:00pm-6:00pm","Mid-Wife"));
        doctorsModelList.add(new DoctorsModel(R.drawable.doc15,R.drawable.uterus,"Dr. Mary Mitchelle ","07454644775","5:00pm-9:00pm","gynaecologist"));



        doctorsAdapter = new DoctorsAdapter(getActivity(), doctorsModelList, this);
        doctorRec.setAdapter(doctorsAdapter);
        doctorRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false));
        doctorRec.setHasFixedSize(true);
        doctorRec.setNestedScrollingEnabled(false);


        newsFeedRec = root.findViewById(R.id.news_feed);
        newsFeedModelList = new ArrayList<>();

        newsFeedModelList.add(new NewsFeedModel(R.drawable.news1,"MAY 24, 2018","First Lady Calls on Kenyans to Embrace Universal Healthcare Initiatives"));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.news2,"APRIL 28, 2018","First Lady Opens Heart Management Conference"));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.oxygen,"13/07/2020","Deputy President William Ruto launched equipment at the Mama Lucy Kibaki Level 5 "));
        newsFeedModelList.add(new NewsFeedModel(R.drawable.nms,"JULY 13, 2020","MAMA LUCY KIBAKI HOSPITAL RECEIVES PPE DONATIONS"));


        newsFeedAdapter = new NewsFeedAdapter(getActivity(), newsFeedModelList, this);
        newsFeedRec.setAdapter(newsFeedAdapter);
        newsFeedRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));
        newsFeedRec.setHasFixedSize(true);
        newsFeedRec.setNestedScrollingEnabled(false);

        return root;
    }
}