package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ComplexPOM2;
import com.training.pom.MediumPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ComplexTest2 {

	private WebDriver driver;
	private WebDriver driver1;
	private String baseUrl1;
	private String baseUrl;
	private ComplexPOM2 complex2,complex2a;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void extentreport()
	{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/CTC2.html",true);
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger = extent.startTest("COMPLEX TESTCASE2");
	}
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		complex2 = new ComplexPOM2(driver); 
		
		baseUrl1 = properties.getProperty("baseURL1");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl1);
		logger.log(LogStatus.PASS, "Application opened");
		logger.log(LogStatus.PASS, driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		driver1.quit();
		logger.log(LogStatus.PASS, "Application closed");
		extent.endTest(logger);
		extent.flush();//flush all reports
		extent.close();
	}
	@Test
	public void complextc2() throws InterruptedException {	
		String Exp = "Success: You have added SPORTS T-SHIRTS to your shopping cart!";
		String Exp1 = "Your order has been successfully processed!";
		complex2.scroll();
		complex2.selectShirt();
		Assert.assertEquals(complex2.successftn(),Exp);
		complex2.clickItem();
		complex2.personal("PRINCE", "ISSAC", "princeissac@gmail.com", "8129766543");
		complex2.address("IBM", "Nagawara", "Bangalore", "560045");
		complex2.checkout();
		Assert.assertEquals(complex2.place_order(),Exp1);
		
		//String driver_handle = driver.getWindowHandle();
		Thread.sleep(1000);
	
		//new window
		
		driver1 = DriverFactory.getDriver(DriverNames.CHROME);
		complex2a = new ComplexPOM2(driver1);
		baseUrl = properties.getProperty("baseURL");
		driver1.get(baseUrl);
		
		//String driver1_handle = driver1.getWindowHandle();
		//driver.switchTo().window("CDwindow-C8196D2A45BE37BC1EC6DD1944BA0B99");
		complex2a.adminUserName("admin");
		complex2a.adminPassword("admin@123");
		complex2a.adminLoginBtn();
		complex2a.clickSales();
		complex2a.clickView();
		JavascriptExecutor jx = (JavascriptExecutor) driver1;
		jx.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		complex2a.changeStatus();
		
		Thread.sleep(2000);
		String Exp2 = "Success: You have modified orders!";
		Assert.assertEquals(complex2a.successftn1(),Exp2);
		
		
		//new tab
		((JavascriptExecutor)driver1).executeScript("window.open()"); 
		ArrayList<String> tabs = new ArrayList<String>(driver1.getWindowHandles());
	    driver1.switchTo().window(tabs.get(1));
	    driver1.get(baseUrl1);
	    Thread.sleep(1000);
	    complex2a.userLogin("princeissac@gmail.com","princeissac");
		
	}
	

	
}
