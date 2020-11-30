package com.example.mycar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//public class Select implements Car extends AppCompatActivity
public class Select extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        // Re-create inventory ArrayList
        ArrayList<Car> inventoryList = (ArrayList<Car>) getIntent().getSerializableExtra("inventoryList");

        // Re-create indextracker Arraylist
        ArrayList<Integer> indextrackList = (ArrayList<Integer>) getIntent().getSerializableExtra("indextrackList");

        // Dynamic generation of results

        int resultsize = indextrackList.size();

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

        // Listener LOOP
        for (int i = 0; i < resultsize; i++) {

            final int index = i;
            listenerlist[i] = new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(Select.this,"TEST" + index, Toast.LENGTH_SHORT).show();

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
            txtView1.append(inventoryList.get(indextrackList.get(i)).getBrand());
            txtView1.setTypeface(null, Typeface.BOLD);
            txtView1.append(" - ");
            txtView1.append(inventoryList.get(indextrackList.get(i)).getType());
            txtView1.append(" - ");
            txtView1.append(inventoryList.get(indextrackList.get(i)).getColor());
            txtView1.append(" - ");
            txtView1.append(inventoryList.get(indextrackList.get(i)).getDrivewheel());

            // Second line | Touch Screen - GPS - Ent. Sys. - Trailer Hookup
            if (inventoryList.get(indextrackList.get(i)).getTouchscreen()) {
                txtView2.append(" * ");
                txtView2.append("Touch Screen");
            }
            if (inventoryList.get(indextrackList.get(i)).getGPS()) {
                txtView2.append(" * ");
                txtView2.append("GPS");
            }
            if (inventoryList.get(indextrackList.get(i)).getEntsys()) {
                txtView2.append(" * ");
                txtView2.append("Ent. Sys.");
            }
            if (inventoryList.get(indextrackList.get(i)).getTrailer()) {
                txtView2.append(" * ");
                txtView2.append("Trailer");
            }

            // Third line | Leather Seats - Heated Seats - Minibar - Jacuzzi
            if (inventoryList.get(indextrackList.get(i)).getLeather()) {
                txtView3.append(" * ");
                txtView3.append("Leather");
            }
            if (inventoryList.get(indextrackList.get(i)).getHeated()) {
                txtView3.append(" * ");
                txtView3.append("Heated Seats");
            }
            if (inventoryList.get(indextrackList.get(i)).getMinibar()) {
                txtView3.append(" * ");
                txtView3.append("Minibar");

            }
            if (inventoryList.get(indextrackList.get(i)).getJacuzzi()) {
                txtView3.append(" * ");
                txtView3.append("Jacuzzi");
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