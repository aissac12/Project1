package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase1POM {
	
private WebDriver driver; 
	
	public Testcase1POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='catalog']")
	private WebElement catlogbutton; 
	
	@FindBy(linkText="Products")
	private WebElement prodBtn; 
	
	@FindBy(xpath="//*[@id='input-name']")
	private WebElement ProductName; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement Filter; 
	
	
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
	
	public void clickProduct() throws InterruptedException { 
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(catlogbutton).build().perform();
        Thread.sleep(1000);
        this.prodBtn.click();   
        
	}
	
	public void sendProductName(String ProductName) throws InterruptedException
	{
		Thread.sleep(1000);
		this.ProductName.clear(); 
		Thread.sleep(1000);
		this.ProductName.sendKeys(ProductName);
		Thread.sleep(1000);
	}
	
	public void clickFilter() throws InterruptedException
	{
		Thread.sleep(1000);
		this.Filter.click();
		 Thread.sleep(1000);
	}

}
