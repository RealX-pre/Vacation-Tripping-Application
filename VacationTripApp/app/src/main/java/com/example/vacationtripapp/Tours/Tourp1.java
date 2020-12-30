package com.example.vacationtripapp.Tours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.ChooseTour;
import com.example.vacationtripapp.Login;
import com.example.vacationtripapp.MainActivity;
import com.example.vacationtripapp.Places.Place1;
import com.example.vacationtripapp.Places.Place2;
import com.example.vacationtripapp.Places.Place3;
import com.example.vacationtripapp.Places.Place4;
import com.example.vacationtripapp.R;

public class Tourp1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourp1);


    }
    public void homeScreen(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void tourScreen(View view){
        startActivity(new Intent(getApplicationContext(), ChooseTour.class));
    }
    public void logout (View view){
        startActivity(new Intent(getApplicationContext(), Login.class));
    }


    public void tonextpage2aimag(View view){
        startActivity(new Intent(getApplicationContext(), Tourp2.class));
    }




    public void aimag1(View view){
        startActivity(new Intent(getApplicationContext(), Place1.class));
    }
    public void aimag2(View view){
        startActivity(new Intent(getApplicationContext(), Place2.class));
    }
    public void aimag3(View view){
        startActivity(new Intent(getApplicationContext(), Place3.class));
    }
    public void aimag4(View view){
        startActivity(new Intent(getApplicationContext(), Place4.class));
    }
}