package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dealer_Invent extends AppCompatActivity {

    ListView listV;
    FirebaseDatabase DB;
    DatabaseReference myRef;
    CarInfo myCarInfo;

    Button Add, Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer__invent);

        listV = findViewById(R.id.listView);
        Add = findViewById(R.id.addCar);
        DB = FirebaseDatabase.getInstance();
        myCarInfo = new CarInfo();
        final ArrayList <String> info = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, info);
        listV.setAdapter(adapter);

        myRef = FirebaseDatabase.getInstance().getReference().child("Inventory");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                info.clear();
                for(DataSnapshot ds: snapshot.getChildren()){
                    //myCarInfo = ds.getValue(CarInfo.class);
                    info.add(ds.getKey().toString() + "\n" + ds.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dealer_Invent.this, DealerAddCar.class);
                startActivity(intent);
            }
        });


    }
}