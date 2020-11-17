package com.example.myapplication2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

//public class Select implements Car extends AppCompatActivity
public class Select extends AppCompatActivity {

    /*
    TextView textView_result1_1;
    TextView textView_result1_2;
    TextView textView_result1_3;

    TextView textView_result2_1;
    TextView textView_result2_2;
    TextView textView_result2_3;

    TextView textView_result3_1;
    TextView textView_result3_2;
    TextView textView_result3_3;

    TextView textView_result4_1;
    TextView textView_result4_2;
    TextView textView_result4_3;

    TextView textView_result5_1;
    TextView textView_result5_2;
    TextView textView_result5_3;

    TextView textView_result6_1;
    TextView textView_result6_2;
    TextView textView_result6_3;

    TextView textView_result7_1;
    TextView textView_result7_2;
    TextView textView_result7_3;

    TextView textView_result8_1;
    TextView textView_result8_2;
    TextView textView_result8_3;

    TextView textView_result9_1;
    TextView textView_result9_2;
    TextView textView_result9_3;

    TextView textView_result10_1;
    TextView textView_result10_2;
    TextView textView_result10_3;

    TextView textView_result11_1;
    TextView textView_result11_2;
    TextView textView_result11_3;

    TextView textView_result12_1;
    TextView textView_result12_2;
    TextView textView_result12_3;

    TextView textView_result13_1;
    TextView textView_result13_2;
    TextView textView_result13_3;

    TextView textView_result14_1;
    TextView textView_result14_2;
    TextView textView_result14_3;

    TextView textView_result15_1;
    TextView textView_result15_2;
    TextView textView_result15_3;

    TextView textView_result16_1;
    TextView textView_result16_2;
    TextView textView_result16_3;

    TextView textView_result17_1;
    TextView textView_result17_2;
    TextView textView_result17_3;

    TextView textView_result18_1;
    TextView textView_result18_2;
    TextView textView_result18_3;

    TextView textView_result19_1;
    TextView textView_result19_2;
    TextView textView_result19_3;

    TextView textView_result20_1;
    TextView textView_result20_2;
    TextView textView_result20_3;

    TextView textView_result21_1;
    TextView textView_result21_2;
    TextView textView_result21_3;

    TextView textView_result22_1;
    TextView textView_result22_2;
    TextView textView_result22_3;

    TextView textView_result23_1;
    TextView textView_result23_2;
    TextView textView_result23_3;

    TextView textView_result24_1;
    TextView textView_result24_2;
    TextView textView_result24_3;

    TextView textView_result25_1;
    TextView textView_result25_2;
    TextView textView_result25_3;

    TextView textView_result26_1;
    TextView textView_result26_2;
    TextView textView_result26_3;

    TextView textView_result27_1;
    TextView textView_result27_2;
    TextView textView_result27_3;

    TextView textView_result28_1;
    TextView textView_result28_2;
    TextView textView_result28_3;

    TextView textView_result29_1;
    TextView textView_result29_2;
    TextView textView_result29_3;

    TextView textView_result30_1;
    TextView textView_result30_2;
    TextView textView_result30_3;

    TextView textView_result31_1;
    TextView textView_result31_2;
    TextView textView_result31_3;

    TextView textView_result32_1;
    TextView textView_result32_2;
    TextView textView_result32_3;

    TextView textView_result33_1;
    TextView textView_result33_2;
    TextView textView_result33_3;

    TextView textView_result34_1;
    TextView textView_result34_2;
    TextView textView_result34_3;

    TextView textView_result35_1;
    TextView textView_result35_2;
    TextView textView_result35_3;

    TextView textView_result36_1;
    TextView textView_result36_2;
    TextView textView_result36_3;

    TextView textView_result37_1;
    TextView textView_result37_2;
    TextView textView_result37_3;

    TextView textView_result38_1;
    TextView textView_result38_2;
    TextView textView_result38_3;

    TextView textView_result39_1;
    TextView textView_result39_2;
    TextView textView_result39_3;

    TextView textView_result40_1;
    TextView textView_result40_2;
    TextView textView_result40_3;

    TextView textView_result41_1;
    TextView textView_result41_2;
    TextView textView_result41_3;

    TextView textView_result42_1;
    TextView textView_result42_2;
    TextView textView_result42_3;

    TextView textView_result43_1;
    TextView textView_result43_2;
    TextView textView_result43_3;

    TextView textView_result44_1;
    TextView textView_result44_2;
    TextView textView_result44_3;

    TextView textView_result45_1;
    TextView textView_result45_2;
    TextView textView_result45_3;

    TextView textView_result46_1;
    TextView textView_result46_2;
    TextView textView_result46_3;

    TextView textView_result47_1;
    TextView textView_result47_2;
    TextView textView_result47_3;

    TextView textView_result48_1;
    TextView textView_result48_2;
    TextView textView_result48_3;

    TextView textView_result49_1;
    TextView textView_result49_2;
    TextView textView_result49_3;

    TextView textView_result50_1;
    TextView textView_result50_2;
    TextView textView_result50_3;


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

        textView_result1_1 = findViewById(R.id.textView_result1_1);
        textView_result1_2 = findViewById(R.id.textView_result1_2);
        textView_result1_3 = findViewById(R.id.textView_result1_3);

        textView_result2_1 = findViewById(R.id.textView_result2_1);
        textView_result2_2 = findViewById(R.id.textView_result2_2);
        textView_result2_3 = findViewById(R.id.textView_result2_3);

        textView_result3_1 = findViewById(R.id.textView_result3_1);
        textView_result3_2 = findViewById(R.id.textView_result3_2);
        textView_result3_3 = findViewById(R.id.textView_result3_3);

        textView_result4_1 = findViewById(R.id.textView_result4_1);
        textView_result4_2 = findViewById(R.id.textView_result4_2);
        textView_result4_3 = findViewById(R.id.textView_result4_3);

        textView_result5_1 = findViewById(R.id.textView_result5_1);
        textView_result5_2 = findViewById(R.id.textView_result5_2);
        textView_result5_3 = findViewById(R.id.textView_result5_3);

        textView_result6_1 = findViewById(R.id.textView_result6_1);
        textView_result6_2 = findViewById(R.id.textView_result6_2);
        textView_result6_3 = findViewById(R.id.textView_result6_3);

        textView_result7_1 = findViewById(R.id.textView_result7_1);
        textView_result7_2 = findViewById(R.id.textView_result7_2);
        textView_result7_3 = findViewById(R.id.textView_result7_3);

        textView_result8_1 = findViewById(R.id.textView_result8_1);
        textView_result8_2 = findViewById(R.id.textView_result8_2);
        textView_result8_3 = findViewById(R.id.textView_result8_3);

        textView_result9_1 = findViewById(R.id.textView_result9_1);
        textView_result9_2 = findViewById(R.id.textView_result9_2);
        textView_result9_3 = findViewById(R.id.textView_result9_3);

        textView_result10_1 = findViewById(R.id.textView_result10_1);
        textView_result10_2 = findViewById(R.id.textView_result10_2);
        textView_result10_3 = findViewById(R.id.textView_result10_3);

        textView_result11_1 = findViewById(R.id.textView_result11_1);
        textView_result11_2 = findViewById(R.id.textView_result11_2);
        textView_result11_3 = findViewById(R.id.textView_result11_3);

        textView_result12_1 = findViewById(R.id.textView_result12_1);
        textView_result12_2 = findViewById(R.id.textView_result12_2);
        textView_result12_3 = findViewById(R.id.textView_result12_3);

        textView_result13_1 = findViewById(R.id.textView_result13_1);
        textView_result13_2 = findViewById(R.id.textView_result13_2);
        textView_result13_3 = findViewById(R.id.textView_result13_3);

        textView_result14_1 = findViewById(R.id.textView_result14_1);
        textView_result14_2 = findViewById(R.id.textView_result14_2);
        textView_result14_3 = findViewById(R.id.textView_result14_3);

        textView_result15_1 = findViewById(R.id.textView_result15_1);
        textView_result15_2 = findViewById(R.id.textView_result15_2);
        textView_result15_3 = findViewById(R.id.textView_result15_3);

        textView_result16_1 = findViewById(R.id.textView_result16_1);
        textView_result16_2 = findViewById(R.id.textView_result16_2);
        textView_result16_3 = findViewById(R.id.textView_result16_3);

        textView_result17_1 = findViewById(R.id.textView_result17_1);
        textView_result17_2 = findViewById(R.id.textView_result17_2);
        textView_result17_3 = findViewById(R.id.textView_result17_3);

        textView_result18_1 = findViewById(R.id.textView_result18_1);
        textView_result18_2 = findViewById(R.id.textView_result18_2);
        textView_result18_3 = findViewById(R.id.textView_result18_3);

        textView_result19_1 = findViewById(R.id.textView_result19_1);
        textView_result19_2 = findViewById(R.id.textView_result19_2);
        textView_result19_3 = findViewById(R.id.textView_result19_3);

        textView_result20_1 = findViewById(R.id.textView_result20_1);
        textView_result20_2 = findViewById(R.id.textView_result20_2);
        textView_result20_3 = findViewById(R.id.textView_result20_3);

        textView_result21_1 = findViewById(R.id.textView_result21_1);
        textView_result21_2 = findViewById(R.id.textView_result21_2);
        textView_result21_3 = findViewById(R.id.textView_result21_3);

        textView_result22_1 = findViewById(R.id.textView_result22_1);
        textView_result22_2 = findViewById(R.id.textView_result22_2);
        textView_result22_3 = findViewById(R.id.textView_result22_3);

        textView_result23_1 = findViewById(R.id.textView_result23_1);
        textView_result23_2 = findViewById(R.id.textView_result23_2);
        textView_result23_3 = findViewById(R.id.textView_result23_3);

        textView_result24_1 = findViewById(R.id.textView_result24_1);
        textView_result24_2 = findViewById(R.id.textView_result24_2);
        textView_result24_3 = findViewById(R.id.textView_result24_3);

        textView_result25_1 = findViewById(R.id.textView_result25_1);
        textView_result25_2 = findViewById(R.id.textView_result25_2);
        textView_result25_3 = findViewById(R.id.textView_result25_3);

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


        // First line | Brand - Type - Color - Drivetrain
        /*
        temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getBrand());
        temp1.append(" - ");
        temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getType());
        temp1.append(" - ");
        temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getColor());
        temp1.append(" - ");
        temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getDrivewheel());
        */


        // ------------------------------------------------------
        // Dynamic generation of results

        int resultsize = indextrackList.size();
        resultsize = resultsize * 3;
        ScrollView ScrollView = findViewById(R.id.ScrollView);
        LinearLayout resultlist = findViewById(R.id.resultlist);

        LinearLayout[] resultgroup = new LinearLayout[resultsize];
        LinearLayout l1_temp;
        LinearLayout.LayoutParams l1_temp_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300);

            LinearLayout[] textgroup = new LinearLayout[resultsize];
            LinearLayout l2_temp;
            LinearLayout.LayoutParams l2_temp_params = new LinearLayout.LayoutParams(800, LinearLayout.LayoutParams.MATCH_PARENT);

                TextView[] textlist = new TextView[resultsize];
                TextView t_temp1;
                TextView t_temp2;
                TextView t_temp3;
                LinearLayout.LayoutParams t_temp_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            Button[] btnlist = new Button[resultsize];
            Button b_temp;
            LinearLayout.LayoutParams b_temp_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        int indexcounter = 0;

        // ============================= LOOP ==============================

        for (int i = 0; i < resultsize; i = i + 3)
        {
            l1_temp = new LinearLayout(this);
            l1_temp.setLayoutParams(l1_temp_params);
            l1_temp.setOrientation(LinearLayout.HORIZONTAL);

                l2_temp = new LinearLayout(this);
                l2_temp.setLayoutParams(l2_temp_params);
                l2_temp.setOrientation(LinearLayout.VERTICAL);

                    t_temp1 = new TextView(this);
                    t_temp2 = new TextView(this);
                    t_temp3 = new TextView(this);
                    t_temp1.setLayoutParams(t_temp_params);
                    t_temp2.setLayoutParams(t_temp_params);
                    t_temp3.setLayoutParams(t_temp_params);

                b_temp = new Button(this);
                b_temp.setLayoutParams(b_temp_params);
                b_temp.setId(100 + indexcounter);
                b_temp.setTag(indexcounter);
                b_temp.setText("Reserve");

            // First line | Brand - Type - Color - Drivetrain
            t_temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getBrand());
            t_temp1.setTypeface(null, Typeface.BOLD);
            t_temp1.append(" - ");
            t_temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getType());
            t_temp1.append(" - ");
            t_temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getColor());
            t_temp1.append(" - ");
            t_temp1.append(inventoryList.get(indextrackList.get(indexcounter)).getDrivewheel());

            // Second line | Touch Screen - GPS - Ent. Sys. - Trailer Hookup
            if (inventoryList.get(indextrackList.get(indexcounter)).getTouchscreen()) {
                t_temp2.append(" - ");
                t_temp2.append("Touch Screen");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getGPS()) {
                t_temp2.append(" - ");
                t_temp2.append("GPS");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getEntsys()) {
                t_temp2.append(" - ");
                t_temp2.append("Ent. Sys.");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getTrailer()) {
                t_temp2.append(" - ");
                t_temp2.append("Trailer Hookup");
            }

            // Third line | Leather Seats - Heated Seats - Minibar - Jacuzzi
            if (inventoryList.get(indextrackList.get(indexcounter)).getLeather()) {

                t_temp2.append(" - ");
                t_temp3.append("Leather");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getHeated()) {
                t_temp3.append(" - ");
                t_temp3.append("Heated Seats");
            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getMinibar()) {
                t_temp3.append(" - ");
                t_temp3.append("Minibar");

            }
            if (inventoryList.get(indextrackList.get(indexcounter)).getJacuzzi()) {
                t_temp3.append(" - ");
                t_temp3.append("Jacuzzi");
            }

            indexcounter++;

            // add the textviews and buttons to layouts
            l2_temp.addView(t_temp1);
            l2_temp.addView(t_temp2);
            l2_temp.addView(t_temp3);

            textlist[i] = t_temp1;
            textlist[i+1] = t_temp2;
            textlist[i+2] = t_temp3;
            // ---------------------
            l1_temp.addView(l2_temp);
            l1_temp.addView(b_temp);

            textgroup[i] = l2_temp;
            btnlist[i] = b_temp;
            // ---------------------
            resultlist.addView(l1_temp);

            //resultgroup[i] = l1_temp;


        } // End of LOOP

        /*
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                doAction(v.getTag());
            }
        };
        */

    }

}