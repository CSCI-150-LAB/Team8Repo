package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.R;
import com.google.firebase.auth.FirebaseAuth;

public class DealerDashBoard extends AppCompatActivity {
    Button btn_inventory, btn_search, btn_dealericon, btn_logout, btn_reservation;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealerdashboard);

        mAuth = FirebaseAuth.getInstance();

        btn_inventory = (Button)findViewById(R.id.buttonINVENTORY);
        btn_search = (Button)findViewById(R.id.buttonSEARCH);
        btn_logout = (Button)findViewById(R.id.buttonLOGOUT);
        btn_dealericon = (Button)findViewById(R.id.buttonDEALERICON);
        btn_reservation = (Button)findViewById(R.id.buttonRESERVATION);

        btn_inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "GO TO INVENTORY", Toast.LENGTH_SHORT).show();
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "GO TO SEARCH", Toast.LENGTH_SHORT).show();
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "SIGN OUT", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent DealerLogOut = new Intent(DealerDashBoard.this, DealerLogin.class);
                startActivity(DealerLogOut);
            }
        });
        btn_dealericon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "GO TO PROFILE", Toast.LENGTH_SHORT).show();
                Intent Dealer2Profile = new Intent(DealerDashBoard.this, Userprofile.class);
                Dealer2Profile.putExtra("Profile","Dealer");
                startActivity(Dealer2Profile);
            }
        });
        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "GO TO RESERVATION", Toast.LENGTH_SHORT).show();
            }
        });

    }

}