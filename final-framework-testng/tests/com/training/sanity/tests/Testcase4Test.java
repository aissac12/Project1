package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Testcase4POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testcase4Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Testcase4POM testcase4;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent4;
	ExtentTest logger4;
	
	@BeforeTest
	public void extentreport2()
	{
	extent4 = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC4.html",true);
	extent4.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger4 = extent4.startTest("TESTCASE4");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		//driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		testcase4 = new Testcase4POM(driver); 
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
		extent4.flush();
		extent4.close();
	}
	@Test
	public void uniformtc4() throws InterruptedException, AWTException {
		testcase4.sendUserName("admin");
		testcase4.sendPassword("admin@123");
		testcase4.clickLoginBtn(); 
		logger4.log(LogStatus.PASS, "Logged in successfully");
		
		screenShot.captureScreenShot("First");
		
		testcase4.clickTaxBtn();
		logger4.log(LogStatus.PASS, "Clicked on Tax link in Sales Report --> Sales");
		
		testcase4.clkGrpBy();
		logger4.log(LogStatus.PASS, "Selected Group By category");
		
		testcase4.clickFilter();
		logger4.log(LogStatus.PASS, "Filtered according to Group");
		
	}
}
		
		