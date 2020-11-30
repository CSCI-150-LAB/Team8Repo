package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {
SwitchCompat carswitch_1, carswitch_2, carswitch_3, carswitch_4;
boolean StateSwitch_1, StateSwitch_2, StateSwitch_3, StateSwitch_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        StateSwitch_1 = preferences.getBoolean("switch1", false);
        StateSwitch_2 = preferences.getBoolean("switch2", false);
        StateSwitch_3 = preferences.getBoolean("switch3", false);
        StateSwitch_4 = preferences.getBoolean("switch4", false);

        carswitch_1 = (SwitchCompat) findViewById(R.id.carswitch_1);
        carswitch_2 = (SwitchCompat) findViewById(R.id.carswitch_2);
        carswitch_3 = (SwitchCompat) findViewById(R.id.carswitch_3);
        carswitch_4 = (SwitchCompat) findViewById(R.id.carswitch_4);

        carswitch_1.setChecked(StateSwitch_1);
        carswitch_2.setChecked(StateSwitch_2);
        carswitch_3.setChecked(StateSwitch_3);
        carswitch_4.setChecked(StateSwitch_4);

        carswitch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateSwitch_1 = !StateSwitch_1;
                carswitch_1.setChecked(StateSwitch_1);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("carswitch_1", StateSwitch_1);
                editor.apply();
            }
        });
        carswitch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateSwitch_2 = !StateSwitch_2;
                carswitch_2.setChecked(StateSwitch_2);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("carswitch_2", StateSwitch_2);
                editor.apply();
            }
        });
        carswitch_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateSwitch_3 = !StateSwitch_3;
                carswitch_3.setChecked(StateSwitch_3);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("carswitch_3", StateSwitch_3);
                editor.apply();
            }
        });
        carswitch_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateSwitch_4 = !StateSwitch_4;
                carswitch_4.setChecked(StateSwitch_4);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("carswitch_4", StateSwitch_4);
                editor.apply();
            }
        });

    }
}