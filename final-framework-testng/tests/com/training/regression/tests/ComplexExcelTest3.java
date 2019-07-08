package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.training.bean.LoginBean;
//import com.training.dao.ELearningDAO;
import com.training.dataproviders.ComplexDataProviders3;
//import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ComplexPOM3;
//import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexExcelTest3 {
	private WebDriver driver;
	private String baseUrl1;
	private ComplexPOM3 complexPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		complexPOM = new ComplexPOM3(driver);
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl1);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = ComplexDataProviders3.class)
	public void ExcelTest(String userName, String password,String inp,String open, String comment) throws InterruptedException {
		//String inp1 = Integer.toString(inp);
		String x=inp.replace(".0", "");		//to pass as integers to select the radio button for reason
		String y=open.replace(".0", "");
		//System.out.println(x);
		//System.out.println(inp);
		complexPOM.userLogin();
		complexPOM.sendUserName(userName);
		complexPOM.sendPassword(password);
		complexPOM.clickLoginBtn();
		complexPOM.ordHistory();
		
		JavascriptExecutor jx = (JavascriptExecutor) driver;
		jx.executeScript("window.scrollTo(0, 400)");
		Thread.sleep(2000);
		
		complexPOM.ordReturn(comment,x,y);
		
		String Exp3a = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		String Exp3b = "You will be notified via e-mail as to the status of your request.";
		String Exp3 = Exp3a+Exp3b;
		
		Assert.assertEquals(complexPOM.successftn(),Exp3);
		screenShot.captureScreenShot(userName);
		

	}

}