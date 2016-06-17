package com.had.data;

/**
 * @author Shubham S Patil
 * @since January 16, 2016
 */
public class Population
{
    String name;
    int populationYear2011;
    int populationYear2001;

    public Population(String name, int populationYear2001, int populationYear2011) {
        this.name = name;
        this.populationYear2001 = populationYear2001;
        this.populationYear2011 = populationYear2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationYear2011() {
        return populationYear2011;
    }

    public void setPopulationYear2011(int populationYear2011) {
        this.populationYear2011 = populationYear2011;
    }

    public int getPopulationYear2001() {
        return populationYear2001;
    }

    public void setPopulationYear2001(int populationYear2001) {
        this.populationYear2001 = populationYear2001;
    }
}
