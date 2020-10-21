package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser CurrentUser;
    Button AcceptNewPassword, BacktoProfile;
    EditText newPass, ReNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth = FirebaseAuth.getInstance();
        CurrentUser = mAuth.getCurrentUser();
        newPass = findViewById(R.id.editNewPassword);
        ReNewPass = findViewById(R.id.editReNewPass);

        AcceptNewPassword = findViewById(R.id.AcceptNewPassword);
        BacktoProfile = findViewById(R.id.BackUserProfile);

        BacktoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, Userprofile.class);
                startActivity(intent);
            }
        });

        AcceptNewPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewPassword = newPass.getText().toString();
                String ReNewPassword = ReNewPass.getText().toString();
                if(NewPassword.equals(ReNewPassword)){
                    CurrentUser.updatePassword(NewPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(ResetPassword.this, "Password reset successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ResetPassword.this, Userprofile.class);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ResetPassword.this, "Fail to Reset Password", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(ResetPassword.this, "New Password and ReNew Password does not match", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}