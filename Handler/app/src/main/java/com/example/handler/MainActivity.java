package com.example.handler;

import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar progressBar;
    TextView textMsg;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress);
        textMsg = (TextView)findViewById(R.id.msg);

        btnStart = (Button)findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyThread myThread = new MyThread(progressBar, textMsg);
                myThread.start();
            }
        });
    }

    class MyThread extends Thread{

        ProgressBar pBar;
        TextView tMsg;

        public MyThread(ProgressBar pBar, TextView tMsg) {
            super();
            this.pBar = pBar;
            this.tMsg = tMsg;
        }

        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String dateTime =  simpleDateFormat.format(calendar.getTime());
            int M=2;
            int N=3;
                for (int i = 0; i <= 10; i++) {
                    Log.d("TAG", "doInBackground:index " + i);
                    Log.d("TAG", "doInBackground:1-gishuun " + N + i * M);
                    Log.d("TAG", "doInBackground:realTime " + dateTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    final int finalI = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pBar.setProgress(finalI);
                        }
                    });
                }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tMsg.setText("Done");
                }
            });
        }
    }
}