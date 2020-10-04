package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username, password, repassword;
    Button Register;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.RegisterUserName);
        password = findViewById(R.id.RegisterPassword);
        repassword = findViewById(R.id.RegisterRePassword);
        Register = findViewById(R.id.RegisterBtm);
        DB = new DBHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")|pass.equals("")){
                    Toast.makeText(Register.this,"Please fill in info", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(repass)) {
                        boolean checkUser = DB.checkUserName(user);
                        if (checkUser == false) {
                            Boolean insert = DB.InsertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Register.this, "Register successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Register fail", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register.this, "User already exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}