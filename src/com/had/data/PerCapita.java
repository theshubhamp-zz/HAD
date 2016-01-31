package com.had.data;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */

public class PerCapita
{
    String stateName;
    int percapitaYear2009_10;
    int percapitaYear2010_11;
    
    public PerCapita(String stateName,float percapitaYear2009_10,float percapitaYear2010_11)
    {
        this.stateName = stateName;
        this.percapitaYear2009_10 = percapitaYear2009_10;
        this.percapitaYear2010_11 = percapitaYear2010_11;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public int getPerCapitaYear2009_10() {
        return percapitaYear2009_10;
    }
    
    public void setPerCapitaYear2009_10(float percapitaYear2009_10) {
        this.percapitaYear2009_10 = percapitaYear2009_10;
    }
    
    public int getPerCapitaYear2010_11() {
        return percapitaYear2010_11;
    }
    
    public void setPerCapitaYear2010_11(float percapitaYear2010_11) {
        this.percapitaYear2010_11 = percapitaYear2010_11;
    }
}
