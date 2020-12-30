package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button changePassword;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        changePassword = (Button) findViewById(R.id.button_changepassword);
        db = new DatabaseHelper(this);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString();
                String pwd = mTextPassword.getText().toString();
                Boolean checkuser = db.checkUser(user ,pwd );
                if (checkuser == true){
                    Intent intent = new Intent(getApplicationContext(), Changed.class);
                    intent.putExtra("username" , user);
                    intent.putExtra("password" , pwd);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(ChangePasswordActivity.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

       /* String username = getIntent().getStringExtra("keyname");
        mTextUsername.setText(username);*/



    }

    }
