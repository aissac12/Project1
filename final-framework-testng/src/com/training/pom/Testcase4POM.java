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

public class Testcase4POM {
	
private WebDriver driver; 
	
	public Testcase4POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='reports']")
	private WebElement repbtn; 
	
	@FindBy(linkText="Sales")
	private WebElement Salesbtn; 
	
	@FindBy(linkText="Tax")
	private WebElement Taxbtn; 
	
	@FindBy(name="filter_group")
	private WebElement Groupby;
	
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
	
	public void clickTaxBtn() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);	 
        action.moveToElement(repbtn).build().perform();
        Thread.sleep(1000);
        this.Salesbtn.click();  
        Thread.sleep(1000);
        this.Taxbtn.click();
        Thread.sleep(1000);
	}
	public void clkGrpBy() throws InterruptedException
	{
		Select sd = new Select(this.Groupby);
		List <WebElement> data = sd.getOptions();
		for(int i=0;i<data.size();i++)
			System.out.println(data.get(i).getText());
		sd.selectByVisibleText("Days");
		Thread.sleep(1000);
	}
	
	public void clickFilter() throws InterruptedException
	{
		this.Filter.click();
		 Thread.sleep(1000);
	}
	
}
