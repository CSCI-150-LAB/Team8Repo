package com.example.myapplication17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_adminuser, btn_fees, btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_adminuser = (Button)findViewById(R.id.buttonADMINUSER);
        btn_fees = (Button)findViewById(R.id.buttonFEES);
        btn_logout = (Button)findViewById(R.id.buttonLOGOUT);

        btn_adminuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "GO TO PAGE TO ADD/DELETE USERS", Toast.LENGTH_SHORT).show();
            }
        });
        btn_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "GO TO FEES PAGE", Toast.LENGTH_SHORT).show();
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "SIGN OUT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}