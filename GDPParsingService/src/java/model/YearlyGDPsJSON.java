/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author starw
 */
public class YearlyGDPsJSON {
    
      private ArrayList<YearlyGDP> dataset;
    private int startYear;
    private int endYear;
    private double lowestGDP;
    private double highestGDP;

    public ArrayList<YearlyGDP> getDataset() {
        return dataset;
    }

    public void setDataset(ArrayList<YearlyGDP> dataset) {
        this.dataset = dataset;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public double getLowestGDP() {
        return lowestGDP;
    }

    public void setLowestGDP(double lowestGDP) {
        this.lowestGDP = lowestGDP;
    }

    public double getHighestGDP() {
        return highestGDP;
    }

    public void setHighestGDP(double highestGDP) {
        this.highestGDP = highestGDP;
    }
    
    
    
    
}
