package com.example.myapplication2;

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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText  username, password;
    Button btnLOGIN;
    Button btn2REGISTER;
    Button btnHome;
    FirebaseAuth authFirebaseAcc;
    private FirebaseAuth.AuthStateListener authStateListenerAcc;

    //String correct_username = "customer";
    //String correct_password = "mycars1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        authFirebaseAcc = FirebaseAuth.getInstance();
        username = findViewById(R.id.UserloginEmail);
        password = findViewById(R.id.Userpassword);
        btnLOGIN = findViewById(R.id.UserLoginbtm);
        btn2REGISTER = findViewById(R.id.UserRegister);
        btnHome = findViewById(R.id.User2Home);

        authStateListenerAcc = new FirebaseAuth.AuthStateListener() {
            FirebaseUser FirebaseAcc = authFirebaseAcc.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(FirebaseAcc != null){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent goHome = new Intent(Login.this, Dashboard.class);
                    startActivity(goHome);
                }
                else{
                    Toast.makeText(Login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")|pass.equals("")){
                    Toast.makeText(Login.this,"Please enter login info", Toast.LENGTH_SHORT).show();

                }
                else {
                    authFirebaseAcc.signInWithEmailAndPassword(user, pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent goToDash = new Intent(Login.this,Dashboard.class);
                                startActivity(goToDash);
                            }
                        }
                    });
                }
            }
        });

        btn2REGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go2home = new Intent(getApplicationContext(), Home.class);
                startActivity(go2home);
            }
        });
    }

}