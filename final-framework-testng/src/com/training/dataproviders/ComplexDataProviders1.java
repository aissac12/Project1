package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ComplexBean1;
import com.training.dao.Complex1DAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class ComplexDataProviders1 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ComplexBean1> list = new Complex1DAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ComplexBean1 temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getProduct();
			obj[3] = temp.getTitle();
			obj[4] = temp.getPrice();
			obj[5] = temp.getQuantity();
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")		//apache poi
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")		//jxl
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
