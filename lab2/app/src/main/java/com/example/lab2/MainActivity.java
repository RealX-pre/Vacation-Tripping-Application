package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private EditText result ,number1 , number2;
    private Button subtract,divide,multiply ,add ;
    float result_num;
    int num1 , num2 ;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText)findViewById(R.id.etResult);
        number1 = (EditText)findViewById(R.id.etValueA);
        number2 = (EditText)findViewById(R.id.etValueB);

        add = (Button)findViewById(R.id.btAdd);
        subtract = (Button)findViewById(R.id.btSub);
        multiply = (Button)findViewById(R.id.btMulti);
        divide = (Button)findViewById(R.id.btDivide);



        Log.i("Button", "onCreate: Its done");
        Log.e("error", "onCreate: Failed");
        Log.d("debug", "onCreate: Working!");
        Log.w("warning", "onCreate: Be warning");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 + num2 ;
                result.setText(String.valueOf(result_num));



            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = (num1 - num2) ;
                result.setText(String.valueOf(result_num));
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 * num2 ;
                result.setText(String.valueOf(result_num));
            }

        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 / num2 ;
                result.setText(String.valueOf(result_num));
            }

        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.main_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 + num2 ;
                result.setText(String.valueOf(result_num));
                return true;
            case R.id.menuDivide:
                Toast.makeText(this, "Divided", Toast.LENGTH_SHORT).show();
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 / num2 ;
                result.setText(String.valueOf(result_num));
                return true;
            case R.id.menuMultiply:
                Toast.makeText(this, "Multiplied", Toast.LENGTH_SHORT).show();
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 * num2 ;
                result.setText(String.valueOf(result_num));
                return true;
            case R.id.menuSub:
                Toast.makeText(this, "Subtracionad", Toast.LENGTH_SHORT).show();
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                result_num = num1 - num2 ;
                result.setText(String.valueOf(result_num));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}