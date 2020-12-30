package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    TextView mDayofBirth;
    EditText mTextUsername;
    EditText mTextAge;
    EditText mTextNumber;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    RadioGroup mGender;
    Button mButtonRegister;
    Button mButtonCancel;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.datepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextAge = (EditText) findViewById(R.id.edittext_age);
        mTextNumber = (EditText) findViewById(R.id.edittext_number);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        mDayofBirth = (TextView) findViewById(R.id.date_text);
        mGender = (RadioGroup) findViewById(R.id.gender);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonCancel = (Button) findViewById(R.id.button_cancel);

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(RegisterIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                String age = mTextAge.getText().toString().trim();
                String number = mTextNumber.getText().toString().trim();
                String dob = mDayofBirth.getText().toString().trim();
                RadioButton checkbtn = findViewById(mGender.getCheckedRadioButtonId());
                String gender = checkbtn.getText().toString().trim();


                if (pwd.equals(cnf_pwd)) {
                    long val = db.addUser(user, pwd, age, number, gender, dob);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "Succesfully registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, UserInfoActivity.class);
                        intent.putExtra("keyname", user);
                        intent.putExtra("keydob", dob);
                        intent.putExtra("keygender", gender);
                        intent.putExtra("keyage", age);
                        intent.putExtra("keynumber", number);
                        //intent.putExtra("USERNAME" , user);
                        startActivity(intent);

                    } else {
                        Toast.makeText(RegisterActivity.this, "Register error", Toast.LENGTH_SHORT).show();

                    }


                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
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