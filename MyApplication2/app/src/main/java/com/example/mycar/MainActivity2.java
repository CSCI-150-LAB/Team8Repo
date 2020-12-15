package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity2 extends AppCompatActivity {
    Button btn_DealerX, btn_DealerY, btn_AdminA, btn_AdminB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_DealerX = (Button)findViewById(R.id.btn_DealerX);
        btn_DealerY = (Button)findViewById(R.id.btn_DealerY);
        btn_AdminA = (Button)findViewById(R.id.btn_AdminA);
        btn_AdminB = (Button)findViewById(R.id.btn_AdminB);
        btn_DealerX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DealerX.class);
                startActivity(intent);
            }
        });
        btn_DealerY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DealerY.class);
                startActivity(intent);
            }
        });
        btn_AdminA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminA.class);
                startActivity(intent);
            }
        });
        btn_AdminB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminB.class);
                startActivity(intent);
            }
        });
    }
}