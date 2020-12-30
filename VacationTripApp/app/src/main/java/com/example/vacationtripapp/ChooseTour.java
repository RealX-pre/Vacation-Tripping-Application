package com.example.vacationtripapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.Tours.Tourp1;
import com.example.vacationtripapp.Tours.Tourp3;

public class ChooseTour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tour);
    }


    public void homeScreen(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void tourScreen(View view){
        startActivity(new Intent(getApplicationContext(),ChooseTour.class));
    }
    public void logout (View view){
        startActivity(new Intent(getApplicationContext(),Login.class));
    }



    public void choosehot(View view){
        startActivity(new Intent(getApplicationContext(), Tourp3.class));
    }
    public void chooseaimag(View view){
        startActivity(new Intent(getApplicationContext(), Tourp1.class));
    }


}