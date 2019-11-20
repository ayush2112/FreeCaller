package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btn_SignUp(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }

    public void btn_SignIn(View view) {
        startActivity(new Intent(getApplicationContext(),SignIn.class));
    }


}
