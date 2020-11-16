package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase; // Entry point to database
import com.google.firebase.database.DatabaseReference; // Particular location (read/write)
import com.google.firebase.database.DataSnapshot; // Contains data from a database location
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import org.w3c.dom.Comment;

// FirebaseDatabase
// -------------------
// The entry point for accessing a Firebase Database. You can get an instance by calling getInstance(). To access a location in the database and read or
// write data, use getReference().

// DatabaseReference
// -------------------
// A Firebase reference represents a particular location in your Database and can be used for reading or writing data to that Database location.
// This class is the starting point for all Database operations. After you've initialized it with a URL, you can use it to read data, write data,
// and to create new DatabaseReferences.

// DataSnapshot
// -------------------
// A DataSnapshot instance contains data from a Firebase Database location. Any time you read Database data, you receive the data as a DataSnapshot.
// DataSnapshots are passed to the methods in listeners that you attach with addValueEventListener(ValueEventListener), addChildEventListener(ChildEventListener),
// or addListenerForSingleValueEvent(ValueEventListener).
// They are efficiently-generated immutable copies of the data at a Firebase Database location. They can't be modified and will never change.
// To modify data at a location, use a DatabaseReference reference (e.g. with setValue(Object)).


public class Search extends AppCompatActivity {

    Button searchsubmitButton;

    // Database
    Car car1 = new Car("Audi","Coupe","Black","All Wheel",true,true,true,true,true,true,true,true,2);
    Car car2 = new Car("BMW","Hatchback","Blue","Front Wheel",false,false,false,false,false,false,false,false,2);
    Car car3 = new Car("Chevy","Luxury","Brown","Rear Wheel",false,false,false,false,false,false,false,false,2);
    Car car4 = new Car("Dodge","Minivan","Green","All Wheel",false,false,false,false,false,false,false,false,2);
    Car car5 = new Car("Ferrari","Pickup","Orange","All Wheel",false,false,false,false,false,false,false,false,2);
    Car car6 = new Car("Ford","Sedan","Purple","All Wheel",false,false,false,false,false,false,false,false,2);
    Car car7 = new Car("Honda","Sports","Red","All Wheel",false,false,false,false,false,false,false,false,2);
    Car car8 = new Car("Hyundai","SUV","Silver","All Wheel",true,false,false,false,false,false,false,false,2);
    Car car9 = new Car("Jaguar","SUV","White","All Wheel",false,true,false,false,false,false,false,false,2);
    Car car10 = new Car("Lamborghini","SUV","Yellow","All Wheel",false,false,true,false,false,false,false,false,2);
    Car car11 = new Car("Lexus","SUV","Yellow","All Wheel",false,false,false,true,false,false,false,false,2);
    Car car12 = new Car("Mercedes-Benz","SUV","Yellow","All Wheel",false,false,false,false,true,false,false,false,2);
    Car car13 = new Car("Nissan","SUV","Yellow","All Wheel",false,false,false,false,false,true,false,false,2);
    Car car14 = new Car("Porsche","SUV","Yellow","All Wheel",false,false,false,false,false,false,true,false,2);
    Car car15 = new Car("Toyota","SUV","Yellow","All Wheel",false,false,false,false,false,false,false,true,2);
    Car car16 = new Car("Toyota","Coupe","Red","All Wheel",false,false,false,false,false,false,false,true,2);
    Car car17 = new Car("Toyota","Sedan","Blue","Front Wheel",false,true,false,true,false,false,false,true,2);
    Car car18 = new Car("Toyota","Pickup","Silver","All Wheel",true,false,false,false,true,false,true,true,2);
    Car car19 = new Car("Toyota","Luxury","Green","Rear Wheel",false,true,false,true,false,true,false,true,2);
    Car car20 = new Car("Audi","Sedan","Black","All Wheel",true,true,true,true,true,true,true,true,2);
    Car car21 = new Car("Audi","Coupe","White","All Wheel",true,true,true,true,true,true,true,true,2);
    Car car22 = new Car("Audi","Luxury","Silver","All Wheel",true,true,true,true,true,true,true,true,2);
    Car car23 = new Car("Audi","Pickup","Yellow","Rear Wheel",true,true,true,true,true,true,true,true,2);
    Car car24 = new Car("Chevy","Sedan","Blue","Rear Wheel",false,false,true,false,true,false,true,false,2);
    Car car25 = new Car("Chevy","Pickup","Red","All Wheel",false,false,false,true,false,true,false,true,2);
    Car car26 = new Car("Ferrari","Sports","Red","All Wheel",false,false,false,false,false,false,false,false,2);
    Car car27 = new Car("Ferrari","Luxury","Black","All Wheel",false,false,false,false,false,false,false,false,2);

    /*
    Car car1 = new Car("Audi","Coupe","Black","Front Wheel",true,true,false,false,true,true,false,false,2);
    Car car2 = new Car("Audi","Coupe","White","Front Wheel",true,true,false,false,true,true,false,false,2);
    Car car3 = new Car("Audi","Sedan","Blue","Rear Wheel",false,false,false,false,true,true,false,false,2);
    Car car4 = new Car("Audi","Sedan","Silver","Rear Wheel",false,false,false,false,true,true,false,false,2);
    Car car5 = new Car("Audi","Luxury","Black","Front Wheel",true,true,false,false,true,true,false,false,2);
    */

    // Create database array and index tracker array
    ArrayList<Car> inventory = new ArrayList<Car>();
    ArrayList<Integer> indextrack = new ArrayList<Integer>();

    // ============================= onCreate Method =============================
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        inventory.add(car1);
        inventory.add(car2);
        inventory.add(car3);
        inventory.add(car4);
        inventory.add(car5);
        inventory.add(car6);
        inventory.add(car7);
        inventory.add(car8);
        inventory.add(car9);
        inventory.add(car10);
        inventory.add(car11);
        inventory.add(car12);
        inventory.add(car13);
        inventory.add(car14);
        inventory.add(car15);
        inventory.add(car16);
        inventory.add(car17);
        inventory.add(car18);
        inventory.add(car19);
        inventory.add(car20);
        inventory.add(car21);
        inventory.add(car22);
        inventory.add(car23);
        inventory.add(car24);
        inventory.add(car25);
        inventory.add(car26);
        inventory.add(car27);


        searchsubmitButton = findViewById(R.id.searchsubmitButton);
        searchsubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Spinner brandSpinner = findViewById(R.id.brandSpinner);
                Spinner typeSpinner = findViewById(R.id.typeSpinner);
                Spinner colorSpinner = findViewById(R.id.colorSpinner);
                Spinner drivewheelSpinner = findViewById(R.id.drivewheelSpinner);
                CheckBox touchscreenCheckBox = (CheckBox) findViewById(R.id.touchscreenCheckBox);
                CheckBox gpsCheckBox = (CheckBox) findViewById(R.id.gpsCheckBox);
                CheckBox entertainCheckBox = (CheckBox) findViewById(R.id.entertainCheckBox);
                CheckBox trailerCheckBox = (CheckBox) findViewById(R.id.trailerCheckBox);
                CheckBox leatherseatsCheckBox = (CheckBox) findViewById(R.id.leatherseatsCheckBox);
                CheckBox heatedseatsCheckBox = (CheckBox) findViewById(R.id.heatedseatsCheckBox);
                CheckBox minibarCheckBox = (CheckBox) findViewById(R.id.minibarCheckBox);
                CheckBox jacuzziCheckBox = (CheckBox) findViewById(R.id.jacuzziCheckBox);

                String brandSpinner_text = brandSpinner.getSelectedItem().toString();
                String typeSpinner_text = typeSpinner.getSelectedItem().toString();
                String colorSpinner_text = colorSpinner.getSelectedItem().toString();
                String drivewheelSpinner_text = drivewheelSpinner.getSelectedItem().toString();

                Boolean brandmatch = false;
                Boolean typematch = false;
                Boolean colormatch = false;
                Boolean drivematch = false;
                Boolean touchmatch = false;
                Boolean gpsmatch = false;
                Boolean entsysmatch = false;
                Boolean trailermatch = false;
                Boolean leathermatch = false;
                Boolean heatedmatch = false;
                Boolean minibarmatch = false;
                Boolean jacuzzimatch = false;

                Boolean brandnotempty = false;
                Boolean typenotempty = false;
                Boolean colornotempty = false;
                Boolean drivenotempty = false;
                Boolean touchnotempty = false;
                Boolean gpsnotempty = false;
                Boolean entsysnotempty = false;
                Boolean trailernotempty = false;
                Boolean leathernotempty = false;
                Boolean heatednotempty = false;
                Boolean minibarnotempty = false;
                Boolean jacuzzinotempty = false;

                int filtermatch = 0;

                // ============================= Database Query =============================
                // Check for empty input
                if (!(touchscreenCheckBox.isChecked()) && !(gpsCheckBox.isChecked()) && !(entertainCheckBox.isChecked()) && !(trailerCheckBox.isChecked()) &&
                        !(leatherseatsCheckBox.isChecked()) && !(heatedseatsCheckBox.isChecked()) && !(minibarCheckBox.isChecked()) && !(jacuzziCheckBox.isChecked()) &&
                        brandSpinner_text.equals("") && typeSpinner_text.equals("") && colorSpinner_text.equals("") && drivewheelSpinner_text.equals("")) {
                    Toast.makeText(Search.this,"Empty input.", Toast.LENGTH_SHORT).show();
                }

                // At least one filter is selected
                else {

                    // ============================= LOOP =============================
                    // Check entire inventory against selected filters
                    for (int i = 0; i < inventory.size(); i++) {

                        // If Brand filter isn't empty and matches
                        if (!(brandSpinner_text.equals(""))) {
                            brandnotempty = true;
                            if (brandSpinner_text.equals(inventory.get(i).getBrand())) {
                                brandmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Type filter isn't empty and matches
                        if (!(typeSpinner_text.equals(""))) {
                            typenotempty = true;
                            if (typeSpinner_text.equals(inventory.get(i).getType())) {
                                typematch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Color filter isn't empty and matches
                        if (!(colorSpinner_text.equals(""))) {
                            colornotempty = true;
                            if (colorSpinner_text.equals(inventory.get(i).getColor())) {
                                colormatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Drivetrain filter isn't empty and matches
                        if (!(drivewheelSpinner_text.equals(""))) {
                            drivenotempty = true;
                            if (drivewheelSpinner_text.equals(inventory.get(i).getDrivewheel())) {
                                drivematch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        //-------------------------------------- Checkboxes ----------------------------------------------
                        //------------------------------------------------------------------------------------------------
                        // If Touch Screen filter isn't empty and matches
                        if (touchscreenCheckBox.isChecked()) {
                            touchnotempty = true;
                            if (inventory.get(i).getTouchscreen()) {
                                touchmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If GPS filter isn't empty and matches
                        if (gpsCheckBox.isChecked()) {
                            gpsnotempty = true;
                            if (inventory.get(i).getGPS()) {
                                gpsmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Entertainment System filter isn't empty and matches
                        if (entertainCheckBox.isChecked()) {
                            entsysnotempty = true;
                            if (inventory.get(i).getEntsys()) {
                                entsysmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Trailer Hookup filter isn't empty and matches
                        if (trailerCheckBox.isChecked()) {
                            trailernotempty = true;
                            if (inventory.get(i).getTrailer()) {
                                trailermatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Leather Seats filter isn't empty and matches
                        if (leatherseatsCheckBox.isChecked()) {
                            leathernotempty = true;
                            if (inventory.get(i).getLeather()) {
                                leathermatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Heated Seats filter isn't empty and matches
                        if (heatedseatsCheckBox.isChecked()) {
                            heatednotempty = true;
                            if (inventory.get(i).getHeated()) {
                                heatedmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Minibar filter isn't empty and matches
                        if (minibarCheckBox.isChecked()) {
                            minibarnotempty = true;
                            if (inventory.get(i).getMinibar()) {
                                minibarmatch = true;
                            }
                        }
                        //------------------------------------------------------------------------------------------------
                        // If Jacuzzi filter isn't empty and matches
                        if (jacuzziCheckBox.isChecked()) {
                            jacuzzinotempty = true;
                            if (inventory.get(i).getJacuzzi()) {
                                jacuzzimatch = true;
                            }
                        }
                        // notempty = true (filter is filled)
                        // notempty = false (filter is empty)

                        // match = true (matched)
                        // match = false (not matched)

                        // Check all filter flags are true and unmatched filters are actually empty filters
                        if (brandmatch == brandnotempty) {

                            if (typematch == typenotempty) {

                                if (colormatch == colornotempty) {

                                    if (drivematch == drivenotempty) {

                                        if (touchmatch == touchnotempty) {

                                            if (gpsmatch == gpsnotempty) {

                                                if (entsysmatch == entsysnotempty) {

                                                    if (trailermatch == trailernotempty) {

                                                        if (leathermatch == leathernotempty) {

                                                            if (heatedmatch == heatednotempty) {

                                                                if (minibarmatch == minibarnotempty) {

                                                                    // Final Check - All filters match current car in vector
                                                                    if (jacuzzimatch == jacuzzinotempty) {

                                                                        filtermatch++;
                                                                        indextrack.add(i);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } // End of Filter Flag Checking

                        // Reset flags for next vector index
                        brandmatch = false;
                        typematch = false;
                        colormatch = false;
                        drivematch = false;
                        touchmatch = false;
                        gpsmatch = false;
                        entsysmatch = false;
                        trailermatch = false;
                        leathermatch = false;
                        heatedmatch = false;
                        minibarmatch = false;
                        jacuzzimatch = false;

                        brandnotempty = false;
                        typenotempty = false;
                        colornotempty = false;
                        drivenotempty = false;
                        touchnotempty = false;
                        gpsnotempty = false;
                        entsysnotempty = false;
                        trailernotempty = false;
                        leathernotempty = false;
                        heatednotempty = false;
                        minibarnotempty = false;
                        jacuzzinotempty = false;

                    } // End of for loop to check inventory vector

                    // If selected filters don't match anything in database
                    if (filtermatch == 0) {

                        Toast.makeText(Search.this,"No matches found. Please change or narrow search.", Toast.LENGTH_LONG).show();
                    }

                    // Go to select page with search results based on selected filters
                    if (filtermatch > 0) {

                        Intent intent = new Intent(Search.this, Select.class);

                        // Pass inventory ArrayList
                        intent.putExtra("inventorylist", inventory);

                        // Pass indextrack ArrayList of filter matches
                        intent.putExtra("indextracklist", indextrack);

                        startActivity(intent);

                    }

                }

            }

        });

    }

}