package com.example.mycar;

public class CarInfo {
    private String brand;
    private String color;
    private String drivewheel;
    private String entsys;
    private String fee;
    private String gps;
    private String heated;
    private String jacuzzi;
    private String leather;
    private String minibar;
    private String qty;
    private String touchscreen;
    private String trailer;
    private String type;

    public CarInfo(){
    }

    public CarInfo(String brand, String color, String drivewheel, String entsys, String fee, String gps, String heated, String jacuzzi, String leather, String minibar, String qty, String touchscreen, String trailer, String type) {
        this.brand = brand;
        this.color = color;
        this.drivewheel = drivewheel;
        this.entsys = entsys;
        this.fee = fee;
        this.gps = gps;
        this.heated = heated;
        this.jacuzzi = jacuzzi;
        this.leather = leather;
        this.minibar = minibar;
        this.qty = qty;
        this.touchscreen = touchscreen;
        this.trailer = trailer;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDrivewheel() {
        return drivewheel;
    }

    public void setDrivewheel(String drivewheel) {
        this.drivewheel = drivewheel;
    }

    public String getEntsys() {
        return entsys;
    }

    public void setEntsys(String entsys) {
        this.entsys = entsys;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getHeated() {
        return heated;
    }

    public void setHeated(String heated) {
        this.heated = heated;
    }

    public String getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(String jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public String getLeather() {
        return leather;
    }

    public void setLeather(String leather) {
        this.leather = leather;
    }

    public String getMinibar() {
        return minibar;
    }

    public void setMinibar(String minibar) {
        this.minibar = minibar;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(String touchscreen) {
        this.touchscreen = touchscreen;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
