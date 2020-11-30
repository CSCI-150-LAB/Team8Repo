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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class DealerSignUp extends AppCompatActivity {

    EditText DealerName, DealerDOB, DealerPhone, DealerEmail, DealerPassword, DealerComfirmPass;
    Button DealerRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_sign_up);

        mAuth = FirebaseAuth.getInstance();

        DealerName = findViewById(R.id.DealerFullName);
        DealerDOB = findViewById(R.id.DealerDOB);
        DealerPhone = findViewById(R.id.DealerPhone);
        DealerEmail = findViewById(R.id.DealerEmailRegister);
        DealerPassword = findViewById(R.id.DealerPasswordRegister);
        DealerComfirmPass = findViewById(R.id.DealerConfirmPassword);

        DealerRegister = findViewById(R.id.DealerSignUpRegister);

        DealerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Name = DealerName.getText().toString();
                final String DOB = DealerDOB.getText().toString();
                final String Phone = DealerPhone.getText().toString();
                final String Email = DealerEmail.getText().toString();
                String Pass = DealerPassword.getText().toString();
                String ComfirmPass = DealerComfirmPass.getText().toString();

                if(Email.equals("")||Pass.equals("")||ComfirmPass.equals("")){
                    Toast.makeText(DealerSignUp.this, "Please fill in Email and Password", Toast.LENGTH_SHORT).show();
                }
                else if(Pass.length()<6){
                    Toast.makeText(DealerSignUp.this, "Password need to be 6 or more characters", Toast.LENGTH_SHORT).show();
                }
                else if(Pass.equals(ComfirmPass)){
                    mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(DealerSignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                UserData Dealer = new UserData(Name, Phone, Email, DOB);

                                FirebaseDatabase.getInstance().getReference("Dealers")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(Dealer).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(DealerSignUp.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(DealerSignUp.this, DealerLogin.class);
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(DealerSignUp.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(DealerSignUp.this, "Error Occur", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}