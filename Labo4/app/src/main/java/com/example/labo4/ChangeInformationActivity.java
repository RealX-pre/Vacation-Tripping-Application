package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ChangeInformationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    TextView mDayofBirth;
    EditText mTextUsername;
    EditText mTextAge;
    EditText mTextNumber;
    EditText mGender;
    EditText mTextPassword;
    Button mButtonChangeInf;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_information);
        findViewById(R.id.datepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        db = new DatabaseHelper(this);
        mTextAge = findViewById(R.id.edittext_age);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword = findViewById(R.id.edittext_password);
        mGender = findViewById(R.id.gender);
        mTextNumber = findViewById(R.id.edittext_number);
        mDayofBirth  = findViewById(R.id.date_text);
        mButtonChangeInf = findViewById(R.id.updateData);
       UpdateData();

    }
    public void UpdateData(){
        mButtonChangeInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdate = db.updateData(mTextPassword.getText().toString(),mTextUsername.getText().toString(),mTextAge.getText().toString(),mTextNumber.getText().toString(),mGender.getText().toString(),mDayofBirth.getText().toString());
                if (isUpdate == true){
                    Toast.makeText(ChangeInformationActivity.this, "Data uptaded", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChangeInformationActivity.this, "Data not updated", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        mDayofBirth.setText(date);
    }
}