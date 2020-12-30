package com.example.vacationtripapp.Places;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.GoogleMaps.map1;
import com.example.vacationtripapp.GoogleMaps.map10;
import com.example.vacationtripapp.R;
import com.example.vacationtripapp.Tours.Tourp4;

public class Place10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place10);
    }
    public void gmap(View view){
        startActivity(new Intent(getApplicationContext(), map10.class));
    }
    public void back(View view){
        startActivity(new Intent(getApplicationContext(), Tourp4.class));
    }
}