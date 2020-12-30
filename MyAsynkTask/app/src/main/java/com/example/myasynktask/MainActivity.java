package com.example.myasynktask;

import android.os.AsyncTask;
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
                MyAsyncTask myAsyncTask = new MyAsyncTask(progressBar, textMsg);
                myAsyncTask.execute();
            }
        });
    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Void>{

        ProgressBar pBar;
        TextView tMsg;

        public MyAsyncTask(ProgressBar pBar, TextView tMsg) {
            super();
            this.pBar = pBar;
            this.tMsg = tMsg;
        }

        @Override
        protected Void doInBackground(Void... params) {
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

                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            tMsg.setText("Done");
        }
    }
}