package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText bloodGroup;
    String sBloodGroup;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bloodGroup = findViewById(R.id.number1);
        dbHelper = new DbHelper(this);
    }

    public void search(View view) {
        sBloodGroup = bloodGroup.getText().toString();
        if(dbHelper.bgPresent(sBloodGroup)) {
            Intent intent= new Intent(MainActivity.this, HomePage.class);
            intent.putExtra("blood", sBloodGroup);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), sBloodGroup + " Bloodgroup not found!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void signup(View view) {
        Intent intent= new Intent(MainActivity.this, SignUpPage.class);
        startActivity(intent);
    }
}