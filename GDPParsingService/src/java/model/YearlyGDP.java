/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author starw
 */
public class YearlyGDP {
    private int date;
    private double value;
 

    public YearlyGDP(int date, double value) {
        this.date = date;
        this.value = value;
        
    }



    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
    
    
}
