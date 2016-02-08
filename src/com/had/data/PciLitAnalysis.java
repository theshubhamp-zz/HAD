package com.had.data;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class PciLitAnalysis {
    String name;
    float PCI_2010_11;
    float LIT_2011;

    public PciLitAnalysis(String name, float PCI_2010_11, float LIT_2011) {
        this.name = name;
        this.PCI_2010_11 = PCI_2010_11;
        this.LIT_2011 = LIT_2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPCI_2010_11() {
        return PCI_2010_11;
    }

    public void setPCI_2010_11(float PCI_2010_11) {
        this.PCI_2010_11 = PCI_2010_11;
    }

    public float getLIT_2011() {
        return LIT_2011;
    }

    public void setLIT_2011(float LIT_2011) {
        this.LIT_2011 = LIT_2011;
    }
}
