package com.had.data;

/**
 * @author Akshat Shukla 
 * @since February 9, 2016
 */

public class GrossEnrollRatioLiteracyAnalysis {
    String name;
    float allTotal;
    float literacyRate2011;

    public GrossEnrollRatioLiteracyAnalysis(String name, float allTotal, float literacyRate2011) {
        this.name = name;
        this.allTotal = allTotal;
        this.literacyRate2011 = literacyRate2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(float allTotal) {
        this.allTotal = allTotal;
    }

    public float getLiteracyRate2011() {
        return literacyRate2011;
    }

    public void setLiteracyRate2011(float literacyRate2011) {
        this.literacyRate2011 = literacyRate2011;
    }
}
