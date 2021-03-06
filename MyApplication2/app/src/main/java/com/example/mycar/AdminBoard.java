package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mycar.R;
import com.google.firebase.auth.FirebaseAuth;

public class AdminBoard extends AppCompatActivity {
    Button btn_adminuser, btn_fees, btn_logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminboard);
        btn_adminuser = (Button)findViewById(R.id.buttonADMINUSER);
        btn_fees = (Button)findViewById(R.id.buttonFEES);
        btn_logout = (Button)findViewById(R.id.buttonLOGOUT);

        mAuth = FirebaseAuth.getInstance();

        btn_adminuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(com.example.mycar.AdminBoard.this, "GO TO PAGE TO ADD/DELETE USERS", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminBoard.this, AdminModUser.class);
                startActivity(intent);
            }
        });
        btn_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(com.example.mycar.AdminBoard.this, "GO TO FEES PAGE", Toast.LENGTH_SHORT).show();
                Intent editFees = new Intent(AdminBoard.this, AdminModFee.class);
                startActivity(editFees);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(com.example.mycar.AdminBoard.this, "SIGN OUT", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent AdminOut = new Intent(AdminBoard.this, AdminLogin.class);
                startActivity(AdminOut);
                finish();
            }
        });
    }
}