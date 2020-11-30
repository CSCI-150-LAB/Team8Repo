package com.example.mycar;

public class Inventory extends Car{

    //public static void main(String args[]) {

    //    Inventory inv = new Inventory();
    //}


    public Inventory(String brand, String type, String color, String drivewheel, Boolean touchscreen, Boolean gps, Boolean entsys, Boolean trailer, Boolean leather, Boolean heated, Boolean minibar, Boolean jacuzzi, int qty) {
        super(brand, type, color, drivewheel, touchscreen, gps, entsys, trailer, leather, heated, minibar, jacuzzi, qty);
    }

    //Car a = new Car("Lexus","Sedan","White","Front Wheel",true,true,false,false,false,false,false,false,2);

    //Inventory car1 = new Inventory("Lexus","Sedan","White","Front Wheel",true,true,false,false,false,false,false,false,2);

}
