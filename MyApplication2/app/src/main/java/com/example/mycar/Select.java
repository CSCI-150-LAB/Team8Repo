package com.example.mycar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Select extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        // Gobals
        Inventory masterinventory = new Inventory();
        //Indextracker masterindextracker = new Indextracker();

        ArrayList<Car> inventory = masterinventory.exportInventory();
        //ArrayList<Integer> indextrack = masterindextracker.exportIndex();

        final Globals masterglobals = new Globals();

        // Re-create indextracker Arraylist
        final ArrayList<Integer> indextrack = (ArrayList<Integer>) getIntent().getSerializableExtra("indextrack");

        // Dynamic generation of results
        int resultsize = indextrack.size();

        LinearLayout mainLayoutVert = findViewById(R.id.resultlist);

        LinearLayout topLayoutVert;
        LinearLayout.LayoutParams topLayoutVertParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);

            LinearLayout bottomLayoutHoriz;
            LinearLayout.LayoutParams bottomLayoutHorizParams = new LinearLayout.LayoutParams(800, LinearLayout.LayoutParams.MATCH_PARENT);

                TextView txtView1;
                TextView txtView2;
                TextView txtView3;
                LinearLayout.LayoutParams t_temp_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            Button[] btnlist = new Button[resultsize];
            Button button;
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        View.OnClickListener[] listenerlist = new View.OnClickListener[resultsize];

        //boolean populated = true;
        //masterglobals.setPopulated(populated);

        // Listener LOOP
        for (int i = 0; i < resultsize; i++) {

            final int chosenIndex = indextrack.get(i);

            listenerlist[i] = new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Select.this, Cart.class);

                    // Pass inventory ArrayList
                    //intent.putExtra("inventory", inventory);

                    // Pass indextracker Arraylist
                    intent.putExtra("indextrack", indextrack);

                    // Pass chosen index of indextrack
                    intent.putExtra("chosenIndex", chosenIndex);

                    // Pass boolean populated value
                    //intent.putExtra("populated", populated);

                    startActivity(intent);
                }
            };
        }

        // ============================= LOOP ==============================

        for (int i = 0; i < resultsize; i++)
        {
            topLayoutVert = new LinearLayout(this);
            topLayoutVert.setLayoutParams(topLayoutVertParams);
            topLayoutVert.setOrientation(LinearLayout.HORIZONTAL);

                bottomLayoutHoriz = new LinearLayout(this);
                bottomLayoutHoriz.setLayoutParams(bottomLayoutHorizParams);
                bottomLayoutHoriz.setOrientation(LinearLayout.VERTICAL);

                    txtView1 = new TextView(this);
                    txtView2 = new TextView(this);
                    txtView3 = new TextView(this);
                    txtView1.setLayoutParams(t_temp_params);
                    txtView2.setLayoutParams(t_temp_params);
                    txtView3.setLayoutParams(t_temp_params);

                    button = new Button(this);
                    button.setLayoutParams(buttonParams);
                    button.setId(100 + i);
                    button.setTag(i);
                    button.setOnClickListener(listenerlist[i]);
                    button.setText("Reserve");

            // First line | Brand - Type - Color - Drivetrain
            txtView1.append(inventory.get(indextrack.get(i)).getBrand());
            txtView1.setTypeface(null, Typeface.BOLD);
            txtView1.append(" - ");
            txtView1.append(inventory.get(indextrack.get(i)).getType());
            txtView1.append(" - ");
            txtView1.append(inventory.get(indextrack.get(i)).getColor());
            txtView1.append(" - ");
            txtView1.append(inventory.get(indextrack.get(i)).getDrivewheel());

            // Second line | Touch Screen - GPS - Ent. Sys. - Trailer Hookup
            if (inventory.get(indextrack.get(i)).getTouchscreen()) {
                //txtView2.append(" * ");
                txtView2.append("* Touch Screen ");
            }
            if (inventory.get(indextrack.get(i)).getGPS()) {
                //txtView2.append(" * ");
                txtView2.append("* GPS ");
            }
            if (inventory.get(indextrack.get(i)).getEntsys()) {
                //txtView2.append(" * ");
                txtView2.append("* Ent. Sys. ");
            }
            if (inventory.get(indextrack.get(i)).getTrailer()) {
                //txtView2.append(" * ");
                txtView2.append("* Trailer ");
            }

            // Third line | Leather Seats - Heated Seats - Minibar - Jacuzzi
            if (inventory.get(indextrack.get(i)).getLeather()) {
                //txtView3.append(" * ");
                txtView3.append("* Leather ");
            }
            if (inventory.get(indextrack.get(i)).getHeated()) {
                //txtView3.append(" * ");
                txtView3.append("* Heated Seats ");
            }
            if (inventory.get(indextrack.get(i)).getMinibar()) {
                //txtView3.append(" * ");
                txtView3.append("* Minibar ");

            }
            if (inventory.get(indextrack.get(i)).getJacuzzi()) {
                //txtView3.append(" * ");
                txtView3.append("* Jacuzzi ");
            }

            // add the textviews and buttons to layouts
            bottomLayoutHoriz.addView(txtView1);
            bottomLayoutHoriz.addView(txtView2);
            bottomLayoutHoriz.addView(txtView3);

            // ---------------------

            topLayoutVert.addView(bottomLayoutHoriz);
            topLayoutVert.addView(button);

            btnlist[i] = button;

            // ---------------------

            mainLayoutVert.addView(topLayoutVert);

        } // End of LOOP

    } // END onCreate

}