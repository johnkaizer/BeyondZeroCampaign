package com.project.beyondzero.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.beyondzero.MainActivity;
import com.project.beyondzero.R;

public class SignInActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private EditText EditTextEmail,editTextPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        EditTextEmail = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText3);
        progressBar = findViewById(R.id.progressBar);


    }

    public void signUp(View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        finish();
    }

    public void login(View view) {
        String email =EditTextEmail.getText().toString().trim();
        String password =editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            EditTextEmail.setError(" email is required!!");
            EditTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            EditTextEmail.setError("Please provide a valid email address!");
            EditTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError(" password is required!!");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(view.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                     startActivity(new Intent(SignInActivity.this, MainActivity.class));
                     Toast.makeText(SignInActivity.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
                     progressBar.setVisibility(view.GONE);
                     finish();
                 }else{
                     Toast.makeText(SignInActivity.this,"Failed to log in check your credentials",Toast.LENGTH_SHORT).show();
                     progressBar.setVisibility(view.GONE);
                 }
            }
        });

    }

    public void forgot(View view) {
    }
}