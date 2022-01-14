package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone, pass;
    String sphone, spass;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.number1);
        pass = findViewById(R.id.password1);
        dbHelper = new DbHelper(this);
    }

    public void signin(View view) {
        sphone = phone.getText().toString();
        spass = pass.getText().toString();
        String pass2 = dbHelper.getPassword(sphone);
        String check = pass2 + " = " + spass;
        Toast.makeText(getApplicationContext(), check, Toast.LENGTH_SHORT).show();
        if(pass2.equals(spass)) {
            Intent intent= new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "User not found!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void signup(View view) {
        Intent intent= new Intent(MainActivity.this, SignUpPage.class);
        startActivity(intent);
    }
}