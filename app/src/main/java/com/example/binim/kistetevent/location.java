package com.example.binim.kistetevent;

import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.plus.People;

import java.util.ArrayList;
import java.util.List;

public class location extends AppCompatActivity  {

    private View parent_view;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void Onserch(View view) {
        Intent i = new Intent (location.this,SearchEvet.class);
        startActivity(i);

    }
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            startActivity(new Intent(getApplicationContext(),Home.class));
        } else {
            Toast.makeText(this, "Press Back again to HOME.",
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