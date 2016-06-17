package com.had.data;

/**
 * @author Shubham S Patil
 * @since January 29, 2016
 */

public class LiteracyRate {
    String name;
    float literacyRate2001;
    float literacyRate2011;

    public LiteracyRate(String name, float literacyRate2001, float literacyRate2011) {
        this.name = name;
        this.literacyRate2001 = literacyRate2001;
        this.literacyRate2011 = literacyRate2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLiteracyRate2001() {
        return literacyRate2001;
    }

    public void setLiteracyRate2001(float literacyRate2001) {
        this.literacyRate2001 = literacyRate2001;
    }

    public float getLiteracyRate2011() {
        return literacyRate2011;
    }

    public void setLiteracyRate2011(float literacyRate2011) {
        this.literacyRate2011 = literacyRate2011;
    }
}
