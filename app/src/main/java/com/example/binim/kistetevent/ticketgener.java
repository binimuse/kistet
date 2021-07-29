package com.example.binim.kistetevent;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class ticketgener extends AppCompatActivity {

    TextView txt_phone,btn_login,rundom;
    ImageView qrcode;
    int rundomnumber;
    String TAG = "GenrateQrCode";
    String inputvalue;
    Bitmap bitmap;
    QRGEncoder qrencoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketgener);


        rundom  = (TextView) findViewById(R.id.rundom);
        qrcode = (ImageView) findViewById(R.id.qrcode);
        btn_login = (TextView) findViewById(R.id.btn_login);
        txt_phone = (TextView)findViewById(R.id.txt_phone);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        Tools.setSystemBarLight(this);


        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {



        inputvalue=txt_phone.getText().toString().trim();
        if(inputvalue.length() > 0)
        {
            WindowManager manager = (WindowManager)getSystemService(WINDOW_SERVICE);
            Display display= manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int wwidth=point.x;
            int hight=point.y;
            int smalerdimmesion = wwidth<hight ? wwidth:hight;
            smalerdimmesion=smalerdimmesion*3/4;
            qrencoder= new QRGEncoder("Kistet orginal tickate "+inputvalue,null, QRGContents.Type.TEXT,smalerdimmesion);
            try{

                bitmap=qrencoder.encodeAsBitmap();
                qrcode.setImageBitmap(bitmap);

                Random random = new Random();
                rundomnumber = random.nextInt(999999);
                int a =rundomnumber;
                String b=String.valueOf(a);

              rundom.setText(b);


            }catch (WriterException e)
            {
                Log.v(TAG,e.toString());
            }
        }
        else
        {
        txt_phone.setText("Required");
        }







        // Construct data
        /*
        String apiKey = "apikey=" + "Q0k8rQ7fXrE-bFzhWoVozPM8mv1emS3qLyBWiQQW9T";
        Random random = new Random();
        rundomnumber = random.nextInt(999999);
        String message = "&message=" + rundomnumber + " This is your Event Enternace Number from Kistet ";
        String sender = "&sender=" + "Kistet";
        String numbers = "&numbers=" + txt_phone.getText().toString();

        // Send data

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String data = apiKey + numbers + message + sender;
        conn.setDoOutput(true);
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e1) {
            e1.printStackTrace();
        }
        conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
        try {
            conn.getOutputStream().write(data.getBytes("UTF-8"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        final StringBuffer stringBuffer = new StringBuffer();
        String line;
        try {
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);

            }

            rd.close();
            Toast.makeText(ticketgener.this, "OTP send succesfullly", Toast.LENGTH_SHORT).show();
            //return stringBuffer.toString();
        } catch (Exception e) {
            // System.out.println("Error SMS "+e);
            // return "Error "+e;
            Toast.makeText(ticketgener.this, "OTP not send cuz of"+e, Toast.LENGTH_SHORT).show();

        }
    }
*/
    }
});

}
}
