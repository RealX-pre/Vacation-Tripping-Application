package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mseeContact;
    Button mseeCalendar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mseeContact = (Button) findViewById(R.id.seecontact);
        mseeCalendar1 = (Button) findViewById(R.id.seecalendar1);
        mseeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, Contact.class);
                startActivity(registerIntent);
            }
        });

  /*      mseeCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, Calendar.class);
                startActivity(registerIntent);
            }
        });*/

        mseeCalendar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public void app(View view){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.labo4");
        if (intent != null){
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this,"There is no package",Toast.LENGTH_LONG).show();
        }


}
}