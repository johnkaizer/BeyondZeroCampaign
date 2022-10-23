package com.project.beyondzero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.beyondzero.Activites.SignInActivity;

public class InsuaranceActivity extends AppCompatActivity {
    Button submit;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insuarance);

        submit = findViewById(R.id.submit_btn);
        text= findViewById(R.id.nhif_no);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(" ");
                Toast.makeText(InsuaranceActivity.this,"Membership No received. A notification email will be sent",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InsuaranceActivity.this, MainActivity.class));
                finish();

            }
        });
    }
}