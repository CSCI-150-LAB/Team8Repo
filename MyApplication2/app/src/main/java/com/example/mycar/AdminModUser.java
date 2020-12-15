package com.example.mycar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminModUser extends AppCompatActivity {
    EditText username, email;
    TextView textView;
    DB_Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmoduser);

        username = (EditText)findViewById(R.id.username_input);
        email = (EditText)findViewById(R.id.email_input);
        textView = (TextView) findViewById(R.id.textView);
        controller = new DB_Controller(this, "", null, 1);

    }
    public void btn_click(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                try {
                    controller.insert_users(username.getText().toString(), email.getText().toString());

                } catch (SQLiteException e) {
                    Toast.makeText(AdminModUser.this, "ALREADY EXISTS", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.btn_remove:
                controller.delete_users(username.getText().toString());
                break;
            case R.id.list_all_users:
                controller.list_all_users(textView);
                break;

        }
    }
}