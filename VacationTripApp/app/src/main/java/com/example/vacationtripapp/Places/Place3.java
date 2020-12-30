package com.example.vacationtripapp.Places;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.GoogleMaps.map1;
import com.example.vacationtripapp.GoogleMaps.map3;
import com.example.vacationtripapp.R;
import com.example.vacationtripapp.Tours.Tourp1;

public class Place3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place3);
    }
    public void gmap(View view){
        startActivity(new Intent(getApplicationContext(), map3.class));
    }
    public void back(View view){
        startActivity(new Intent(getApplicationContext(), Tourp1.class));
    }
}