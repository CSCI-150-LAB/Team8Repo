package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

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

    // Gobals
    //Indextracker masterindextracker = new Indextracker();
    Inventory masterinventory = new Inventory();

    ArrayList<Car> inventory = masterinventory.exportInventory();
    //ArrayList<Integer> indextrack = masterindextracker.exportIndex();

    Button searchsubmitButton;

    // Create index tracker array
    ArrayList<Integer> indextrack = new ArrayList<Integer>();

    // ============================= onCreate Method =============================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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

                        // Pass indextrack ArrayList of filter matches
                        intent.putExtra("indextrack", indextrack);

                        startActivity(intent);

                    }

                } // END At least one filter is selected

            } // END onClick

        }); // END setOnClickListener

    } // END onCreate

}