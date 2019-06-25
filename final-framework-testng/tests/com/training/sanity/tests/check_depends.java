package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Testcase1POM;
import com.training.pom.check_dependsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class check_depends {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private check_dependsPOM testcase1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void extentreport()
	{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC1.html",true);
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger = extent.startTest("TESTCASE1");
	}
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		testcase1 = new check_dependsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger.log(LogStatus.PASS, "Application opened");
		logger.log(LogStatus.PASS, driver.getTitle());
	}

	
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger.log(LogStatus.PASS, "Application closed");
		extent.endTest(logger);
		extent.flush();//flush all reports
		extent.close();
	}
	@Test
	public void uniformtc1() throws InterruptedException {
		testcase1.sendUserName("admin");
		testcase1.sendPassword("admin@123");
		testcase1.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Logged in successfully");
		
	}
	
	@Test(dependsOnMethods= {"uniformtc1"})
	public void uniformtc11() throws InterruptedException {
		testcase1.clickProduct();
		logger.log(LogStatus.PASS, "Links got displayed and clicked on Product");
		
	}
	
	@Test(dependsOnMethods= {"uniformtc11"})
	public void uniformtc12() throws InterruptedException {
		
		testcase1.sendProductName("Blazer-Boys");
		
	}

	@Test(dependsOnMethods= {"uniformtc12"},alwaysRun=true)
	public void uniformtc13() throws InterruptedException {
		
		testcase1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered products according to Product Name ");
		screenShot.captureScreenShot("First");
	}
}
