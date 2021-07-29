package com.example.binim.kistetevent;

import android.*;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceOnLongClickListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import static com.example.binim.kistetevent.MainActivity.mypreference;
import static java.text.DateFormat.getInstance;

public class Setting extends AppCompatActivity {

    SpaceNavigationView navigationView;
    SharedPreferences sharedpreferences;
    CircularImageView circularImageView;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSIOn_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Tools.setSystemBarColor(this, android.R.color.white);
        Tools.setSystemBarLight(this);

            circularImageView =  (CircularImageView)findViewById(R.id.bt_pic);

        navigationView = findViewById(R.id.space);

        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_search_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_bookmark_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_favorite_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_more_vert_black_24dp));

        //  initComponent();





        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                //  Toast.makeText(Home.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Setting.this, Home.class);

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(Setting.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();


                if (itemIndex == 0) {
                    Intent i = new Intent(Setting.this, Search.class);

                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);

                }
                else if(itemIndex==1)
                {
                    Intent ii = new Intent (Setting.this,Tickets.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if(itemIndex==2)
                {
                    Intent ii = new Intent (Setting.this,Likes.class);

                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }else if (itemIndex == 3) {
                    Intent ii = new Intent(Setting.this, Setting.class);

                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }

            }


            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(Setting.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

                if (itemIndex == 0) {
                    Intent i = new Intent(Setting.this, Search.class);
                    startActivity(i);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }

                else if(itemIndex==1)
                {
                    Intent ii = new Intent (Setting.this,Tickets.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if(itemIndex==2) {
                    Intent ii = new Intent(Setting.this, Likes.class);

                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if (itemIndex == 3) {
                    Intent ii = new Intent(Setting.this, Setting.class);

                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
            }
        });




        navigationView.setSpaceOnLongClickListener(new SpaceOnLongClickListener() {
            @Override
            public void onCentreButtonLongClick() {
                Toast.makeText(Setting.this, "onCentreButtonLongClick", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {
                Toast.makeText(Setting.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void pic(View view) {



            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
                {
                    String[] permission = {android.Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permission,PERMISSIOn_CODE);
                }
                else{
                    PickimagefromGallery();
                }}
            else
            {
                PickimagefromGallery();
            }
        }

    private void PickimagefromGallery() {


        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case PERMISSIOn_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PickimagefromGallery();

                }
                else{
                    Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_add_post);
            dialog.setCancelable(true);
            circularImageView.setImageURI(data.getData());
        }
    }

    public void onLogout(View view) {

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(new Intent(getApplicationContext(),Splash.class));
        finish();


    }
    public void Onmanage(View view) {


        startActivity(new Intent(getApplicationContext(),Manage.class));
        finish();


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