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
import com.training.pom.Testcase5POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testcase5Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Testcase5POM testcase5;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent5;
	ExtentTest logger5;
	
	@BeforeTest
	public void extentreport2()
	{
	extent5 = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC5.html",true);
	extent5.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger5 = extent5.startTest("TESTCASE5");
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
		testcase5 = new Testcase5POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger5.log(LogStatus.PASS, "Application opened");
		logger5.log(LogStatus.PASS, driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger5.log(LogStatus.PASS, "Application closed");
		extent5.endTest(logger5);
		extent5.flush();//flush all reports
		extent5.close();
	}
	@Test
	public void uniformtc5() throws InterruptedException, AWTException {
		testcase5.sendUserName("admin");
		testcase5.sendPassword("admin@123");
		testcase5.clickLoginBtn(); 
		logger5.log(LogStatus.PASS, "Logged in successfully");
		
		screenShot.captureScreenShot("First");
		
		testcase5.clickCustBtn();
		logger5.log(LogStatus.PASS, "Clicked on Customers link in Customer");
		
		testcase5.enterName();
		logger5.log(LogStatus.PASS, "Entered name");
		
		testcase5.clickFilter();
		logger5.log(LogStatus.PASS, "Filtered according to name");
		
		testcase5.enterEmail();
		logger5.log(LogStatus.PASS, "Entered email");
		
		testcase5.clickFilter();
		logger5.log(LogStatus.PASS, "Filtered according to email");
		
		
		
	}
	

	
}
