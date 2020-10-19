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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    Button EditDone;
    EditText EditName, EditEmail, EditDOB, EditPhone;
    String Name,Email,Phone,DOB;
    //private FirebaseDatabase database;
    //private DatabaseReference myRef;
    //private FirebaseUser UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //database = FirebaseDatabase.getInstance();
        //myRef = database.getReference("Users");
        EditName = (EditText)findViewById(R.id.EditUserName);
        EditEmail = (EditText)findViewById(R.id.EditUserEmail);
        EditDOB = (EditText)findViewById(R.id.EditUserDOB);
        EditPhone = (EditText)findViewById(R.id.EditUserPhone);

        EditDone = (Button)findViewById(R.id.EditProfileAccept);

        EditDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = EditName.getText().toString();
                Email = EditEmail.getText().toString();
                DOB = EditDOB.getText().toString();
                Phone = EditPhone.getText().toString();
                UserData user = new UserData(Name,Phone,Email,DOB);
                FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(EditProfile.this, "Data save successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditProfile.this, Userprofile.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(EditProfile.this, "Data fail to save", Toast.LENGTH_SHORT).show();
                            }
                        }
                });
            }
        });
    }
}