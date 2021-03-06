package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DealerLogin extends AppCompatActivity {

    EditText DealerUsername, DealerPassword;
    Button DealerLoginbtm;
    Button DealerReg;
    Button DealerHome;
    FirebaseAuth mAuth;
    TextView DealerFP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_login);

        mAuth = FirebaseAuth.getInstance();

        DealerLoginbtm = findViewById(R.id.DealerLogin);
        DealerReg = findViewById(R.id.DealerRegisterbtm);
        DealerHome = findViewById(R.id.Dealer2Home);
        DealerUsername = findViewById(R.id.DealerLoginEmail);
        DealerPassword = findViewById(R.id.DealerLoginPassword);

        DealerFP = findViewById(R.id.DealerForgotPassword);

        DealerLoginbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DUser = DealerUsername.getText().toString();
                String DPass = DealerPassword.getText().toString();
                try {
                    mAuth.signInWithEmailAndPassword(DUser, DPass).addOnCompleteListener(DealerLogin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(DealerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DealerLogin.this, DealerDashBoard.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(DealerLogin.this, "Login Fail", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
                catch (Exception e) {}
            }
        });

        DealerReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to register
                Intent Dealer2Register = new Intent(DealerLogin.this, DealerSignUp.class);
                startActivity(Dealer2Register);
            }
        });

        DealerHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Deal2Home = new Intent(DealerLogin.this, Home.class);
                startActivity(Deal2Home);
            }
        });

        DealerFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DealertoFP = new Intent(DealerLogin.this, ForgotPassword.class);
                DealertoFP.putExtra("User","Dealer");
                startActivity(DealertoFP);
            }
        });

    }
}