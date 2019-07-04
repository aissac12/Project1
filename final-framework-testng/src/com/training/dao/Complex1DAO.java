package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.ComplexBean1;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class Complex1DAO {
	
	Properties properties; 
	
	public Complex1DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ComplexBean1> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<ComplexBean1> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<ComplexBean1>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				ComplexBean1 temp = new ComplexBean1(); 
				temp.setUserName(gc.rs1.getString(1));		//first col-admin/ancy
				temp.setPassword(gc.rs1.getString(2));		//second col- admin@123/sarah
				temp.setProduct(gc.rs1.getString(3));
				temp.setTitle(gc.rs1.getString(4));
				temp.setPrice(gc.rs1.getInt(5));
				temp.setQuantity(gc.rs1.getInt(6));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new Complex1DAO().getLogins().forEach(System.out :: println);
	}
	
	
}
