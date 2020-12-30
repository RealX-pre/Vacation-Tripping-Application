package com.example.vacationtripapp.Tours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vacationtripapp.ChooseTour;
import com.example.vacationtripapp.Login;
import com.example.vacationtripapp.MainActivity;
import com.example.vacationtripapp.Places.Place10;
import com.example.vacationtripapp.R;

public class Tourp4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourp4);
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

    public void tobackpage1hot(View view){
        startActivity(new Intent(getApplicationContext(), Tourp3.class));
    }

    public void hot5(View view){
        startActivity(new Intent(getApplicationContext(), Place10.class));
    }
}