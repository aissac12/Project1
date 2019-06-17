package com.training.pom;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Testcase6POM {
	
private WebDriver driver; 
	
	public Testcase6POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='customer']")
	private WebElement custbtn; 
	
	@FindBy(linkText="Customers")
	private WebElement Custombtn; 
	
	@FindBy(xpath="//input[@name='selected[]' and @value='770']")	//756 is deleted,use 770
	private WebElement Cname; 
	
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement delet; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCustBtn() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(custbtn).build().perform();
        Thread.sleep(1000);
        this.Custombtn.click(); 
        Thread.sleep(1000);
        	
	}
	
	public void scrolldown() throws InterruptedException
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
	}
	
	public void checkCname() throws InterruptedException {
		Thread.sleep(1000);
		this.Cname.click(); 
	}
	
	public void clickDelete() throws InterruptedException {
		Assert.assertTrue(Cname.isSelected());
		Thread.sleep(1000);
		this.delet.click();
		Thread.sleep(1000);
		//driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

}
