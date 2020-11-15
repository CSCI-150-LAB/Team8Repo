package com.example.myapplication2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

//public class Select implements Car extends AppCompatActivity
public class Select extends AppCompatActivity {

    /*
    TextView textView_result1;
    TextView textView_result2;
    TextView textView_result3;
    TextView textView_result4;
    TextView textView_result5;
    TextView textView_result6;
    TextView textView_result7;
    TextView textView_result8;
    TextView textView_result9;
    TextView textView_result10;
    TextView textView_result11;
    TextView textView_result12;
    TextView textView_result13;
    TextView textView_result14;
    TextView textView_result15;
    TextView textView_result16;
    TextView textView_result17;
    TextView textView_result18;
    TextView textView_result19;
    TextView textView_result20;
    TextView textView_result21;
    TextView textView_result22;
    TextView textView_result23;
    TextView textView_result24;
    TextView textView_result25;
     */

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        // Re-create inventory ArrayList
        ArrayList<Car> inventoryList = (ArrayList<Car>) getIntent().getSerializableExtra("inventorylist");

        // Re-create indextracker Arraylist
        ArrayList<Integer> indextrackList = (ArrayList<Integer>) getIntent().getSerializableExtra("indextracklist");

        // Globals


        // Set textview fields
        /*
        textView_result1 = findViewById(R.id.textView_result1);
        textView_result2 = findViewById(R.id.textView_result2);
        textView_result3 = findViewById(R.id.textView_result3);
        textView_result4 = findViewById(R.id.textView_result4);
        textView_result5 = findViewById(R.id.textView_result5);
        textView_result6 = findViewById(R.id.textView_result6);
        textView_result7 = findViewById(R.id.textView_result7);
        textView_result8 = findViewById(R.id.textView_result8);
        textView_result9 = findViewById(R.id.textView_result9);
        textView_result10 = findViewById(R.id.textView_result10);
        textView_result11 = findViewById(R.id.textView_result11);
        textView_result12 = findViewById(R.id.textView_result12);
        textView_result13 = findViewById(R.id.textView_result13);
        textView_result14 = findViewById(R.id.textView_result14);
        textView_result15 = findViewById(R.id.textView_result15);
        textView_result16 = findViewById(R.id.textView_result16);
        textView_result17 = findViewById(R.id.textView_result17);
        textView_result18 = findViewById(R.id.textView_result18);
        textView_result19 = findViewById(R.id.textView_result19);
        textView_result20 = findViewById(R.id.textView_result20);
        textView_result21 = findViewById(R.id.textView_result21);
        textView_result22 = findViewById(R.id.textView_result22);
        textView_result23 = findViewById(R.id.textView_result23);
        textView_result24 = findViewById(R.id.textView_result24);
        textView_result25 = findViewById(R.id.textView_result25);
         */

        // ------------------------------------------------------

        int resultsize = indextrackList.size();
        resultsize = resultsize * 4;
        LinearLayout resultlist = findViewById(R.id.resultlist);
        //RadioGroup rgp = findViewById(R.id.radio_group);
        //RadioGroup.LayoutParams rprms;

        TextView[] resultview = new TextView[resultsize];
        TextView temp1;
        TextView temp2;
        TextView temp3;
        TextView temp4;

        int indexcounter = 0;

        // ============================= LOOP ==============================
        for (int i = 0; i < resultsize; i = i + 4)
        {
            temp1 = new TextView(this);
            temp2 = new TextView(this);
            temp3 = new TextView(this);
            temp4 = new TextView(this);

            // First line | Brand - Type - Color - Drivetrain
            temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getBrand());
            temp1.append(" - ");
            temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getType());
            temp1.append(" - ");
            temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getColor());
            temp1.append(" - ");
            temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getDrivewheel());

            // Radio Group Generation
            //RadioButton rbn = new RadioButton(this);
            //rbn.setId(View.generateViewId());
            //rgp.addView(rbn);

            // Second line | Touch Screen - GPS - Ent. Sys. - Trailer Hookup
            if (inventoryList.get(indextrackList.get(indexcounter)).getTouchscreen()) {
                temp2.append(" - ");
                temp2.append("Touch Screen");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getGPS()) {
                temp2.append(" - ");
                temp2.append("GPS");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getEntsys()) {
                temp2.append(" - ");
                temp2.append("Ent. Sys.");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getTrailer()) {
                temp2.append(" - ");
                temp2.append("Trailer Hookup");
            }

            // Third line | Leather Seats - Heated Seats - Minibar - Jacuzzi
            if (inventoryList.get(indextrackList.get(indexcounter)).getLeather()) {
                temp2.append(" - ");
                temp3.append("Leather");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getHeated()) {
                temp3.append(" - ");
                temp3.append("Heated Seats");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getMinibar()) {
                temp3.append(" - ");
                temp3.append("Minibar");

            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getJacuzzi()) {
                temp3.append(" - ");
                temp3.append("Jacuzzi");
            }

            // Fourth line | Separator
            temp4.append("----------------------------------------------------------------------------------");

            indexcounter++;

            // add the textview to the linearlayout
            resultlist.addView(temp1);
            resultlist.addView(temp2);
            resultlist.addView(temp3);
            resultlist.addView(temp4);

            resultview[i] = temp1;
            resultview[i+1] = temp2;
            resultview[i+2] = temp3;
            resultview[i+3] = temp4;

        } // End of LOOP



        //textView_result1.append(String.valueOf(indextrackList.size()));



        // Assign textview fields
        //textView_result1.setText(inventoryList.get(2).getBrand());

        //int loopsize = indextrackList.size();
        //String stringtest = String.valueOf(loopsize);
        //String stringtest = Integer.toString(loopsize);
        //int i = loopsize.intValue();

        //textView_result1.append(stringtest);

        //for (int i = 0; i < loopsize; i++) {
        //for (int i = 0; i < inventoryList.size(); i++) {

        //textView_result1.append(inventoryList.get(i).getBrand());
        //}

        //textView_result2.append(Integer.toString(5));

    }

}