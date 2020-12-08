package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // Globals
        Inventory masterinventory = new Inventory();
        ArrayList<Car> inventory = masterinventory.exportInventory();


        // Re-create inventory ArrayList
        //final ArrayList<Car> inventory = (ArrayList<Car>) getIntent().getSerializableExtra("inventory");

        // Import chosen Index from Selection screen
        final int chosenIndex = (int) getIntent().getSerializableExtra("chosenIndex");

        // Create reservation chosenIndex tracker array
        ArrayList<Integer> reservationtrack = new ArrayList<Integer>();

        // Add chosenIndex to list of reservations
        reservationtrack.add(chosenIndex);




        // Dynamic generation of results
        int resultsize = reservationtrack.size();

        LinearLayout mainLayoutVert2 = findViewById(R.id.reservationlist);

        LinearLayout topLayoutVert2;
        LinearLayout.LayoutParams topLayoutVertParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);

        LinearLayout bottomLayoutHoriz2;
        LinearLayout.LayoutParams bottomLayoutHorizParams2 = new LinearLayout.LayoutParams(800, LinearLayout.LayoutParams.MATCH_PARENT);

        TextView txtView21;
        TextView txtView22;
        TextView txtView23;
        LinearLayout.LayoutParams t_temp_params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button[] btnlist2 = new Button[resultsize];
        Button button2;
        LinearLayout.LayoutParams buttonParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        View.OnClickListener[] listenerlist2 = new View.OnClickListener[resultsize];


        // Listener LOOP
        for (int i = 0; i < resultsize; i++) {

            //final int chosenIndex = indextrack.get(i);

            listenerlist2[i] = new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Reservation.this, Reservation.class);

                    // Pass inventory ArrayList
                    //intent.putExtra("inventory", inventory);

                    // Pass indextracker Arraylist
                    //intent.putExtra("indextrack", indextrack);

                    // Pass chosen index of indextrack
                    //intent.putExtra("chosenIndex", chosenIndex);

                    //startActivity(intent);
                }
            };
        }

        // ============================= LOOP ==============================

        for (int i = 0; i < resultsize; i++)
        {
            topLayoutVert2 = new LinearLayout(this);
            topLayoutVert2.setLayoutParams(topLayoutVertParams2);
            topLayoutVert2.setOrientation(LinearLayout.HORIZONTAL);

            bottomLayoutHoriz2 = new LinearLayout(this);
            bottomLayoutHoriz2.setLayoutParams(bottomLayoutHorizParams2);
            bottomLayoutHoriz2.setOrientation(LinearLayout.VERTICAL);

            txtView21 = new TextView(this);
            txtView22 = new TextView(this);
            txtView23 = new TextView(this);
            txtView21.setLayoutParams(t_temp_params2);
            txtView22.setLayoutParams(t_temp_params2);
            txtView23.setLayoutParams(t_temp_params2);

            button2 = new Button(this);
            button2.setLayoutParams(buttonParams2);
            button2.setId(100 + i);
            button2.setTag(i);
            button2.setOnClickListener(listenerlist2[i]);
            button2.setText("Remove");

            // First line | Brand - Type - Color - Drivetrain
            txtView21.append(inventory.get(reservationtrack.get(i)).getBrand());
            txtView21.setTypeface(null, Typeface.BOLD);
            txtView21.append(" - ");
            txtView21.append(inventory.get(reservationtrack.get(i)).getType());
            txtView21.append(" - ");
            txtView21.append(inventory.get(reservationtrack.get(i)).getColor());
            txtView21.append(" - ");
            txtView21.append(inventory.get(reservationtrack.get(i)).getDrivewheel());

            // Second line | Touch Screen - GPS - Ent. Sys. - Trailer Hookup
            if (inventory.get(reservationtrack.get(i)).getTouchscreen()) {
                //txtView2.append(" * ");
                txtView22.append("* Touch Screen ");
            }
            if (inventory.get(reservationtrack.get(i)).getGPS()) {
                //txtView2.append(" * ");
                txtView22.append("* GPS ");
            }
            if (inventory.get(reservationtrack.get(i)).getEntsys()) {
                //txtView2.append(" * ");
                txtView22.append("* Ent. Sys. ");
            }
            if (inventory.get(reservationtrack.get(i)).getTrailer()) {
                //txtView2.append(" * ");
                txtView22.append("* Trailer ");
            }

            // Third line | Leather Seats - Heated Seats - Minibar - Jacuzzi
            if (inventory.get(reservationtrack.get(i)).getLeather()) {
                //txtView3.append(" * ");
                txtView23.append("* Leather ");
            }
            if (inventory.get(reservationtrack.get(i)).getHeated()) {
                //txtView3.append(" * ");
                txtView23.append("* Heated Seats ");
            }
            if (inventory.get(reservationtrack.get(i)).getMinibar()) {
                //txtView3.append(" * ");
                txtView23.append("* Minibar ");

            }
            if (inventory.get(reservationtrack.get(i)).getJacuzzi()) {
                //txtView3.append(" * ");
                txtView23.append("* Jacuzzi ");
            }

            // add the textviews and buttons to layouts
            bottomLayoutHoriz2.addView(txtView21);
            bottomLayoutHoriz2.addView(txtView22);
            bottomLayoutHoriz2.addView(txtView23);

            // ---------------------

            topLayoutVert2.addView(bottomLayoutHoriz2);
            topLayoutVert2.addView(button2);

            btnlist2[i] = button2;

            // ---------------------

            mainLayoutVert2.addView(topLayoutVert2);

        } // End of LOOP


        // Confirm Button Behavior
        Button dashreturnButton = findViewById(R.id.dashreturnButton);
        dashreturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Reservation.this, Dashboard.class);
                startActivity(intent);

            }

        }); // END setOnClickListener confirmButton


    }
}