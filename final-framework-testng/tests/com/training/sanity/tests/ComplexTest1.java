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
import com.training.pom.ComplexPOM1;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ComplexTest1 {

	private WebDriver driver;
	private String baseUrl;
	private ComplexPOM1 complex1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void extentreport()
	{
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/CTC1.html",true);
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger = extent.startTest("COMPLEX TESTCASE1");
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
		complex1 = new ComplexPOM1(driver); 
		baseUrl = properties.getProperty("baseURL");
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
		complex1.sendUserName("admin");
		complex1.sendPassword("admin@123");
		complex1.clickLoginBtn(); 
		logger.log(LogStatus.PASS, "Logged in successfully");
	
		complex1.clickProducts();
		logger.log(LogStatus.PASS, "Clicked on Products ");
		
		complex1.clickAddNew();
		logger.log(LogStatus.PASS, "Adding New Product");
		
		complex1.ProdDetails("Socks", "White Socks","SCK-014","200","20");
		logger.log(LogStatus.PASS, "Added product details and saved ");
		
		String Exp1 = "Success: You have modified products!";
		Assert.assertEquals(complex1.successftn(),Exp1);
	}
	

	
}
