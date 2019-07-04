package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ComplexPOM3;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ComplexTest3 {

	private WebDriver driver;
	private String baseUrl1;
	private ComplexPOM3 complex3;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void extentreport()
	{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/CTC3.html",true);
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger = extent.startTest("COMPLEX TESTCASE3");
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
		complex3 = new ComplexPOM3(driver); 
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl1);
		logger.log(LogStatus.PASS, "Application opened");
		logger.log(LogStatus.PASS, driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "Application closed");
		extent.endTest(logger);
		extent.flush();//flush all reports
		extent.close();
	}
	@Test
	public void mediumtc3() throws InterruptedException {
		
		complex3.userLogin();
		complex3.sendUserName("anandhu@gmail.com");
		complex3.sendPassword("anandhuudayan");
		complex3.clickLoginBtn();
		complex3.ordHistory();
		
		JavascriptExecutor jx = (JavascriptExecutor) driver;
		jx.executeScript("window.scrollTo(0, 400)");
		Thread.sleep(2000);
		
		complex3.ordReturn("Returning");
		
		//complex3.successftn();
		String Exp3 = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		Assert.assertEquals(complex3.successftn(),Exp3);
	}
	

	
}
