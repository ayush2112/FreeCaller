package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class displayactivity extends AppCompatActivity {
    TextView tv,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayactivity);
        tv = findViewById(R.id.textView);
        String data = getIntent().getExtras().getString("name_data");
        tv.setText(data);
        tv6 = findViewById(R.id.textView6);
        String data1 = getIntent().getExtras().getString("email_data");
        tv6.setText(data1);
    }
    public void btn_SearchAnother(View view) {
        startActivity(new Intent(getApplicationContext(),aftersignin.class));
    }
}
