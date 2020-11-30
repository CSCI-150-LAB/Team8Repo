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

public class Register extends AppCompatActivity {

    EditText username, password, repassword;
    Button Register;
    //DBHelper DB;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.RegisterEmail);
        password = findViewById(R.id.RegisterPassword);
        repassword = findViewById(R.id.RegisterRePassword);
        Register = findViewById(R.id.RegisterBtm);
        //DB = new DBHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")|pass.equals("")|repass.equals("")){
                    Toast.makeText(Register.this,"Please fill in info", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<6){
                    Toast.makeText(Register.this, "Password needs to be 6 characters or more", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(repass)){
                    mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                UserData User = new UserData("","","","");

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Intent goLogin = new Intent(Register.this, Login.class);
                                            startActivity(goLogin);
                                        }
                                        else{
                                            Toast.makeText(Register.this, "Data Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Register.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}