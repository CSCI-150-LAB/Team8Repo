package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText Email;
    Button SendEmail;
    String UserType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();

        Email = findViewById(R.id.ForgotPassEmail);
        SendEmail = findViewById(R.id.ForgotPassSendLink);

        UserType = getIntent().getStringExtra("User");

        SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FPEmail = Email.getText().toString();

                if(FPEmail.equals("")){
                    Toast.makeText(ForgotPassword.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.sendPasswordResetEmail(FPEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Link have been send to Email", Toast.LENGTH_SHORT).show();
                                if(UserType.equals("User")) {
                                    Intent toUser = new Intent(ForgotPassword.this, Login.class);
                                    startActivity(toUser);
                                }
                                if(UserType.equals("Dealer")){
                                    Intent toDealer = new Intent(ForgotPassword.this, DealerLogin.class);
                                    startActivity(toDealer);
                                }
                                if(UserType.equals("Admin")){
                                    Intent toAdmin = new Intent(ForgotPassword.this, AdminLogin.class);
                                    startActivity(toAdmin);
                                }
                            }
                            else{
                                String ErrorMessage = task.getException().getMessage();
                                Toast.makeText(ForgotPassword.this, "Error Occur: "+ErrorMessage, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}