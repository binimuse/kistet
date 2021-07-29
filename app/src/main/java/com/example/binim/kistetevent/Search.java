package com.example.binim.kistetevent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.luseen.spacenavigation.SpaceOnLongClickListener;

public class Search extends AppCompatActivity {
    SpaceNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

      final  AutoCompleteTextView autoCompleteTextView1=(AutoCompleteTextView)findViewById(R.id.auto1);
      final  AutoCompleteTextView autoCompleteTextView2=(AutoCompleteTextView)findViewById(R.id.auto2);
       final AutoCompleteTextView autoCompleteTextView3=(AutoCompleteTextView)findViewById(R.id.auto3);

      //  Button button =(Button)findViewById(R.id.button);


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,go);
        autoCompleteTextView1.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,in);
        autoCompleteTextView2.setAdapter(arrayAdapter2);

        ArrayAdapter arrayAdapter3=new ArrayAdapter(this,android.R.layout.simple_list_item_1,forr);
        autoCompleteTextView3.setAdapter(arrayAdapter3);

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                autoCompleteTextView1.showDropDown();
            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                autoCompleteTextView2.showDropDown();
            }
        });
        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                autoCompleteTextView3.showDropDown();
            }
        });

        autoCompleteTextView1.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            autoCompleteTextView1.showDropDown();
        }
        });
        autoCompleteTextView2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                autoCompleteTextView2.showDropDown();
            }
        });
        autoCompleteTextView3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                autoCompleteTextView3.showDropDown();
            }
        });

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
                Intent i = new Intent (Search.this,Home.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(Search.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();


                if(itemIndex==0)
                {
                    Intent i = new Intent (Search.this,Search.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }
                else if(itemIndex==1)
                {
                    Intent ii = new Intent (Search.this,Tickets.class);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ii.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(ii);
                }
                else if(itemIndex==2)
                {
                    Intent i = new Intent (Search.this,Likes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);

                }
                else if(itemIndex==3)
                {
                    Intent i = new Intent (Search.this,Setting.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }

            }


            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(Search.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

                if(itemIndex==0)
                {
                    Intent i = new Intent (Search.this,Search.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }
                else if(itemIndex==2)
                {
                    Intent i = new Intent (Search.this,Likes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }

                else if(itemIndex==3)
                {
                    Intent i = new Intent (Search.this,Setting.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }
            }
        });




        navigationView.setSpaceOnLongClickListener(new SpaceOnLongClickListener() {
            @Override
            public void onCentreButtonLongClick() {
                Toast.makeText(Search.this,"onCentreButtonLongClick", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {
                Toast.makeText(Search.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }




    public void Onserch(View view) {
        Intent i = new Intent (Search.this,SearchEvet.class);
        startActivity(i);

    }


    private static final String[] go= new String[]{"Anytime","Today","Tomorrow","This weekend","in the next month"};
    private static final String[] in= new String[]{"Adids Ababa","Gonder","Dire Dawa","Hawassa","Bahir Dar","Jimma","Bishoftu","Mekelle"};
    private static final String[] forr= new String[]{"Anything","Music","Food & Drink","Party","Art & Entertement","Bussiness","Tec","Tour","Sport","Fashion"};

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