package com.had.data;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class GdpPciAnalysis {
    String name;
    int GDP_2010_11;
    int PCI_2010_11;

    public GdpPciAnalysis(String name, int GDP_2010_11, int PCI_2010_11) {
        this.name = name;
        this.GDP_2010_11 = GDP_2010_11;
        this.PCI_2010_11 = PCI_2010_11;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGDP_2010_11() {
        return GDP_2010_11;
    }

    public void setGDP_2010_11(int GDP_2010_11) {
        this.GDP_2010_11 = GDP_2010_11;
    }

    public int getPCI_2010_11() {
        return PCI_2010_11;
    }

    public void setPCI_2010_11(int PCI_2010_11) {
        this.PCI_2010_11 = PCI_2010_11;
    }
}
