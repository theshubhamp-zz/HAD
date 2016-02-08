package com.had.data;

/**
 * @author Akshat Shukla 
 * @since February 8, 2016
 */

public class Analysis1 {
    String name;
    float literacyRate2011;
    int populationYear2011;

    public Analysis1(String name, float literacyRate2011, int populationYear2011) {
        this.name = name;
        this.literacyRate2011 = literacyRate2011;
        this.populationYear2011 = populationYear2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLiteracyRate2011() {
        return literacyRate2011;
    }

    public void setLiteracyRate2011(float literacyRate2011) {
        this.literacyRate2011 = literacyRate2011;
    }

    public int getPopulationYear2011() {
        return populationYear2011;
    }

    public void setPopulationYear2011(int populationYear2011) {
        this.populationYear2011 = populationYear2011;
    }
}
