package com.example.mycar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminModFee extends AppCompatActivity {
    EditText et_itemSearch;
    Button bt_search, bt_inventory;
    ListView listView;


    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    ListView pp_listView;
    EditText pp_et_fee;
    Button pp_bt_save, pp_bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mod_fee);
        et_itemSearch = findViewById(R.id.et_itemSearch);
        bt_search = findViewById(R.id.bt_search);
        bt_inventory = findViewById(R.id.bt_inventory);
        listView = findViewById(R.id.listView);


        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> list = new ArrayList<>();
                final ArrayAdapter adapter = new ArrayAdapter<String>(AdminModFee.this, R.layout.list_item, list);
                listView.setAdapter(adapter);
                try {
                    DatabaseReference referenceDealer = FirebaseDatabase.getInstance().getReference().child("Inventory").child(et_itemSearch.getText().toString());
                    referenceDealer.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                list.clear();
                                list.add(dataSnapshot.getKey().toString() + "\n" + dataSnapshot.getValue().toString());
                                adapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
                catch (Exception e) {}
            }
        });

        bt_inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> list = new ArrayList<>();
                final ArrayAdapter adapter = new ArrayAdapter<String>(AdminModFee.this, R.layout.list_item, list);
                listView.setAdapter(adapter);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Inventory");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            list.add(snapshot.getKey().toString() + "\n" + snapshot.getValue().toString());
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ModifyFees.this, "Test!", Toast.LENGTH_SHORT).show();
                String feeData = (listView.getItemAtPosition(i)).toString();
                feeEdit(feeData);
            }
        });
    }

    public void feeEdit(final String feeData) {
        dialogBuilder = new AlertDialog.Builder(AdminModFee.this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.admin_mod_fee_popup, null);
        final String[] fData = feeData.split("\\r?\\n");
        final String[] arrData = convertInvtArray(fData[1]);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(AdminModFee.this, R.layout.list_item, list);

        pp_listView = (ListView) contactPopupView.findViewById(R.id.listView);
        pp_listView.setAdapter(adapter);
        list.clear();
        list.add(feeData);
        pp_et_fee = (EditText) contactPopupView.findViewById(R.id.et_fee);
        pp_et_fee.setText(arrData[2]);
        pp_bt_save = (Button) contactPopupView.findViewById(R.id.bt_save);
        pp_bt_cancel = (Button) contactPopupView.findViewById(R.id.bt_cancel);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();


        pp_bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String , Object> map = new HashMap<>();
                map.put("brand", arrData[13]);
                map.put("color", arrData[0]);
                map.put("drivewheel", arrData[3]);
                map.put("entsys", Boolean.parseBoolean(arrData[12]));
                map.put("fee", Integer.parseInt(pp_et_fee.getText().toString()));
                map.put("gps", Boolean.parseBoolean(arrData[5]));
                map.put("heated", Boolean.parseBoolean(arrData[11]));
                map.put("jacuzzi", Boolean.parseBoolean(arrData[1]));
                map.put("leather", Boolean.parseBoolean(arrData[7]));
                map.put("minibar", Boolean.parseBoolean(arrData[8]));
                map.put("qty", Integer.parseInt(arrData[10]));
                map.put("touchscreen", Boolean.parseBoolean(arrData[4]));
                map.put("trailer", Boolean.parseBoolean(arrData[9]));
                map.put("type", arrData[6]);


                FirebaseDatabase.getInstance().getReference().child("Inventory").child(fData[0]).updateChildren(map);
                Toast.makeText(AdminModFee.this, "Account was updated!", Toast.LENGTH_SHORT).show();
            }
        });
        pp_bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public String[] convertInvtArray(String invtString) {
        String[] invtArray;

        invtString = invtString.substring(1, invtString.length()-1);
        invtArray = invtString.split(",");
        invtArray[0] = invtArray[0].substring(6); //color
        invtArray[1] = invtArray[1].substring(9); //jacuzzi
        invtArray[2] = invtArray[2].substring(5); //fee
        invtArray[3] = invtArray[3].substring(12); //drivewheel
        invtArray[4] = invtArray[4].substring(13); //touchscreen
        invtArray[5] = invtArray[5].substring(5); //gps
        invtArray[6] = invtArray[6].substring(6); //type
        invtArray[7] = invtArray[7].substring(9); //leather
        invtArray[8] = invtArray[8].substring(9); //minibar
        invtArray[9] = invtArray[9].substring(9); //trailer
        invtArray[10] = invtArray[10].substring(5); //qty
        invtArray[11] = invtArray[11].substring(8); //heated
        invtArray[12] = invtArray[12].substring(8); //entsys
        invtArray[13] = invtArray[13].substring(7); //brand

        return invtArray;

    }
}