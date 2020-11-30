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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class AdminSignUp extends AppCompatActivity {

    Button btn_admSignUp;
    EditText et_name, et_dob, et_phone, et_email, et_psswrd, et_psswrdConfrm, et_key;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        btn_admSignUp = findViewById(R.id.btn_admSignUp);
        et_name = findViewById(R.id.et_fullName);
        et_dob = findViewById(R.id.et_dob);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_psswrd = findViewById(R.id.et_psswrd);
        et_psswrdConfrm = findViewById(R.id.et_psswrdConfrm);
        et_key = findViewById(R.id.et_key);

        auth = FirebaseAuth.getInstance();

        btn_admSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (et_key.getText().toString().equals("123")) {
                        if (et_psswrd.getText().toString().equals(et_psswrdConfrm.getText().toString())) {
                            if (et_psswrd.getText().toString().length() > 5) {
                                registerAdmin(et_email.getText().toString(), et_psswrd.getText().toString());
                            } else {
                                Toast.makeText(AdminSignUp.this, "Please ensure password is at least 6 characters!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(AdminSignUp.this, "Error! Passwords do not match!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(AdminSignUp.this, "Error! Incorrect Admin key!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(AdminSignUp.this, "Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerAdmin(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(AdminSignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("DOB", et_dob.getText().toString());
                    map.put("Email", et_email.getText().toString());
                    map.put("FullName", et_name.getText().toString());
                    map.put("Phone", et_phone.getText().toString());
                    FirebaseDatabase.getInstance().getReference().child("Admins").child(user.getUid()).updateChildren(map);

                    Toast.makeText(AdminSignUp.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                    Intent dash = new Intent(getApplicationContext(), AdminBoard.class);
                    startActivity(dash);
                    finish();
                } else {
                    Toast.makeText(AdminSignUp.this, "Register Fail!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
