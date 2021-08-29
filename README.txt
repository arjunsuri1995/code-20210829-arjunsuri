SpringBoot based BMI Calculator
*******************************
A web based application which needs to be deployed on server.
Two rest APIs have been exposed:
1. To calculate BMI:
	- REST EndPoint: /bmi
	- Input: Array of Objects to be sent in request body using POST method
	e.g. 	
	[{
		"Gender": "Male",
		"HeightCm": 150,
		"WeightKg": 70
	},
	{
		"Gender": "Female",
		"HeightCm": 167,
		"WeightKg": 82
	}]
	- Output: Array of calculated result consisting of bmi, bmi_category and health_risk parameters for each input
	e.g. 
	[{
        "BMI": 24.49,
        "BMI_Category": "Normal weight",
        "Health_Risk": "Low risk"
    },
    {
        "BMI": 32.79,
        "BMI_Category": "Moderately obese",
        "Health_Risk": "Medium risk"
    }]
	
2. To get the count:
	- REST EndPoint: /bmi/{code}
	- Input: code parameter from below possible variations to be sent as path parameter
		- CATEGORY_UNDERWEIGHT = 1;
		- CATEGORY_NORMAL = 2;
		- CATEGORY_OVERWEIGHT = 3;
		- CATEGORY_MODOBESE = 4;
		- CATEGORY_SEVOBESE = 5;
		- CATEGORY_VERYSEVOBESE = 6;
		e.g. to get count of overweight persons endpoint will be /bmi/3
	- Output: integer represnting count of asked variation
	
Note: Since no information has been provided for where to retain the data. For simplicity, data has been retained in session. So, to get the count it is required to call the /bmi API.


Code can be obtained from below github URL:
https://github.com/arjunsuri1995/code-20210829-arjunsuri