package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.ComplexDataProviders1;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.ComplexPOM1;
//import com.training.pom.complex;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexDBTest1 {
	private WebDriver driver;
	private String baseUrl;
	private ComplexPOM1 complex;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		complex = new ComplexPOM1(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = ComplexDataProviders1.class)
	public void complexDBTest(String userName, String password, String product, String title, int price, int quantity) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		String price1 = Integer.toString(price);
		String qty = Integer.toString(quantity);
		complex.sendUserName(userName); 	
		complex.sendPassword(password);
		complex.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		complex.clickProducts();
		complex.clickAddNew();
		complex.ProdDetails(product, title,"SCK-014",price1,qty);
		String Exp1 = "Success: You have modified products!";
		Assert.assertEquals(complex.successftn(),Exp1);
		
		

	}

}