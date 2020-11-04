package com.example.myapplication15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DealerDashBoard extends AppCompatActivity {
    Button btn_inventory, btn_search, btn_dealericon, btn_logout, btn_reservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealerdashboard);
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
            }
        });
        btn_dealericon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DealerDashBoard.this, "GO TO PROFILE", Toast.LENGTH_SHORT).show();
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