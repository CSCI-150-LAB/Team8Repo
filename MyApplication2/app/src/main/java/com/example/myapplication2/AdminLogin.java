package com.example.myapplication2;

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

public class AdminLogin extends AppCompatActivity {

    EditText et_email, et_psswrd;
    Button btn_signIn, btn_signUp, go2Home;
    TextView AdminFP;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        et_email = findViewById(R.id.et_email);
        et_psswrd = findViewById(R.id.et_psswrd);
        btn_signIn = findViewById(R.id.btn_signIn);
        btn_signUp = findViewById(R.id.btn_signUp);

        go2Home = findViewById(R.id.Admin2Home);

        auth = FirebaseAuth.getInstance();

        AdminFP = findViewById(R.id.AdminFP);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAdmin(et_email.getText().toString(),et_psswrd.getText().toString());
            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminSignUpIntent = new Intent(getApplicationContext(), AdminSignUp.class);
                startActivity(adminSignUpIntent);
            }
        });

        go2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLogin.this, Home.class);
                startActivity(intent);
            }
        });

        AdminFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Admin2FP = new Intent(AdminLogin.this, ForgotPassword.class);
                Admin2FP.putExtra("User","Admin");
                startActivity(Admin2FP);
            }
        });
    }

    private void loginAdmin(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(AdminLogin.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AdminLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    //login placeholder
                    //
                    Intent dash = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(dash);
                    //
                    //placeholder
                    finish();
                } else {
                    Toast.makeText(AdminLogin.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

