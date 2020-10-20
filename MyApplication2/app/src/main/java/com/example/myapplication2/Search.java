package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Search extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void goto_selectpage(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Select.class);
        startActivity(intent);
    }
}