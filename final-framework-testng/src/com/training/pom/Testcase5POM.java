package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Testcase5POM {
	
private WebDriver driver; 
	
	public Testcase5POM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[@name='filter_name']")
	private WebElement name;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement Filter;
	
	@FindBy(xpath="//input[@name='filter_email']")
	private WebElement email;
	
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
	
	public void clickCustBtn() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);	 
        action.moveToElement(custbtn).build().perform();
        Thread.sleep(1000);
        this.Custombtn.click();  
        	
	}
	
	public void enterName() throws InterruptedException
	{
		Thread.sleep(1000);
		this.name.clear();
		Thread.sleep(1000);
		this.name.sendKeys("manzoor");
	}
	
	public void clickFilter() throws InterruptedException
	{
		Thread.sleep(1000);
		this.Filter.click();
		 Thread.sleep(1000);
	}
	
	public void enterEmail() throws InterruptedException
	{
		Thread.sleep(1000);
		this.email.clear();
		Thread.sleep(1000);
		this.email.sendKeys("manzoor@gmail.com");
	}
	
	

}
