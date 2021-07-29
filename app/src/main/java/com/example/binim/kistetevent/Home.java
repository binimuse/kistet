package com.example.binim.kistetevent;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceOnLongClickListener;

public class Home extends AppCompatActivity {

    SpaceNavigationView navigationView;

    /*
    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private View search_bar;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {//if user not logged
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

*/

        /**
         else
         icheckStatus();*/



        //     initToolbar();

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
                Intent ii = new Intent (Home.this,Home.class);

                ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(ii);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(Home.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();


               if(itemIndex==0)
               {
                   Intent ii = new Intent (Home.this,Search.class);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                   startActivity(ii);
               }
               else if(itemIndex==1)
               {
                   Intent ii = new Intent (Home.this,Tickets.class);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                   startActivity(ii);
               }
               else if(itemIndex==2)
               {
                   Intent ii = new Intent (Home.this,Likes.class);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                   startActivity(ii);
               }
               else if(itemIndex==3)
               {
                   Intent ii = new Intent (Home.this,Setting.class);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                   startActivity(ii);
               }

            }


            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(Home.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

                if(itemIndex==0)
                {
                    Intent ii = new Intent (Home.this,Search.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if(itemIndex==2)
                {
                    Intent ii = new Intent (Home.this,Likes.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if(itemIndex==3)
                {
                    Intent ii = new Intent (Home.this,Setting.class);
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
                Toast.makeText(Home.this,"onCentreButtonLongClick", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {
                Toast.makeText(Home.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initToolbar() {
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
  //      getSupportActionBar().setTitle("Basic");
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Tools.setSystemBarColor(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
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
    public void Onevent(View view) {
        Intent i = new Intent (Home.this,Event.class);

        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }
    public void onLocation(View view) {
        Intent i = new Intent (Home.this,location.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

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




