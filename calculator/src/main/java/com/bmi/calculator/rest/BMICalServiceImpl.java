/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmi.calculator.rest;

import com.bmi.calculator.Util.Utility;
import com.bmi.calculator.baseclasses.BMI_InputBase;
import com.bmi.calculator.baseclasses.BMI_OutputBase;
import com.bmi.calculator.interfaces.BMICalService;
import com.bmi.calculator.interfaces.BMIConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arjun
 */
@Service
public class BMICalServiceImpl implements BMICalService, BMIConstants {

    HashMap<Integer, String[]> categoryMap = Utility.categories;

    @Autowired
    HttpServletRequest request;

    @Override
    public ArrayList<BMI_OutputBase> calBMI(ArrayList<BMI_InputBase> bmi) {
        ArrayList<BMI_OutputBase> out = new ArrayList<>();
        HashMap<Integer, Integer> data = (HashMap<Integer, Integer>) request.getSession(false).getAttribute("data");
        BMI_OutputBase out_base = null;
        double weight, height, bmi_index;
        for (BMI_InputBase input : bmi) {
            out_base = new BMI_OutputBase();
            weight = (double) input.getWeightKg();
            height = (double) input.getHeightCm();
            bmi_index = (weight * 100 * 100) / (height * height);
            out_base.setBmi(new BigDecimal(bmi_index).setScale(2, RoundingMode.HALF_UP).doubleValue());
            setCategory(out_base, data);
            out.add(out_base);
        }
        return out;
    }

    public void setCategory(BMI_OutputBase out_base, HashMap<Integer, Integer> data) {
        double bmi_index = out_base.getBmi();
        if (bmi_index <= 18.4) {
            out_base.setCategory_code(CATEGORY_UNDERWEIGHT);
            out_base.setCategory(categoryMap.get(CATEGORY_UNDERWEIGHT)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_UNDERWEIGHT)[1]);
        } else if (bmi_index > 18.4 && bmi_index <= 24.9) {
            out_base.setCategory_code(CATEGORY_NORMAL);
            out_base.setCategory(categoryMap.get(CATEGORY_NORMAL)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_NORMAL)[1]);
        } else if (bmi_index > 24.9 && bmi_index <= 29.9) {
            out_base.setCategory_code(CATEGORY_OVERWEIGHT);
            out_base.setCategory(categoryMap.get(CATEGORY_OVERWEIGHT)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_OVERWEIGHT)[1]);
        } else if (bmi_index > 29.9 && bmi_index <= 34.9) {
            out_base.setCategory(categoryMap.get(CATEGORY_MODOBESE)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_MODOBESE)[1]);
            out_base.setCategory_code(CATEGORY_MODOBESE);
        } else if (bmi_index > 34.9 && bmi_index <= 39.9) {
            out_base.setCategory_code(CATEGORY_SEVOBESE);
            out_base.setCategory(categoryMap.get(CATEGORY_SEVOBESE)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_SEVOBESE)[1]);
        } else if (bmi_index > 39.9) {
            out_base.setCategory_code(CATEGORY_VERYSEVOBESE);
            out_base.setCategory(categoryMap.get(CATEGORY_VERYSEVOBESE)[0]);
            out_base.setRisk(categoryMap.get(CATEGORY_VERYSEVOBESE)[1]);
        }
        if (data != null) {
            data.put(out_base.getCategory_code(), data.getOrDefault(out_base.getCategory_code(), 0) + 1);
        }

    }
}
