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
import com.training.pom.Testcase3POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testcase3Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Testcase3POM testcase3;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent3;
	ExtentTest logger3;
	
	@BeforeTest
	public void extentreport2()
	{
	extent3 = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC3.html",true);
	extent3.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger3 = extent3.startTest("TESTCASE3");
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
		testcase3 = new Testcase3POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger3.log(LogStatus.PASS, "Application opened");
		logger3.log(LogStatus.PASS, "Title of the page : " , driver.getTitle());
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
	public void uniformtc3() throws InterruptedException, AWTException {
		testcase3.sendUserName("admin");
		testcase3.sendPassword("admin@123");
		testcase3.clickLoginBtn(); 
		logger3.log(LogStatus.PASS, "Logged in successfully");
		
		screenShot.captureScreenShot("First");
		
		testcase3.clickOrdBtn();
		logger3.log(LogStatus.PASS, "Clicked on Orders link in Sales Report --> Sales");
		
		testcase3.enterDate();
		logger3.log(LogStatus.PASS, "Entered start date and end date");
		
		testcase3.clickFilter();
		logger3.log(LogStatus.PASS, "Filtered according to selected date");
		testcase3.clkGrpBy();
		logger3.log(LogStatus.PASS, "Selected Group By category");
		testcase3.clkStatus();
		logger3.log(LogStatus.PASS, "Selected Order Status category");
		testcase3.clickFilter();
		logger3.log(LogStatus.PASS, "Filtered according to date,Group By and Order Status");
		
		
	}
	

	
}
