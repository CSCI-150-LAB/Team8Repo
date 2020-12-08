package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    Button confirmButton;
    Button returnButton;
    Button dashboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        // Globals
        Inventory masterinventory = new Inventory();
        ArrayList<Car> inventory = masterinventory.exportInventory();
        //Globals masterglobals = new Globals();
        //boolean ispopulated = masterglobals.getPopulated();
        //boolean ispopulated = true;

        // Import boolean populated value
        //populated = (boolean) getIntent().getSerializableExtra("populated");

        // Check if User came from Dashboard page
        /*
        if (!ispopulated) {

            // Confirm Button Behavior
            confirmButton = findViewById(R.id.confirmButton);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Cart.this,"Nothing is in the cart.", Toast.LENGTH_SHORT).show();
                }

            }); // END setOnClickListener confirmButton

            // Return Button Behavior
            returnButton = findViewById(R.id.returnButton);
            returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(Cart.this,"No results to return to.", Toast.LENGTH_SHORT).show();
                }

            }); // END setOnClickListener returnButton

            // Dashboard Button Behavior
            dashboardButton = findViewById(R.id.dashboardButton);
            dashboardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Cart.this, Dashboard.class);
                    startActivity(intent);
                }

            }); // END setOnClickListener dashboardButton
        }
        */

        // Check if User came from Select vehicle page
        //if (ispopulated) {

            // Re-create inventory ArrayList
            //final ArrayList<Car> inventory = (ArrayList<Car>) getIntent().getSerializableExtra("inventory");

            // Re-create indextracker Arraylist
            final ArrayList<Integer> indextrack = (ArrayList<Integer>) getIntent().getSerializableExtra("indextrack");

            // Import chosen Index from Selection screen
            final int chosenIndex = (int) getIntent().getSerializableExtra("chosenIndex");

            TextView brandTextView = findViewById(R.id.brandTextView);
            TextView typeTextView = findViewById(R.id.typeTextView);
            TextView colorTextView = findViewById(R.id.colorTextView);
            TextView drivewheelTextView = findViewById(R.id.drivewheelTextView);
            TextView featurelistTextView = findViewById(R.id.featurelistTextView);

            // List Brand, Type, Color, Drivetrain
            brandTextView.append(inventory.get(chosenIndex).getBrand());
            typeTextView.append(inventory.get(chosenIndex).getType());
            colorTextView.append(inventory.get(chosenIndex).getColor());
            drivewheelTextView.append(inventory.get(chosenIndex).getDrivewheel());

            // List Features
            if (inventory.get(chosenIndex).getTouchscreen()) {
                //txtView2.append(" * ");
                featurelistTextView.append("* Touch Screen ");
            }

            if (inventory.get(chosenIndex).getGPS()) {
                //txtView2.append(" * ");
                featurelistTextView.append("* GPS ");
            }

            if (inventory.get(chosenIndex).getEntsys()) {
                //txtView2.append(" * ");
                featurelistTextView.append("* Ent. Sys. ");
            }

            if (inventory.get(chosenIndex).getTrailer()) {
                //txtView2.append(" * ");
                featurelistTextView.append("* Trailer ");
            }

            if (inventory.get(chosenIndex).getLeather()) {
                //txtView3.append(" * ");
                featurelistTextView.append("* Leather ");
            }

            if (inventory.get(chosenIndex).getHeated()) {
                //txtView3.append(" * ");
                featurelistTextView.append("* Heated Seats ");
            }

            if (inventory.get(chosenIndex).getMinibar()) {
                //txtView3.append(" * ");
                featurelistTextView.append("* Minibar ");

            }

            if (inventory.get(chosenIndex).getJacuzzi()) {
                //txtView3.append(" * ");
                featurelistTextView.append("* Jacuzzi ");
            }

            // Confirm Button Behavior
            confirmButton = findViewById(R.id.confirmButton);
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Cart.this, Reservation.class);

                    // Pass inventory ArrayList
                    //intent.putExtra("inventory", inventory);

                    // Pass chosen index of indextrack
                    intent.putExtra("chosenIndex", chosenIndex);

                    startActivity(intent);

                }

            }); // END setOnClickListener confirmButton

            // Return Button Behavior
            returnButton = findViewById(R.id.returnButton);
            returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Cart.this, Select.class);

                    // Pass inventory ArrayList
                    //intent.putExtra("inventory", inventory);

                    // Pass indextracker Arraylist
                    intent.putExtra("indextrack", indextrack);

                    startActivity(intent);

                }

            }); // END setOnClickListener returnButton

            // Dashboard Button Behavior
            dashboardButton = findViewById(R.id.dashboardButton);
            dashboardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Cart.this, Dashboard.class);
                    startActivity(intent);
                }

            }); // END setOnClickListener dashboardButton

        //} // END "if" check for navigation from select page




    } // END onCreate
}