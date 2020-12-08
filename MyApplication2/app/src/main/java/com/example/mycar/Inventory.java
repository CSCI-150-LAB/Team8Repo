package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Car> inventory = new ArrayList<Car>();

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
    Car car26 = new Car("Ferrari","Sports","Red","All Wheel",true,true,false,false,true,true,false,false,2);
    Car car27 = new Car("Ferrari","Luxury","Black","All Wheel",false,false,false,false,false,false,false,false,2);

    {
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
    }

    public ArrayList<Car> exportInventory() {

        return inventory;
    }

}
