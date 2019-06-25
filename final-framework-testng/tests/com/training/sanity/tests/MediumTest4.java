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
import com.training.pom.MediumPOM4;
import com.training.pom.MediumPOM2;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MediumTest4 {

	private WebDriver driver;
	private String baseUrl;
	private MediumPOM4 medtest4;
	private MediumPOM1 medtest1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent4;
	ExtentTest logger4;

	@BeforeTest
	public void extentreport()
	{
	extent4 = new ExtentReports(System.getProperty("user.dir")+"/test-output/MTC4.html",true);
	extent4.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger4 = extent4.startTest("MEDIUM TESTCASE4");
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
		medtest4 = new MediumPOM4(driver); 
		medtest1 = new MediumPOM1(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger4.log(LogStatus.PASS, "Application opened");
		logger4.log(LogStatus.PASS, driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger4.log(LogStatus.PASS, "Application closed");
		extent4.endTest(logger4);
		extent4.flush();//flush all reports
		extent4.close();
	}
	@Test
	public void mediumtc4() throws InterruptedException {
		medtest1.sendUserName("admin");
		medtest1.sendPassword("admin@123");
		medtest1.clickLoginBtn(); 
		logger4.log(LogStatus.PASS, "Logged in successfully");
		medtest4.clickCustomer();
		logger4.log(LogStatus.PASS, "Clicked on Customer");
		medtest4.Editting("Chitra","560097","bonus","20");
		logger4.log(LogStatus.PASS, "Editted customer details and saved");

		screenShot.captureScreenShot("First");
		
		
	}
	

	
}
