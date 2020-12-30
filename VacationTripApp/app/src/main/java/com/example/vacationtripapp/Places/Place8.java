package com.example.vacationtripapp.Places;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.GoogleMaps.map1;
import com.example.vacationtripapp.GoogleMaps.map8;
import com.example.vacationtripapp.R;
import com.example.vacationtripapp.Tours.Tourp3;

public class Place8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place8);
    }
    public void gmap(View view){
        startActivity(new Intent(getApplicationContext(), map8.class));
    }
    public void back(View view){
        startActivity(new Intent(getApplicationContext(), Tourp3.class));
    }
}