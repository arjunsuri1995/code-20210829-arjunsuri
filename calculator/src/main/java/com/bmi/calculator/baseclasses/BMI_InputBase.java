/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmi.calculator.baseclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author arjun
 */
public class BMI_InputBase {
    @JsonProperty("Gender")
    private String Gender = "";
    
    @JsonProperty("HeightCm")
    private int HeightCm;
    
    @JsonProperty("WeightKg")
    private int WeightKg;  

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getHeightCm() {
        return HeightCm;
    }

    public void setHeightCm(int HeightCm) {
        this.HeightCm = HeightCm;
    }

    public int getWeightKg() {
        return WeightKg;
    }

    public void setWeightKg(int WeightKg) {
        this.WeightKg = WeightKg;
    }
    
    
}
