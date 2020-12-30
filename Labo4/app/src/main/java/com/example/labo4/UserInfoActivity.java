package com.example.labo4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UserInfoActivity extends AppCompatActivity{


    TextView mDayofBirth;
    EditText mTextUsername;
    EditText mTextAge;
    EditText mTextNumber;
    EditText mGender;
    Button mButtonChangeInf;
    Button mButtonChangePass;
    DatabaseHelper db =null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        db = new DatabaseHelper(this);
        mTextAge = findViewById(R.id.edittext_age);
        mTextUsername = findViewById(R.id.edittext_username);
        mGender = findViewById(R.id.gender);
        mTextNumber = findViewById(R.id.edittext_number);
        mDayofBirth = findViewById(R.id.date_text);
        mButtonChangeInf = findViewById(R.id.change_inf);





        mButtonChangeInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, ChangeInformationActivity.class);
                startActivity(intent);
            }
        });

        mButtonChangePass = (Button) findViewById(R.id.change_pass);
        mButtonChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });



        String username = getIntent().getStringExtra("keyname");
        mTextUsername.setText(username);
        String age = getIntent().getStringExtra("keyage");
        mTextAge.setText(age);
        String sex = getIntent().getStringExtra("keygender");
        mGender.setText(sex);
        String number = getIntent().getStringExtra("keynumber");
        mTextNumber.setText(number);
        String dob = getIntent().getStringExtra("keydob");
        mDayofBirth.setText(dob);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Main activity ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
        public void getData(View v) {
            db = new DatabaseHelper(this);
            Cursor result = db.getdata(mTextUsername.getText().toString());
            while (result.moveToNext()) {
                mDayofBirth.setText(result.getString(0)+" "+result.getString(1));
            }
        }
    }

/*
    public void readUser() {
        Cursor cursor =db.readUser();
        if (cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_SHORT).show();

        }
        else {
            while (cursor.moveToNext()){
                getApplicationContext(),mTextUsername +cursor.getString(1);

                getApplicationContext(),"name:"+cursor.getString(2),Toast.LENGTH_SHORT).show();
                getApplicationContext(),"name:"+cursor.getString(3),Toast.LENGTH_SHORT).show();
            }
        }


    private void displayDatabaseRecord(int id) {
        displayDatabaseRecord(String.valueOf(id));
    }
    private void displayDatabaseRecord(String id) {
        SQLiteDatabase nameDb = db.getWritableDatabase();
        Cursor result = nameDb.rawQuery("select * from registeruser where _ID = ?",
                new String[] { id });
        int rowCount = result.getCount();
        if (rowCount > 0) {
            result.moveToFirst();
            mTextUsername.setText(result.getString(1));
            mTextAge.setText(String.valueOf(result.getInt(0)));
            mTextNumber.setText(result.getString(4));
            mGender.setText(result.getString(5));
            mDayofBirth.setText(result.getString(6));
        }
    }
    private String getName() {
        return mTextUsername.getText().toString();
    }
 /*   private String getAge() {
        return mTextAge.getText().toString();
    }*/
 /*   private String getAge() {
        return mTextAge.getText().toString();
    }
    private String getNumber() {
        return mTextNumber.getText().toString();
    }
    private String getGender() {
        return mGender.getText().toString();
    }
    private String getDob() {
        return mDayofBirth.getText().toString();
    }

    public void onClick(View clicked) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
                displayDatabaseRecord(getName());
        displayDatabaseRecord(getAge());
        displayDatabaseRecord(getNumber());
        displayDatabaseRecord(getGender());
        displayDatabaseRecord(getDob());

        }*/
