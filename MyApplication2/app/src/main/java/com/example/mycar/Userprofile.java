package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userprofile extends AppCompatActivity {

    Button EditProfile, BackDashboard, resetPassword;
    String UName, UEmail, UPhone, UDOB;
    private FirebaseUser User;
    private DatabaseReference UserReference;
    private FirebaseAuth mAuth;
    private String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        mAuth = FirebaseAuth.getInstance();
        User = FirebaseAuth.getInstance().getCurrentUser();
        final String UsersEx = getIntent().getStringExtra("Profile");
        if(UsersEx.equals("Customer")) {
            UserReference = FirebaseDatabase.getInstance().getReference("Users");
        }
        if(UsersEx.equals("Dealer")){
            UserReference = FirebaseDatabase.getInstance().getReference("Dealers");
        }
        UserID = User.getUid();

        final TextView UserName = (TextView)findViewById(R.id.UserNameText);
        final TextView UserEmail = (TextView)findViewById(R.id.UserEmailText);
        final TextView UserPhone = (TextView)findViewById(R.id.Userphone);
        final TextView UserDOB = (TextView) findViewById(R.id.UserDOB);

        EditProfile = (Button)findViewById(R.id.Editprofile);
        BackDashboard = (Button)findViewById(R.id.BackDashBoard);
        resetPassword = findViewById(R.id.resetPass);



            UserReference.child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserData UserInfo = snapshot.getValue(UserData.class);
                    if (UserInfo != null) {
                        String name = UserInfo.FullName;
                        String email = UserInfo.Email;
                        String phoneNum = UserInfo.Phone;
                        String dob = UserInfo.DOB;

                        UserName.setText(name);
                        UserEmail.setText(email);
                        UserPhone.setText(phoneNum);
                        UserDOB.setText(dob);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Userprofile.this, "Profile is empty", Toast.LENGTH_SHORT).show();

                }
            });


            EditProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EditProfile.class);
                    intent.putExtra("EditPro",UsersEx.toString());
                    startActivity(intent);
                }
            });

        BackDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UsersEx.equals("Customer")) {
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                }
                if(UsersEx.equals("Dealer")){
                    Intent intent = new Intent(getApplicationContext(), DealerDashBoard.class);
                    startActivity(intent);
                }
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userprofile.this, ResetPassword.class);
                startActivity(intent);
            }
        });


    }
}