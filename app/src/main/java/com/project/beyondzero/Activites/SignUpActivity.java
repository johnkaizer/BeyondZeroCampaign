package com.project.beyondzero.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.beyondzero.MainActivity;
import com.project.beyondzero.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void home(View view) {
        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        finish();
    }

    public void signIn(View view) {
        startActivity(new Intent(SignUpActivity.this, SignInActivity .class));
        finish();
    }
}