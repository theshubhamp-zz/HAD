package com.had.data;

/**
 * @author Akshat Shukla
 * @since February 2, 2016
 */

public class Household
{
    String name;
    int urt_id;
    float HHSIZE_1;
    float HHSIZE_2;
    float HHSIZE_3;
    float HHSIZE_4;
    float HHSIZE_5;
    float HHSIZE_6;
    float HHSIZE_7_10;
    float HHSIZE_11_14;
    float HHSIZE_15_MORE;
    float MEAN_HHSIZE;
    
    
    public Household(String name,int urt_id, float HHSIZE_1,float HHSIZE_2,float HHSIZE_3,float HHSIZE_4,float HHSIZE_5,float HHSIZE_6,float HHSIZE_7_10,float HHSIZE_11_14,float HHSIZE_15_MORE,float MEAN_HHSIZE)
    {
        this.name = name;
        this.urt_id = urt_id;
        this.HHSIZE_1 = HHSIZE_1;
        this.HHSIZE_2 = HHSIZE_2;
        this.HHSIZE_3 = HHSIZE_3;
        this.HHSIZE_4 = HHSIZE_4;
        this.HHSIZE_5 = HHSIZE_5;
        this.HHSIZE_6 = HHSIZE_6;
        this.HHSIZE_7_10 = HHSIZE_7_10;
        this.HHSIZE_11_14 = HHSIZE_11_14;
        this.HHSIZE_15_MORE = HHSIZE_15_MORE;
        this.MEAN_HHSIZE = MEAN_HHSIZE;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float geturt_id() {
        return urt_id;
    }
    
    public void seturt_id(int urt_id) {
        this.urt_id = urt_id;
    }
    
    public float getHHSIZE_1() {
        return HHSIZE_1;
    }
    
    public void setHHSIZE_1(float HHSIZE_1) {
        this.HHSIZE_1 = HHSIZE_1;
    }
    
    public float getHHSIZE_2() {
        return HHSIZE_2;
    }
    
    public void setHHSIZE_2(float HHSIZE_2) {
        this.HHSIZE_2 = HHSIZE_2;
    }
    
    public float getHHSIZE_3() {
        return HHSIZE_3;
    }
    
    public void setHHSIZE_3(float HHSIZE_3) {
        this.HHSIZE_3 = HHSIZE_3;
    }
    
    public float getHHSIZE_4() {
        return HHSIZE_4;
    }
    
    public void setHHSIZE_4(float HHSIZE_4) {
        this.HHSIZE_4 = HHSIZE_4;
    }
    
    public float getHHSIZE_5() {
        return HHSIZE_5;
    }
    
    public void setHHSIZE_5(float HHSIZE_5) {
        this.HHSIZE_5 = HHSIZE_5;
    }
    
    public float getHHSIZE_6() {
        return HHSIZE_6;
    }
    
    public void setHHSIZE_6(float HHSIZE_6) {
        this.HHSIZE_6 = HHSIZE_6;
    }
    
    public float getHHSIZE_7_10() {
        return HHSIZE_7_10;
    }
    
    public void setHHSIZE_7_10(float HHSIZE_7_10) {
        this.HHSIZE_7_10 = HHSIZE_7_10;
    }
    
    public float getHHSIZE_11_14() {
        return HHSIZE_11_14;
    }
    
    public void setHHSIZE_11_14(float HHSIZE_11_14) {
        this.HHSIZE_11_14 = HHSIZE_11_14;
    }
    
    public float getHHSIZE_15_MORE() {
        return HHSIZE_15_MORE;
    }
    
    public void setHHSIZE_15_MORE(float HHSIZE_15_MORE) {
        this.HHSIZE_15_MORE = HHSIZE_15_MORE;
    }
    
    public float getMEAN_HHSIZE() {
        return MEAN_HHSIZE;
    }
    
    public void setMEAN_HHSIZE(float MEAN_HHSIZE) {
        this.MEAN_HHSIZE = MEAN_HHSIZE;
    }
    
}
