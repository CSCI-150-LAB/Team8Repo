package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLOGIN;
    Button btn2REGISTER;


    String correct_username = "customer";
    String correct_password = "mycars1234";

    DBHelper DB;

    //String correct_username = "customer";
    //String correct_password = "mycars1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLOGIN = findViewById(R.id.button);
        btn2REGISTER = findViewById(R.id.button2);

        DB = new DBHelper(this);


        btnLOGIN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")|pass.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter login info", Toast.LENGTH_SHORT).show();

                }
                else{
                    Boolean checkUserAndPass = DB.checkUserPassword(user,pass);
                    if(checkUserAndPass == true) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        //write an intent to move to Dashboard here
                    }
                    else
                        Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2REGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}