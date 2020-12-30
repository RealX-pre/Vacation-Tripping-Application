package com.example.vacationtripapp.Tours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.ChooseTour;
import com.example.vacationtripapp.Login;
import com.example.vacationtripapp.MainActivity;
import com.example.vacationtripapp.Places.Place6;
import com.example.vacationtripapp.Places.Place7;
import com.example.vacationtripapp.Places.Place8;
import com.example.vacationtripapp.Places.Place9;
import com.example.vacationtripapp.R;

public class Tourp3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourp3);

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

    public void tonextpage2hot(View view){
        startActivity(new Intent(getApplicationContext(), Tourp4.class));
    }


    public void hot1(View view){
        startActivity(new Intent(getApplicationContext(), Place6.class));
    }
    public void hot2(View view){
        startActivity(new Intent(getApplicationContext(), Place7.class));
    }
    public void hot3(View view){
        startActivity(new Intent(getApplicationContext(), Place8.class));
    }
    public void hot4(View view){
        startActivity(new Intent(getApplicationContext(), Place9.class));
    }
}