package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
       final EditText _phoneno = findViewById(R.id.editText);
       final EditText _passwoed = findViewById(R.id.editText2);
       final Button btn = findViewById(R.id.button);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String phoneno = _phoneno.getText().toString();
               final String password = _passwoed.getText().toString();
               DatabaseReference db = FirebaseDatabase.getInstance().getReference().child(phoneno);
               db.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       String value = dataSnapshot.child("password").getValue().toString();
                       if(value.equals(password)){
                           Intent intent = new Intent(SignIn.this,aftersignin.class);
                           startActivity(intent);
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {
                       Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });
    }

    public void btn_Home(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    public void btn_ForgotPassword(View view) {
        startActivity(new Intent(getApplicationContext(),Forgot_Password.class));

    }
}
