package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    //EditText name,password,phoneno,email;
    Button btn;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText _name = findViewById(R.id.editText3);
        final EditText _password = findViewById(R.id.editText5);
        final EditText _email = findViewById(R.id.editText4);
        final EditText _phoneno = findViewById(R.id.editText6);
        btn = findViewById(R.id.button5);
        db = FirebaseDatabase.getInstance().getReference();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map = new HashMap<String, String>();
                String email = _email.getText().toString();
                String password = _password.getText().toString();
                String name = _name.getText().toString();
                String phoneno = _phoneno.getText().toString();
                if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && !phoneno.isEmpty()){
                    map.put("email",email);
                    map.put("name",name);
                    map.put("password",password);
                    db.child(phoneno).setValue(map);
                    Toast.makeText(SignUp.this, "Text Added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SignUp.this, "Field are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
