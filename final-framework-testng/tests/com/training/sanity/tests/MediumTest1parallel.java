package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MediumTest1parallel {

	private WebDriver driver;
	private String baseUrl;
	private MediumPOM1 medtest1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void extentreport()
	{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/MTC1.html",true);
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger = extent.startTest("MEDIUM TESTCASE1");
	}
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Parameters("mybrowser")
	@BeforeMethod
	public void setUp(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		baseUrl = properties.getProperty("baseURL");
		}
		
		medtest1 = new MediumPOM1(driver); 
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
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
	public void mediumtc1() throws InterruptedException {
		medtest1.sendUserName("admin");
		medtest1.sendPassword("admin@123");
		medtest1.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Logged in successfully");
		
		medtest1.clickOrders();
		logger.log(LogStatus.PASS, "Cart Links got displayed and clicked on Orders");
		
		medtest1.sendOrderId("267");
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt OrderId");
		
		medtest1.selOrdStatus();
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt OrderStatus");
		
		medtest1.sendAddDate("2019-06-19");
		Thread.sleep(1000);
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt Added Date");
		
		/*medtest1.clickCalendar();
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt Date added");*/
		
		medtest1.sendCustName("Neha");
		Thread.sleep(1000);
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt Customer Name");
		
		medtest1.sendTotal("0");
		Thread.sleep(1000);
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt Total");
		
		medtest1.sendModDate("2019-06-19");
		Thread.sleep(1000);
		medtest1.clickFilter();
		logger.log(LogStatus.PASS, "Filtered wrt Modified Date");
		
		
		screenShot.captureScreenShot("First");
		
		
	}
	

	
}
