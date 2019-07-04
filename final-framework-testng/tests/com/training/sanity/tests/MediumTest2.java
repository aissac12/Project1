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
import com.training.pom.MediumPOM2;
import com.training.pom.MediumPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MediumTest2 {

	private WebDriver driver;
	private String baseUrl;
	private MediumPOM2 medtest2;
	private MediumPOM1 medtest1;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent2;
	ExtentTest logger2;

	@BeforeTest
	public void extentreport()
	{
	extent2 = new ExtentReports(System.getProperty("user.dir")+"/test-output/MTC2.html",true);
	extent2.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	logger2 = extent2.startTest("MEDIUM TESTCASE2");
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
		medtest2 = new MediumPOM2(driver); 
		medtest1 = new MediumPOM1(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		logger2.log(LogStatus.PASS, "Application opened");
		logger2.log(LogStatus.PASS, driver.getTitle());
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
	public void mediumtc2() throws InterruptedException {
		medtest1.sendUserName("admin");
		medtest1.sendPassword("admin@123");
		medtest1.clickLoginBtn(); 
		logger2.log(LogStatus.PASS, "Logged in successfully");
		
		medtest2.clickCategories();
		logger2.log(LogStatus.PASS, "Clicked on Categories");
		
		medtest2.clickAddNew();
		logger2.log(LogStatus.PASS, "Adding New Category");
		
		medtest2.CatDetails("Sports Uniform","Uniform for Sports","Sports Uniform","Uniform for Sports");
		logger2.log(LogStatus.PASS, "Added category details and saved ");
		
		String Exp = "Success: You have modified categories!";
		Assert.assertEquals(medtest2.successftn1(),Exp);
		
		medtest2.clickProducts();
		logger2.log(LogStatus.PASS, "Clicked on Products ");
		
		medtest2.clickAddNew();
		logger2.log(LogStatus.PASS, "Adding New Product");
		
		medtest2.ProdDetails("Sports Wear", "Sports Wear (8-10)", "SPU-03");
		logger2.log(LogStatus.PASS, "Added product details and saved ");
		
		
		
		String Exp1 = "Success: You have modified products!";
		Assert.assertEquals(medtest2.successftn(),Exp1);
		
		screenShot.captureScreenShot("First");
		
		
	}
	

	
}
