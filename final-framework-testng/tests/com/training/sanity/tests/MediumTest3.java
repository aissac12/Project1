package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MediumPOM3;
import com.training.pom.MediumPOM2;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MediumTest3 {

	private WebDriver driver;
	private String baseUrl;
	private MediumPOM3 medtest3;
	private MediumPOM2 medtest2;
	private MediumPOM1 medtest1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent3;
	ExtentTest logger3;

	@BeforeTest
	public void extentreport()
	{
	extent3 = new ExtentReports(System.getProperty("user.dir")+"/test-output/MTC3.html",true);
	extent3.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger3 = extent3.startTest("MEDIUM TESTCASE3");
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
		medtest3 = new MediumPOM3(driver); 
		medtest2 = new MediumPOM2(driver); 
		medtest1 = new MediumPOM1(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger3.log(LogStatus.PASS, "Application opened");
		logger3.log(LogStatus.PASS, driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger3.log(LogStatus.PASS, "Application closed");
		extent3.endTest(logger3);
		extent3.flush();//flush all reports
		extent3.close();
	}
	@Test
	public void mediumtc3() throws InterruptedException {
		medtest1.sendUserName("admin");
		medtest1.sendPassword("admin@123");
		medtest1.clickLoginBtn(); 
		logger3.log(LogStatus.PASS, "Logged in successfully");
		
		medtest3.clickCart();
		logger3.log(LogStatus.PASS, "Clicked on Returns");
		
		medtest2.clickAddNew();
		logger3.log(LogStatus.PASS, "Added New Return Product");
		medtest3.ReturnDetails("25","Sarah","Renu","mathur","renu.mathur@gmail.com","9453234554"," Blazer Girls","BLG-112");
		medtest3.Delete();
		logger3.log(LogStatus.PASS, "Deleted the Return Product");
		
	
		
		
		screenShot.captureScreenShot("First");
		
		
	}
	

	
}
