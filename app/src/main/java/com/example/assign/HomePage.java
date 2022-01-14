package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv=findViewById(R.id.tv);
        tv.setText("Welcome Abhishek");
    }

    public void back(View view) {
        Intent intent= new Intent(HomePage.this, MainActivity.class);
        startActivity(intent);
    }
}