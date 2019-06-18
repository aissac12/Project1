package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
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
import com.training.pom.Testcase2POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testcase2Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Testcase2POM testcase2;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent2;
	ExtentTest logger2;
	
	@BeforeTest
	public void extentreport2()
	{
	extent2 = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC2.html",true);
	extent2.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger2 = extent2.startTest("TESTCASE2");
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
		testcase2 = new Testcase2POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger2.log(LogStatus.PASS, "Application opened");
		logger2.log(LogStatus.PASS, "Title of the page : " , driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger2.log(LogStatus.PASS, "Application closed");
		extent2.endTest(logger2);
		extent2.flush();
		extent2.close();
	}
	@Test
	public void uniformtc2() throws InterruptedException {
		testcase2.sendUserName("admin");
		testcase2.sendPassword("admin@123");
		testcase2.clickLoginBtn(); 
		logger2.log(LogStatus.PASS, "Logged in successfully");
		testcase2.clickCatlogbutton();
		logger2.log(LogStatus.PASS, "Clicked on Products");
		testcase2.checkPname();
		logger2.log(LogStatus.PASS, "Selected the Product");
		testcase2.clickDelete();
		logger2.log(LogStatus.PASS, "Deleted the product");
		
		screenShot.captureScreenShot("First");
		
	}
	

	
}
