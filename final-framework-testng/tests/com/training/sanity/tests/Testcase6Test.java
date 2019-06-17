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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Testcase6POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Testcase6Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Testcase6POM testcase6;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent6;
	ExtentTest logger6;
	
	@BeforeTest
	public void extentreport2()
	{
	extent6 = new ExtentReports(System.getProperty("user.dir")+"/test-output/TC6.html",true);
	extent6.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger6 = extent6.startTest("TESTCASE6");
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
		testcase6 = new Testcase6POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger6.log(LogStatus.PASS, "Application opened");
		logger6.log(LogStatus.PASS, "Title of the page : " , driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		logger6.log(LogStatus.PASS, "Application closed");
		extent6.endTest(logger6);
		extent6.flush();//flush all reports
		extent6.close();
	}
	@Test
	public void uniformtc6() throws InterruptedException {
		testcase6.sendUserName("admin");
		testcase6.sendPassword("admin@123");
		testcase6.clickLoginBtn(); 
		logger6.log(LogStatus.PASS, "Logged in successfully");
		
		testcase6.clickCustBtn();
		logger6.log(LogStatus.PASS, "Clicked on Customers");
		
		testcase6.scrolldown();
		testcase6.checkCname();
		logger6.log(LogStatus.PASS, "Selected the customer to be deleted");
		testcase6.clickDelete();
		logger6.log(LogStatus.PASS, "Deleted the slected Customers");
		
	}
	

	
}
