package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class HomePage extends AppCompatActivity {

    TextView tv;
    String bg;

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();
        bg = intent.getStringExtra("blood");
        dbHelper = new DbHelper(this);
        List<String> ls = dbHelper.getUsers(bg);
        tv=findViewById(R.id.tv);
        tv.setTextSize(22);
        String result = "";
        for(int i=0; i<ls.size();){
            result += "Name : "+ ls.get(i) + " | Location : " + ls.get(i+1) + " | BloodGroup : " + ls.get(i+2) + "\n";
            i=i+3;
        }
        tv.setText(result);
    }

    public void back(View view) {
        Intent intent= new Intent(HomePage.this, MainActivity.class);
        startActivity(intent);
    }
}