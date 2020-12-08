package com.example.mycar;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DealerAddCar extends AppCompatActivity {

    Button AddCar;
    EditText brand, color, drivewheel, entsys, fee, gps;
    EditText heated, jacuzzi, leather, minibar, qty, touchscreen, trailer, type;
    String Brand, Color, Drivewheel, Entsys, Fee, Gps;
    String Heated, Jacuzzi, Leather, Minibar, Qty, Touchscreen, Trailer, Type;

    DatabaseReference reference;
    FirebaseDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_add_car);

        myDatabase = FirebaseDatabase.getInstance();
        brand = findViewById(R.id.BrandValue);
        color = findViewById(R.id.ColorValue);
        drivewheel = findViewById(R.id.WheelValue);
        entsys = findViewById(R.id.EntsysValue);
        fee = findViewById(R.id.FeeValue);
        gps = findViewById(R.id.GPSValue);
        heated = findViewById(R.id.HeatedValue);
        jacuzzi = findViewById(R.id.JacuzziValue);
        leather = findViewById(R.id.LeatherValue);
        minibar = findViewById(R.id.MiniBarValue);
        qty = findViewById(R.id.QtyValue);
        touchscreen = findViewById(R.id.TScreenValue);
        trailer = findViewById(R.id.TrailerValue);
        type = findViewById(R.id.TypeValue);

        reference = myDatabase.getReference().child("Inventory");
        AddCar = findViewById(R.id.CarAddBTN);

        AddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Brand = brand.getText().toString();
                Color = color.getText().toString();
                Drivewheel = drivewheel.getText().toString();
                Entsys = entsys.getText().toString();
                Fee = fee.getText().toString();
                Gps = gps.getText().toString();
                Heated = heated.getText().toString();
                Jacuzzi = jacuzzi.getText().toString();
                Leather = leather.getText().toString();
                Minibar = minibar.getText().toString();
                Qty = qty.getText().toString();
                Touchscreen = touchscreen.getText().toString();
                Trailer = trailer.getText().toString();
                Type = type.getText().toString();

                CarInfo newCar = new CarInfo(Brand, Color, Drivewheel, Entsys, Fee, Gps,
                        Heated, Jacuzzi, Leather, Minibar, Qty, Touchscreen, Trailer, Type);
                reference.child(Brand).setValue(newCar).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DealerAddCar.this, "Data save successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DealerAddCar.this, Dealer_Invent.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(DealerAddCar.this, "Data fail to save", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}