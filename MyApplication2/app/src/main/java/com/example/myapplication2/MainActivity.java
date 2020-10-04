package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLOGIN = findViewById(R.id.button);
        btn2REGISTER = findViewById(R.id.button2);

        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_LONG).show();
                } else if (username.getText().toString().equals(correct_username)) {
                    if ((password.getText().toString().equals(correct_password))) {

                        Toast.makeText(MainActivity.this, "Successful Username/Password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}