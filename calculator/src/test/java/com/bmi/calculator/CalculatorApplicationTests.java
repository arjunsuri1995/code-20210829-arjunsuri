package com.bmi.calculator;

import com.bmi.calculator.rest.BMICalServiceImpl;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void contextLoads() {
	}
        
        @Test
        public void bmiCalTest() throws Exception {
            BMICalServiceImpl servImpl = new BMICalServiceImpl();
            
            try{
                
            } catch(IllegalArgumentException e){
               Assert.assertEquals(true, false); 
            }
        }

}
