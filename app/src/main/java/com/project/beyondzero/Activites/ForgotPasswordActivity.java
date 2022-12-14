package com.project.beyondzero.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.project.beyondzero.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    Button submit;
    ProgressBar progressBar;
    EditText emailEditText;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        submit= findViewById(R.id.submit_btn);
        progressBar =findViewById(R.id.progressBar);
        emailEditText = findViewById(R.id.pat_email);

        auth= FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetPassword();
            }
        });
    }

    private void ResetPassword() {
        String email= emailEditText.getText().toString().trim();
        if (email.isEmpty()){
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide a valid email");
            emailEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this,"Check your email to reset your password!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgotPasswordActivity.this,"Try again something wrong happened!",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}