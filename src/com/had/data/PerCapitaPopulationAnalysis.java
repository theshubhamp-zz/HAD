package com.had.data;

/**
 * @author Akshat Shukla 
 * @since February 9, 2016
 */

public class PerCapitaPopulationAnalysis {
    String name;
    float percapitaYear2010_11;
    int populationYear2011;

    public Analysis1(String name, float percapitaYear2010_11, int populationYear2011) {
        this.name = name;
        this.percapitaYear2010_11 = percapitaYear2010_11;
        this.populationYear2011 = populationYear2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPerCapitaYear2010_11() {
        return percapitaYear2010_11;
    }

    public void setPerCapitaYear2010_11(float percapitaYear2010_11) {
        this.percapitaYear2010_11 = percapitaYear2010_11;
    }

    public int getPopulationYear2011() {
        return populationYear2011;
    }

    public void setPopulationYear2011(int populationYear2011) {
        this.populationYear2011 = populationYear2011;
    }
}
