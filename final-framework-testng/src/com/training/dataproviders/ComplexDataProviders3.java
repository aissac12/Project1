package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;
import com.training.readexcel.ApachePOIExcelRead;


public class ComplexDataProviders3 {

	
	@DataProvider(name = "excel-inputs")		//apache poi
	public Object[][] getExcelData(){
		String fileName ="C:/Users/AncyIssac/Desktop/java_elcipse/selenium/TestData_3.xlsx"; 
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
}
