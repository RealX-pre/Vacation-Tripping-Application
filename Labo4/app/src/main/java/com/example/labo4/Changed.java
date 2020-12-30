package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Changed extends AppCompatActivity {
    TextView mTextUsername;
    TextView mTextOldpassword;
    EditText mTextNewpassword;
    EditText mTextCnfNewpassword;
    Button confirmPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changed);
        db = new DatabaseHelper(this);
        mTextUsername = (TextView) findViewById(R.id.edittext_username);
        mTextOldpassword = (TextView) findViewById(R.id.edittext_password);
        mTextNewpassword = (EditText) findViewById(R.id.edittext_newpassword);
        mTextCnfNewpassword = (EditText) findViewById(R.id.edittext_cnfnewpassword);
        confirmPassword = (Button) findViewById(R.id.button_confirm);

        Intent intent = getIntent();
        mTextUsername.setText(intent.getStringExtra("username"));
        mTextOldpassword.setText(intent.getStringExtra("password"));
        confirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString();
                String password  = mTextNewpassword.getText().toString();
                String cnfpassword = mTextCnfNewpassword.getText().toString();
                if (password.equals(cnfpassword)) {

                    Boolean checkPasswordupdate = db.updatePassword(user,password);
                    if (checkPasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Changed.this, "Successfully changed", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText( Changed.this, "Not Successfully changed", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText( Changed.this, "Password is not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}