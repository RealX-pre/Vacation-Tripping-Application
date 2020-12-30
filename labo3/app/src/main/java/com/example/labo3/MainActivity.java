package com.example.labo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void startfirst (View v){
        startActivity(new Intent(MainActivity.this,ac1.class));
    }
    public void startsecond (View v){
        startActivity(new Intent(MainActivity.this,ac2.class));
    }
    public void startthird (View v){
        startActivity(new Intent(MainActivity.this,ac3.class));
    }
    public void startfourth (View v){
        startActivity(new Intent(MainActivity.this,ac4.class));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ac1) {
        Intent intent = new Intent(MainActivity.this, ac1.class);
        startActivity(intent);
        finish();
        return true;

    }
        if (id == R.id.ac2) {
            Intent intent = new Intent(MainActivity.this, ac2.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.ac3) {
            Intent intent = new Intent(MainActivity.this, ac3.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.ac4) {
            Intent intent = new Intent(MainActivity.this, ac4.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}

