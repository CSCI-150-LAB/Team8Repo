package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    Button btn_cart, btn_settings, btn_reservation, btn_chat, btn_search, btn_logout, btn_calendar, btn_about, btn_profile;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();

        btn_cart = (Button)findViewById(R.id.buttonCART);
        btn_settings = (Button)findViewById(R.id.buttonSETTINGS);
        btn_reservation = (Button)findViewById(R.id.buttonRESERVATION);
        btn_chat = (Button)findViewById(R.id.buttonCHAT);
        btn_search = (Button)findViewById(R.id.buttonSEARCH);
        btn_logout = (Button)findViewById(R.id.buttonlogout);
        btn_calendar = (Button)findViewById(R.id.buttonCALENDAR);
        btn_about = (Button)findViewById(R.id.buttonABOUT);
        btn_profile = (Button)findViewById(R.id.buttonPROFILE);

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO SHOPPING CART", Toast.LENGTH_SHORT).show();
            }
        });
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO SETTINGS", Toast.LENGTH_SHORT).show();
            }
        });
        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "FIND YOUR RESERVED ORDER", Toast.LENGTH_SHORT).show();
            }
        });
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "CHAT WITH US", Toast.LENGTH_SHORT).show();
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO SEARCH", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Logout", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent UserLogout = new Intent(Dashboard.this, Login.class);
                startActivity(UserLogout);
            }
        });
        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO CALENDAR", Toast.LENGTH_SHORT).show();
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "LEARN ABOUT US", Toast.LENGTH_SHORT).show();
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "GO TO YOUR PROFILE", Toast.LENGTH_SHORT).show();
                Intent cus2Profile = new Intent(getApplicationContext(), Userprofile.class);
                cus2Profile.putExtra("Profile", "Customer");
                startActivity(cus2Profile);
            }
        });

    }
}