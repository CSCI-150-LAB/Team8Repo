package com.example.mycar;

import java.util.ArrayList;

public class Indextracker {

    ArrayList<Integer> indextrack = new ArrayList<Integer>();

    public void addIndex(int value) {
        indextrack.add(value);
    }

    public ArrayList<Integer> exportIndex() {
        return indextrack;
    }

}
