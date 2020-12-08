package com.example.mycar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DealerReservation extends AppCompatActivity {
    Car car1 = new Car("Audi","Coupe","Black","All Wheel",true,true,true,true,true,true,true,true,2);
    Car car2 = new Car("BMW","Hatchback","Blue","Front Wheel",false,false,true,false,false,false,true,false,2);
    Car car3 = new Car("Lamborghini","SUV","Yellow","All Wheel",false,false,true,false,false,false,false,false,2);
    Car car4 = new Car("Lexus","SUV","Yellow","All Wheel",false,false,false,true,false,false,false,false,2);
    Car car5 = new Car("Mercedes-Benz","SUV","Yellow","All Wheel",false,false,false,false,true,false,false,false,2);
    Car car6 = new Car("Ford","Sedan","Purple","All Wheel",false,false,false,false,false,false,false,false,2);

    ArrayList<String> user0 = new ArrayList<>();
    ArrayList<String> user1 = new ArrayList<>();
    ArrayList<String> user2 = new ArrayList<>();
    ArrayList<String> user3 = new ArrayList<>();
    ArrayList<String> reserveDates = new ArrayList<>();

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    EditText et_itemSearch;
    Button bt_search;
    ListView listView;
    ArrayList<Car> inventory = new ArrayList<Car>();
    ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();

    ListView pp_lv_userInfo, pp_lv_reserveInfo;
    Button pp_bt_delete, pp_bt_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_reservation);
        et_itemSearch = findViewById(R.id.et_itemSearch);
        bt_search = findViewById(R.id.bt_search);
        listView = findViewById(R.id.listView);

        inventory.add(car1);
        inventory.add(car2);
        inventory.add(car3);
        inventory.add(car4);
        inventory.add(car5);
        inventory.add(car6);

        user0.add("Dealer Car Testing");
        user0.add("userfake23@gmail.com");
        user1.add("My Car");
        user1.add("mycar1@gmail.com");
        user2.add("Fake Name");
        user2.add("mycartest@gmail.com");
        user3.add("Fake Name 2");
        user3.add("anothertest@gmail.com");

        users.add(user0);
        users.add(user1);
        users.add(user2);

        reserveDates.add("12/20/2020 - 12/23/2020");
        reserveDates.add("12/21/2020");
        reserveDates.add("01/21/2020 - 01/28/2020");
        reserveDates.add("01/21/2020 - 01/28/2020");

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(DealerReservation.this, R.layout.list_item, list);
        listView.setAdapter(adapter);
        list.clear();

        /*
        int i;
        for (i=0; i < 2; i++) {
            list.add(users.get(i).get(0) + " - " + users.get(i).get(1) + " - " + "\n" + inventory.get(i).getBrand() + " - " + inventory.get(i).getType() + " - " + inventory.get(i).getColor() + " - " + inventory.get(i).getDrivewheel());
            adapter.notifyDataSetChanged();
        }*/
        String dealerID = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        switch(dealerID) {
            case "3HtcdLLlGhMv7wGEBWFp7YGfEjV2":
                String carInfo0 = "";
                String carInfo1 = "";
                if (inventory.get(0).getTouchscreen()) {carInfo0 = carInfo0.concat("* Touch Screen ");}
                if (inventory.get(0).getGPS()) {carInfo0 = carInfo0.concat("* GPS ");}
                if (inventory.get(0).getEntsys()) {carInfo0 = carInfo0.concat("* Ent. Sys. ");}
                if (inventory.get(0).getTrailer()) {carInfo0 = carInfo0.concat("* Trailer ");}
                if (inventory.get(0).getLeather()) {carInfo0 = carInfo0.concat("* Leather ");}
                if (inventory.get(0).getHeated()) {carInfo0 = carInfo0.concat("* Heated Seats ");}
                if (inventory.get(0).getMinibar()) {carInfo0 = carInfo0.concat("* Minibar ");}
                if (inventory.get(0).getJacuzzi()) {carInfo0 = carInfo0.concat("* Jacuzzi ");}

                if (inventory.get(1).getTouchscreen()) {carInfo1 = carInfo1.concat("* Touch Screen ");}
                if (inventory.get(1).getGPS()) {carInfo1 = carInfo1.concat("* GPS ");}
                if (inventory.get(1).getEntsys()) {carInfo1 = carInfo1.concat("* Ent. Sys. ");}
                if (inventory.get(1).getTrailer()) {carInfo1 = carInfo1.concat("* Trailer ");}
                if (inventory.get(1).getLeather()) {carInfo1 = carInfo1.concat("* Leather ");}
                if (inventory.get(1).getHeated()) {carInfo1 = carInfo1.concat("* Heated Seats ");}
                if (inventory.get(1).getMinibar()) {carInfo1 = carInfo1.concat("* Minibar ");}
                if (inventory.get(1).getJacuzzi()) {carInfo1 = carInfo1.concat("* Jacuzzi ");}


                list.add(users.get(0).get(0) + " - " + users.get(0).get(1) + "\n" +
                        inventory.get(0).getBrand() + " - " + inventory.get(0).getType() + " - " +
                        inventory.get(0).getColor() + " - " + inventory.get(0).getDrivewheel() + "\n" +
                        carInfo0 + "\n" + reserveDates.get(0));
                adapter.notifyDataSetChanged();
                list.add(users.get(1).get(0) + " - " + users.get(1).get(1) + "\n" +
                        inventory.get(1).getBrand() + " - " + inventory.get(1).getType() + " - " +
                        inventory.get(1).getColor() + " - " + inventory.get(1).getDrivewheel() + "\n" +
                        carInfo1 + "\n" + reserveDates.get(1));
                adapter.notifyDataSetChanged();
                break;
            case "dn4T5uJqxfMwvmnKIk3g6AadJTI3":
                String carInfo2 = "";
                String carInfo3 = "";
                if (inventory.get(2).getTouchscreen()) {carInfo2 = carInfo2.concat("*Touch Screen ");}
                if (inventory.get(2).getGPS()) {carInfo2 = carInfo2.concat("*GPS ");}
                if (inventory.get(2).getEntsys()) {carInfo2 = carInfo2.concat("*Ent. Sys. ");}
                if (inventory.get(2).getTrailer()) {carInfo2 = carInfo2.concat("*Trailer ");}
                if (inventory.get(2).getLeather()) {carInfo2 = carInfo2.concat("*Leather ");}
                if (inventory.get(2).getHeated()) {carInfo2 = carInfo2.concat("*Heated Seats ");}
                if (inventory.get(2).getMinibar()) {carInfo2 = carInfo2.concat("*Minibar ");}
                if (inventory.get(2).getJacuzzi()) {carInfo2 = carInfo2.concat("*Jacuzzi ");}

                if (inventory.get(3).getTouchscreen()) {carInfo3 = carInfo3.concat("*Touch Screen ");}
                if (inventory.get(3).getGPS()) {carInfo3 = carInfo3.concat("*GPS ");}
                if (inventory.get(3).getEntsys()) {carInfo3 = carInfo3.concat("*Ent. Sys. ");}
                if (inventory.get(3).getTrailer()) {carInfo3 = carInfo3.concat("*Trailer ");}
                if (inventory.get(3).getLeather()) {carInfo3 = carInfo3.concat("*Leather ");}
                if (inventory.get(3).getHeated()) {carInfo3 = carInfo3.concat("*Heated Seats ");}
                if (inventory.get(3).getMinibar()) {carInfo3 = carInfo3.concat("*Minibar ");}
                if (inventory.get(3).getJacuzzi()) {carInfo3 = carInfo3.concat("*Jacuzzi ");}
                list.add(users.get(3).get(0) + " - " + users.get(3).get(1) + "\n" +
                        inventory.get(3).getBrand() + " - " + inventory.get(3).getType() + " - " +
                        inventory.get(3).getColor() + " - " + inventory.get(3).getDrivewheel()  + "\n" +
                        carInfo3  + "\n" + reserveDates.get(3));
                adapter.notifyDataSetChanged();
                list.add(users.get(2).get(0) + " - " + users.get(2).get(1) + "\n" +
                        inventory.get(2).getBrand() + " - " + inventory.get(2).getType() + " - " +
                        inventory.get(2).getColor() + " - " + inventory.get(2).getDrivewheel()  + "\n" +
                        carInfo2  + "\n" + reserveDates.get(2));
                adapter.notifyDataSetChanged();
                break;
            default:
                Toast.makeText(DealerReservation.this, "Error!", Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String userData = (listView.getItemAtPosition(i)).toString();
                userView(userData);
            }
        });
    }

    private void userView(String userData) {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.dealer_reservation_popup, null);

        final String[] uData = userData.split("\\r?\\n");

        pp_lv_userInfo = (ListView) contactPopupView.findViewById(R.id.lV_userInfo);
        pp_lv_reserveInfo = (ListView) contactPopupView.findViewById(R.id.lv_reserveInfo);
        pp_bt_delete = (Button) contactPopupView.findViewById(R.id.bt_delete);
        pp_bt_return = (Button) contactPopupView.findViewById(R.id.bt_return);

        final ArrayList<String> userList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(DealerReservation.this, R.layout.list_item, userList);
        pp_lv_userInfo.setAdapter(adapter);
        userList.add(uData[0]);

        final ArrayList<String> reserveInfoList = new ArrayList<>();
        final ArrayAdapter adapter1 = new ArrayAdapter<String>(DealerReservation.this, R.layout.list_item, reserveInfoList);
        pp_lv_reserveInfo.setAdapter(adapter1);
        reserveInfoList.add(uData[1].concat("\n" + uData[2]));
        reserveInfoList.add(uData[3]);
        //reserveInfoList.add(uData[2]);


        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        pp_bt_delete.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder deleteDialog = new AlertDialog.Builder(DealerReservation.this);
                deleteDialog.setTitle("Are you sure?");
                deleteDialog.setMessage("Cancelling this reservation will remove it.");
                deleteDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*
                        AlertDialog.Builder successDialog = new AlertDialog.Builder(DealerReservation.this);
                        successDialog.setTitle("Reservation Cancelled");
                        successDialog.setMessage("The reservation was successfully cancelled and the customer will be notified of the cancellation.");
                        successDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        successDialog.show();
                        */
                        AlertDialog.Builder errorDialog = new AlertDialog.Builder(DealerReservation.this);
                        errorDialog.setTitle("Error");
                        errorDialog.setMessage("There was an error cancelling the reservation. Please contact the MyCar Support staff if you wish to continue with the cancellation.");
                        errorDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        errorDialog.show();
                    }
                });
                deleteDialog.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                deleteDialog.show();
            }
        }));

        pp_bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
