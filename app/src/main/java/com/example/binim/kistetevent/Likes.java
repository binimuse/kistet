package com.example.binim.kistetevent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceOnLongClickListener;

public class Likes extends AppCompatActivity {
    SpaceNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

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
                Intent ii = new Intent(Likes.this, Home.class);
                ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(ii);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(Likes.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();


                if (itemIndex == 0) {
                    Intent ii = new Intent(Likes.this, Search.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }

                else if(itemIndex==1)
                {
                    Intent ii = new Intent (Likes.this,Tickets.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if (itemIndex == 2) {

                    Intent ii = new Intent(Likes.this, Likes.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                } else if (itemIndex == 3) {
                    Intent ii = new Intent(Likes.this, Setting.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }

            }


            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(Likes.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

                if (itemIndex == 0) {
                    Intent ii = new Intent(Likes.this, Search.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                } else if (itemIndex == 3) {
                    Intent ii = new Intent(Likes.this, Setting.class);
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
                Toast.makeText(Likes.this, "onCentreButtonLongClick", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {
                Toast.makeText(Likes.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

        });
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
    public void Onserch(View view) {
        Intent i = new Intent (Likes.this,SearchEvet.class);
        startActivity(i);

    }
}
