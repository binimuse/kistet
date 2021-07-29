package com.example.binim.kistetevent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name, surename,age,username,password;
    String str_name,  str_surename, str_age, str_username, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.name);
        surename = (EditText)findViewById(R.id.surname);
        age = (EditText)findViewById(R.id.age);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

    }
    public void OnReg(View view) {
        str_name = name.getText().toString();
        str_surename = surename.getText().toString();
        str_age = age.getText().toString();
        str_username= username.getText().toString();
        str_password = password.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_surename,str_age,str_username,str_password);


        name.getText().clear();
        surename.getText().clear();
        age.getText().clear();
        username.getText().clear();
        password.getText().clear();



    }
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}

