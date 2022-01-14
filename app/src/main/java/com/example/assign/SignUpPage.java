package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    EditText name, loc, bg;
    String sname, sloc, sbg;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        name=findViewById(R.id.name2);
        loc=findViewById(R.id.loc2);
        bg=findViewById(R.id.bg2);
        dbHelper = new DbHelper(this);
    }

    public void save(View view) {
        sname = name.getText().toString();
        sloc = loc.getText().toString();
        sbg = bg.getText().toString();


        dbHelper.savedata(sname, sloc, sbg);
        Toast.makeText(getApplicationContext(), "Registered successfully!!", Toast.LENGTH_SHORT).show();

        Intent intent= new Intent(SignUpPage.this, MainActivity.class);
        startActivity(intent);
    }
}