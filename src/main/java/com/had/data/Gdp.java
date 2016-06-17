package com.had.data;

/**
 * @author Shubham S Patil
 * @since January 31, 2016
 */

public class Gdp {
    String name;
    float gdpYear2008_09;
    float gdpYear2009_10;
    float gdpYear2010_11;

    public Gdp(String name, float gdpYear2008_09, float gdpYear2009_10, float gdpYear2010_11) {
        this.name = name;
        this.gdpYear2008_09 = gdpYear2008_09;
        this.gdpYear2009_10 = gdpYear2009_10;
        this.gdpYear2010_11 = gdpYear2010_11;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGdpYear2010_11() {
        return gdpYear2010_11;
    }

    public void setGdpYear2010_11(float gdpYear2010_11) {
        this.gdpYear2010_11 = gdpYear2010_11;
    }

    public float getGdpYear2009_10() {
        return gdpYear2009_10;
    }

    public void setGdpYear2009_10(float gdpYear2009_10) {
        this.gdpYear2009_10 = gdpYear2009_10;
    }

    public float getGdpYear2008_09() {
        return gdpYear2008_09;
    }

    public void setGdpYear2008_09(float gdpYear2008_09) {
        this.gdpYear2008_09 = gdpYear2008_09;
    }
}
