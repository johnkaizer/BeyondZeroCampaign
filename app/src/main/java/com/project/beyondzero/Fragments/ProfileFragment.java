package com.project.beyondzero.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.beyondzero.Activites.SignInActivity;
import com.project.beyondzero.Activites.EditInforActivity;
import com.project.beyondzero.Activites.FQSActivity;
import com.project.beyondzero.Activites.FeedBackActivity;
import com.project.beyondzero.Activites.HospitalResourcesActivity;
import com.project.beyondzero.Adapter.HealthAdapter;
import com.project.beyondzero.Activites.InsuaranceActivity;
import com.project.beyondzero.Model.InsuaranceModel;
import com.project.beyondzero.R;
import com.project.beyondzero.Model.User;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ProgressBar progressBar;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    Button button, btn,logout;
    TextView faqs,feedback,health;
    Query databaseReference;
    HealthAdapter healthAdapter;
    RecyclerView healthRV;
    ArrayList<InsuaranceModel>list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        button=root.findViewById(R.id.appCompatButton2);
        btn=root.findViewById(R.id.editbtn);
        logout = root.findViewById(R.id.logout);
        progressBar = root.findViewById(R.id.progressBar);
        faqs = root.findViewById(R.id.textView25);
        feedback = root.findViewById(R.id.textView28);
        health=root.findViewById(R.id.health);
        healthRV = root.findViewById(R.id.healthRV);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("InsuranceDetails");
        healthRV.setHasFixedSize(true);
        healthRV.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        list = new ArrayList<>();
        healthAdapter = new HealthAdapter(getContext(),list);
        healthRV.setAdapter(healthAdapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    InsuaranceModel insuaranceModel = dataSnapshot.getValue(InsuaranceModel.class);
                    list.add(insuaranceModel);
                }
                healthAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), InsuaranceActivity.class));
            }
        });
        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FQSActivity.class));
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FeedBackActivity.class));
            }
        });
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HospitalResourcesActivity.class));

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EditInforActivity.class));

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(),SignInActivity.class));
                getActivity().finish();
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView fullNameTxt = root.findViewById(R.id.pat_name);
        final TextView emailTxt = root.findViewById(R.id.textView23);
        final TextView phoneTxt = root.findViewById(R.id.textView21);
        final TextView passwordTxt = root.findViewById(R.id.pat_password);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile !=null){
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String phone = userProfile.phone;
                    String password = userProfile.password;


                    fullNameTxt.setText(fullName);
                    emailTxt.setText(email);
                    phoneTxt.setText(phone);
                    passwordTxt.setText(password);

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(),"Something wrong happened!", Toast.LENGTH_SHORT).show();

            }
        });

        return root;
    }

}