/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmi.calculator.interfaces;

import com.bmi.calculator.baseclasses.BMI_InputBase;
import com.bmi.calculator.baseclasses.BMI_OutputBase;
import java.util.ArrayList;

/**
 *
 * @author arjun
 */
public interface BMICalService {

    ArrayList<BMI_OutputBase> calBMI(ArrayList<BMI_InputBase> bmi);
}
