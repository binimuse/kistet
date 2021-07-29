package com.example.binim.kistetevent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Manage extends AppCompatActivity {
    private static final int MAX_STEP = 4;

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private Button btnNext;
    private String about_title_array[] = {
            "Welcome to Event Organiser",
            "Track ticket sales",
            "Edit events on-the-go",
            "Enjoy"
    };
    private String about_description_array[] = {
            "Your one-stop-shop for managing your events from anywhere",
            "Access to real-time data keeps you in control of your ticket sales",
            "Change information like title,tickets and descripion from your post.",
            "",
    };
    private int about_images_array[] = {
            R.drawable.img_wizard_1,
            R.drawable.img_wizard_2,
            R.drawable.img_wizard_3,
            R.drawable.img_wizard_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);


                initComponent();
                Tools.setSystemBarColor(this, R.color.grey_5);
                Tools.setSystemBarLight(this);
            }

            private void initComponent() {
                viewPager = (ViewPager) findViewById(R.id.view_pager);
                btnNext = (Button) findViewById(R.id.btn_next);

                // adding bottom dots
                bottomProgressDots(0);

                myViewPagerAdapter = new MyViewPagerAdapter();
                viewPager.setAdapter(myViewPagerAdapter);
                viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int current = viewPager.getCurrentItem() + 1;
                        if (current < MAX_STEP) {
                            // move to next screen
                            viewPager.setCurrentItem(current);
                        } else {
                            startActivity(new Intent(getApplicationContext(),ManageEvent.class));
                        }
                    }
                });

                ((ImageButton)findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(getApplicationContext(),ManageEvent.class));

                    }
                });

            }

            private void bottomProgressDots(int current_index) {
                LinearLayout dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
                ImageView[] dots = new ImageView[MAX_STEP];

                dotsLayout.removeAllViews();
                for (int i = 0; i < dots.length; i++) {
                    dots[i] = new ImageView(this);
                    int width_height = 15;
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
                    params.setMargins(10, 10, 10, 10);
                    dots[i].setLayoutParams(params);
                    dots[i].setImageResource(R.drawable.shape_circle);
                    dots[i].setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
                    dotsLayout.addView(dots[i]);
                }

                if (dots.length > 0) {
                    dots[current_index].setImageResource(R.drawable.shape_circle);
                    dots[current_index].setColorFilter(getResources().getColor(R.color.orange_400), PorterDuff.Mode.SRC_IN);
                }
            }

            //  viewpager change listener
            ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageSelected(final int position) {
                    bottomProgressDots(position);

                    if (position == about_title_array.length - 1) {
                        btnNext.setText(getString(R.string.GOT_IT));
                        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        btnNext.setTextColor(Color.WHITE);

                    } else {
                        btnNext.setText(getString(R.string.NEXT));
                        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        btnNext.setTextColor(getResources().getColor(R.color.grey_90));
                    }
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {

                }

                @Override
                public void onPageScrollStateChanged(int arg0) {

                }
            };

            /**
             * View pager adapter
             */
            public class MyViewPagerAdapter extends PagerAdapter {
                private LayoutInflater layoutInflater;

                public MyViewPagerAdapter() {
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    View view = layoutInflater.inflate(R.layout.item_stepper_wizard, container, false);
                    ((TextView) view.findViewById(R.id.title)).setText(about_title_array[position]);
                    ((TextView) view.findViewById(R.id.description)).setText(about_description_array[position]);
                    ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
                    container.addView(view);

                    return view;
                }

                @Override
                public int getCount() {
                    return about_title_array.length;
                }

                @Override
                public boolean isViewFromObject(View view, Object obj) {
                    return view == obj;
                }


                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    View view = (View) object;
                    container.removeView(view);
                }
            }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            startActivity(new Intent(getApplicationContext(),Setting.class));
        } else {
            Toast.makeText(this, "Press Back again to go back.",
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
