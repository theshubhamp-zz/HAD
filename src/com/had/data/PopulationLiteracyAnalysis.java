package com.had.data;

/**
 * @author Akshat Shukla 
 * @since February 9, 2016
 */

public class PopulationLiteracyAnalysis {
    String name;
    String col;
    int value;

    public PopulationLiteracyAnalysis(String name, String col, int value) {
        this.name = name;
        this.col = col;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
