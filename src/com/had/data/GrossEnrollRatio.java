package com.had.data;

/**
 * @author Akshat Shukla
 * @since February 1, 2016
 */

public class GrossEnrollRatio
{
    String stateName;
    float allMale;
    float allFemale;
    float allTotal;
    float scMale;
    float scFemale;
    float scTotal;
    float stMale;
    float stFemale;
    float stTotal;
    
    
    public GrossEnrollRatio(String stateName,float allMale, float allFemale,float allTotal,float scMale,float scFemale,float scTotal,float stMale,float stFemale,float stTotal)
    {
        this.stateName = stateName;
        this.allMale = allMale;
        this.allFemale = allFemale;
        this.allTotal = allTotal;
        this.scMale = scMale;
        this.scFemale = scFemale;
        this.scTotal = scTotal;
        this.stMale = stMale;
        this.stFemale = stFemale;
        this.stTotal = stTotal;
    }
    
    public String getStateName() {
        return stateName;
    }
    
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public float getAllMale() {
        return allMale;
    }
    
    public void setAllMale(float allMale) {
        this.allMale = allMale;
    }
    
    public float getAllFemale() {
        return allFemale;
    }
    
    public void setAllFemale(float allFemale) {
        this.allFemale = allFemale;
    }
    
    public float getAllTotal() {
        return allTotal;
    }
    
    public void setAllTotal(float allTotal) {
        this.allTotal = allTotal;
    }
    
    public float getSCMale() {
        return scMale;
    }
    
    public void setSCMale(float scMale) {
        this.scMale = scMale;
    }
    
    public float getSCFemale() {
        return scFemale;
    }
    
    public void setSCFemale(float scFemale) {
        this.scFemale = scFemale;
    }
    
    public float getSCTotal() {
        return scTotal;
    }
    
    public void setSCTotal(float scTotal) {
        this.scTotal = scTotal;
    }
    
    public float getSTMale() {
        return stMale;
    }
    
    public void setSTMale(float stMale) {
        this.stMale = stFemale;
    }
    
    public float getSTFemale() {
        return stFemale;
    }
    
    public void setSTFemale(float stFemale) {
        this.stFemale = stFemale;
    }
    
    public float getSTTotal() {
        return stTotal;
    }
    
    public void setSTTotal(float stTotal) {
        this.stTotal = stTotal;
    }
}
