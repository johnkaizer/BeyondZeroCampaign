package com.project.beyondzero.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.beyondzero.Activites.SignInActivity;
import com.project.beyondzero.HospitalResourcesActivity;
import com.project.beyondzero.MainActivity;
import com.project.beyondzero.R;

public class ProfileFragment extends Fragment {

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        button=root.findViewById(R.id.appCompatButton2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HospitalResourcesActivity.class));

            }
        });

        return root;
    }

}