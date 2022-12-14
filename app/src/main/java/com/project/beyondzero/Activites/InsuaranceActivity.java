package com.project.beyondzero.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.beyondzero.Model.InsuaranceModel;
import com.project.beyondzero.MainActivity;
import com.project.beyondzero.R;

public class InsuaranceActivity extends AppCompatActivity {
    Button submit;
    EditText text,idno,name;
    DatabaseReference dataRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insuarance);
        submit = findViewById(R.id.submit_btn);
        text= findViewById(R.id.nhif_no);
        idno = findViewById(R.id.nhif_id);
        name = findViewById(R.id.nhif_name);
        dataRef= FirebaseDatabase.getInstance().getReference().child("InsuranceDetails");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDetails();
                text.setText(" ");
                idno.setText(" ");
                name.setText(" ");
                Toast.makeText(InsuaranceActivity.this,"Membership received. A notification email will be sent",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InsuaranceActivity.this, MainActivity.class));
                finish();

            }
        });
    }

    private void submitDetails() {
        String PatientInsNo =  text.getText().toString();
        String PatientName =  name.getText().toString();
        String PatientID =  idno.getText().toString();
        InsuaranceModel insuaranceModel = new InsuaranceModel(PatientName,PatientID,PatientInsNo);
        dataRef.push().setValue(insuaranceModel);
    }
}