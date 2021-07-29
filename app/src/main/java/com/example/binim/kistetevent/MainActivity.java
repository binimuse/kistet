package com.example.binim.kistetevent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    EditText usernamet, passwordet;
    CheckBox remeber;
    SharedPreferences sharedpreferences;
    private View parent_view;
    public static final String mypreference = "mypref";
    public static String Name = "nameKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        if (sharedpreferences.contains(Name)) {
            //  usernamet.setText(sharedpreferences.getString(Name, ""));
            Intent ihelp = new Intent(MainActivity.this, Home.class);
            startActivity(ihelp);

        } else {


            usernamet = (EditText) findViewById(R.id.etUsername);
            passwordet = (EditText) findViewById(R.id.etPassword);
            remeber = (CheckBox) findViewById(R.id.ch_rememberme);

            parent_view = findViewById(android.R.id.content);

            Tools.setSystemBarColor(this, android.R.color.white);
            Tools.setSystemBarLight(this);


            ((View) findViewById(R.id.sign_up_for_account)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //     Snackbar.make(parent_view, "Sign up for an account", Snackbar.LENGTH_SHORT).show();
                }
            });


        }}


    public void OnLogin(View view) {

        String username = usernamet.getText().toString();
        String password = passwordet.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, username);
        editor.commit();

        //  usernamet.getText().clear();
        // passwordet.getText().clear();


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



