package com.example.assign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    EditText phone, pass, name, loc;
    String sphone, spass, sname, sloc;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        phone=findViewById(R.id.number2);
        pass=findViewById(R.id.password2);
        name=findViewById(R.id.name2);
        loc=findViewById(R.id.location);
        dbHelper = new DbHelper(this);
    }

    public void save(View view) {
        sphone = phone.getText().toString();
        spass = pass.getText().toString();
        sname = name.getText().toString();
        sloc = loc.getText().toString();

        dbHelper.savedata(sphone, spass, sname, sloc);
        Toast.makeText(getApplicationContext(), "Data saved successfully!!", Toast.LENGTH_SHORT).show();
    }
}