/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmi.calculator.Util;

import com.bmi.calculator.interfaces.BMIConstants;
import java.util.HashMap;

/**
 *
 * @author arjun
 */
public class Utility implements BMIConstants{
    public static HashMap<Integer,String[]> categories;

    static {
        if(categories==null){
            categories = new HashMap<>();
            categories.put(CATEGORY_UNDERWEIGHT,new String[]{"Underweight","Malnutrition risk"});
            categories.put(CATEGORY_NORMAL,new String[]{"Normal weight","Low risk"});
            categories.put(CATEGORY_OVERWEIGHT,new String[]{"Overweight","Enhanced risk"});
            categories.put(CATEGORY_MODOBESE,new String[]{"Moderately obese","Medium risk"});
            categories.put(CATEGORY_SEVOBESE,new String[]{"Severely obese","High risk"});
            categories.put(CATEGORY_VERYSEVOBESE,new String[]{"Very severely obese","Very high risk"});            
        }
    }
}
