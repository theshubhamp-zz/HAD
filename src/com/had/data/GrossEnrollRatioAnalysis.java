package com.had.data;

/**
 * @author Akshat Shukla 
 * @since February 9, 2016
 */

public class GrossEnrollRatioAnalysis {
    String name;
    String col;
    float value;

    public GrossEnrollRatioAnalysis(String name, String col, float value) {
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
