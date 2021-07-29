package com.example.binim.kistetevent;

import android.*;
import android.Manifest;
import android.app.DatePickerDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v13.app.FragmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.time.CircleView;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Locale;
import java.util.jar.*;


import static com.example.binim.kistetevent.MainActivity.mypreference;
import static com.example.binim.kistetevent.R.id.imageView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class createevent extends AppCompatActivity {
    DatePicker datePicker,datePicker2;
    ImageView cc;
    EditText edittext,edittext2,text2,text3,text4,Birthday,Birthday2,text7,text8,text9,etpost,etpost2,etpost3,etpost4,etpost5,etpost6,etpost7;
    TextView text,textView2,textView3,textt=null,result,result2=null;
    Button editText3;
    Button editText4 ;
    CircleView image;
    ImageButton btn_photo;
    String pw = "hihi";
    static String a;


    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSIOn_CODE = 1001;

            String  b= null,c= null,d= null,e= null,f= null,g= null,h= null,i= null;
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createevent);


       // initToolbar();
        textView2= (TextView) findViewById(R.id.result);
        textView3= (TextView) findViewById(R.id.result2);



      //  image= (CircleView)
        btn_photo = (ImageButton) findViewById(R.id.bt_photo);



        text = (TextView) findViewById(R.id.text);
        text2 = (EditText) findViewById(R.id.text2);
        text3 = (EditText) findViewById(R.id.text3);
        text4 = (EditText) findViewById(R.id.text4);
        Birthday = (EditText) findViewById(R.id.Birthday);
        Birthday2 = (EditText) findViewById(R.id.Birthday2);
        result = (TextView) findViewById(R.id.result);
        result2 = (TextView) findViewById(R.id.result2);

       //


        textt = (TextView) findViewById(R.id.texttu);
        etpost2 = (EditText) findViewById(R.id.et_post2);
        etpost3 = (EditText) findViewById(R.id.et_post3);
        etpost4 = (EditText) findViewById(R.id.et_post4);
        etpost5 = (EditText) findViewById(R.id.et_post5);
        etpost6 = (EditText) findViewById(R.id.et_post6);
        etpost7 = (EditText) findViewById(R.id.et_post7);















    }



    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();

        }

    };
    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel2();
           // updateLabel2();
        }

    };

    public void Onclik2(View view) {

        new DatePickerDialog(createevent.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();


    }
    public void Onclik(View view) {

        new DatePickerDialog(createevent.this, date2, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();


    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Birthday2.setText(sdf.format(myCalendar.getTime()));
       // edittext2.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel2() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        Birthday.setText(sdf.format(myCalendar.getTime()));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_done, menu);
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


    public void Onclik4(View view) {
        {
            dialogTimePickerLight((Button) view);


        }

    }

    private void dialogTimePickerLight(final Button bt) {
        Calendar cur_calender = Calendar.getInstance();
        com.wdullaer.materialdatetimepicker.time.TimePickerDialog datePicker = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                ((TextView) findViewById(R.id.result)).setText(hourOfDay + " : " + minute);
            }
        }, cur_calender.get(Calendar.HOUR_OF_DAY), cur_calender.get(Calendar.MINUTE), true);
        //set dark light
        datePicker.setThemeDark(false);
        datePicker.setAccentColor(getResources().getColor(R.color.colorPrimary));
        datePicker.show(getFragmentManager(), "Timepickerdialog");
    }

    public void Onclik5(View view) {
        {
            dialogTimePickerLight2((Button) view);


        }

    }

    private void dialogTimePickerLight2(final Button bt) {
        Calendar cur_calender = Calendar.getInstance();
        com.wdullaer.materialdatetimepicker.time.TimePickerDialog datePicker = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                ((TextView) findViewById(R.id.result2)).setText(hourOfDay + " : " + minute);
            }
        }, cur_calender.get(Calendar.HOUR_OF_DAY), cur_calender.get(Calendar.MINUTE), true);
        //set dark light
        datePicker.setThemeDark(false);
        datePicker.setAccentColor(getResources().getColor(R.color.colorPrimary));
        datePicker.show(getFragmentManager(), "Timepickerdialog");
    }

    public void OnCreateEvent(View view) {
        {
            showCustomDialog();


        }}

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_post);
        dialog.setCancelable(true);



        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;




        if(text.getText().toString()!="")
        {
           b = text.getText().toString();
            final TextView c = (TextView) dialog.findViewById(R.id.texttu);
            c.setText(b);
        }
        if(text2.getText().toString()!="")
        {
            c = text2.getText().toString();
            final TextView cc = (TextView) dialog.findViewById(R.id.et_post);
            cc.setText(c);
        }
        if(text3.getText().toString()!="")
        {
            d = text3.getText().toString();
            final TextView cc2 = (TextView) dialog.findViewById(R.id.et_post2);
            cc2.setText(d);
        }
        if(text4.getText().toString()!="")
        {
            e = text4.getText().toString();
            final TextView cc3 = (TextView) dialog.findViewById(R.id.et_post3);
            cc3.setText(e);
        }
        if(Birthday.getText().toString()!="")
        {
            f = Birthday.getText().toString();
            final TextView cc4 = (TextView) dialog.findViewById(R.id.et_post4);
            cc4.setText(f);
        }
        if(Birthday2.getText().toString()!="")
        {
            g = Birthday2.getText().toString();
            final TextView cc5 = (TextView) dialog.findViewById(R.id.et_post5);
            cc5.setText(g);
        }
        if(result.getText().toString()!="")
        {
            h = result.getText().toString();
            final TextView cc6 = (TextView) dialog.findViewById(R.id.et_post6);
            cc6.setText(h);
        }
        if(result2.getText().toString()!="")
        {
            i = result2.getText().toString();
            final TextView cc7 = (TextView) dialog.findViewById(R.id.et_post7);
            cc7.setText(h);

        }
        else {
            final TextView c = (TextView) dialog.findViewById(R.id.texttu);
            final TextView c2 = (TextView) dialog.findViewById(R.id.texttu);
            c.setText("please Insert your text here");
            c.setText("please Insert your text here ");
        }

        final AppCompatButton bt_submit = (AppCompatButton) dialog.findViewById(R.id.bt_submit);

        final ImageButton hoo = (ImageButton) dialog.findViewById(R.id.bt_photo);





        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Post Submitted", Toast.LENGTH_SHORT).show();
            }
        });



        ((ImageButton) dialog.findViewById(R.id.bt_photo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_submit.setEnabled(true);
             if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                 if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
                 {
                    String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
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







        });



        ((ImageButton) dialog.findViewById(R.id.bt_setting)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Post Setting Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
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
            cc.setImageURI(data.getData());
        }

    }
}



