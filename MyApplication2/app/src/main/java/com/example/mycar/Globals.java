package com.example.mycar;

public class Globals {

    boolean populated;

    {
        populated = false;
    }


    public void setPopulated(boolean value) {
        populated = value;
    }

    public boolean getPopulated() {
        return populated;
    }

}
