package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button User, Dealer, Admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User = findViewById(R.id.Userbtm);
        Dealer = findViewById(R.id.Dealerbtm);
        Admin = findViewById(R.id.Adminbtm);

        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toUser = new Intent(Home.this, Login.class);
                startActivity(toUser);
            }
        });

        Dealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDealer = new Intent(Home.this, DealerLogin.class);
                startActivity(toDealer);
            }
        });

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAdmin = new Intent(Home.this, AdminLogin.class);
                startActivity(toAdmin);
            }
        });
    }
}