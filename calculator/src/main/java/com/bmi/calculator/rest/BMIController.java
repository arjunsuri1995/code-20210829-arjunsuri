/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmi.calculator.rest;

import com.bmi.calculator.baseclasses.BMI_InputBase;
import com.bmi.calculator.baseclasses.BMI_OutputBase;
import com.bmi.calculator.interfaces.BMICalService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bmi.calculator.interfaces.BMIService;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author arjun
 */
@RestController
public class BMIController implements BMIService {

    @Autowired
    private BMICalService calService;

    @Autowired
    HttpServletRequest request;

    @Override
    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public ArrayList<BMI_OutputBase> calculateBMI(@RequestBody ArrayList<BMI_InputBase> bmi) {
        HttpSession session = request.getSession(true);
        HashMap<Integer, Integer> hm = (HashMap) session.getAttribute("data");
        if (hm == null) {
            hm = new HashMap<>();
            session.setAttribute("data", hm);
        }
        return calService.calBMI(bmi);
    }

    @Override
    @RequestMapping(value = "/bmi/{code}", method = RequestMethod.POST)
    public int getCount(@PathVariable int code) {
        try {
            HashMap<Integer, Integer> hm = (HashMap) request.getSession(false).getAttribute("data");
            if (hm != null) {
                return (hm.get(code) != null) ? (int) hm.get(code) : 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
