package com.example.myapplication2;

import java.io.Serializable;

public class Car implements Serializable {

    private String brand;
    private String type;
    private String color;
    private String drivewheel;
    private Boolean touchscreen;
    private Boolean gps;
    private Boolean entsys;
    private Boolean trailer;
    private Boolean leather;
    private Boolean heated;
    private Boolean minibar;
    private Boolean jacuzzi;
    private int qty = 0;

    //public car () {
    //    this("Unknown","Unknown","Unknown","Unknown",false,false,false,false,false,false,false,false,0);
    //}

    public Car (String brand, String type, String color, String drivewheel, Boolean touchscreen, Boolean gps, Boolean entsys,
                Boolean trailer, Boolean leather, Boolean heated, Boolean minibar, Boolean jacuzzi, int qty) {

        this.brand = brand;
        this.type = type;
        this.color = color;
        this.drivewheel = drivewheel;
        this.touchscreen = touchscreen;
        this.gps = gps;
        this.entsys = entsys;
        this.trailer = trailer;
        this.leather = leather;
        this.heated = heated;
        this.minibar = minibar;
        this.jacuzzi = jacuzzi;
        this.qty = qty;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getDrivewheel() {
        return this.drivewheel;
    }

    public Boolean getTouchscreen() { return this.touchscreen; }

    public Boolean getGPS() { return this.gps; }

    public Boolean getEntsys() { return this.entsys; }

    public Boolean getTrailer() { return this.trailer; }

    public Boolean getLeather() { return this.leather; }

    public Boolean getHeated() { return this.heated; }

    public Boolean getMinibar() { return this.minibar; }

    public Boolean getJacuzzi() { return this.jacuzzi; }

    public int getQty() {
        return this.qty;
    }

    public void add() {
        this.qty++;
    }

    public void remove() {
        if (getQty() == 0) this.qty = 0;
        else this.qty--;
    }
}
