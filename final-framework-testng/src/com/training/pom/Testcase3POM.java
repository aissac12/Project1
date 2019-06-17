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

public class Testcase3POM {
	
private WebDriver driver; 
	
	public Testcase3POM(WebDriver driver) {
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
	
	@FindBy(linkText="Orders")
	private WebElement Ordbtn; 
	
	@FindBy(xpath="//input[@name='filter_date_start']")
	private WebElement startDate;
	
	@FindBy(xpath="//input[@name='filter_date_end']")
	private WebElement endDate;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement Filter;
	
	@FindBy(name="filter_group")
	private WebElement Groupby;
	
	@FindBy(name="filter_order_status_id")
	private WebElement Status;
	
	
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
	
	public void clickOrdBtn() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);	 
        action.moveToElement(repbtn).build().perform();
        Thread.sleep(1000);
        this.Salesbtn.click();  
        Thread.sleep(1000);
        this.Ordbtn.click();
        	
	}
	
	public void enterDate() throws InterruptedException
	{
		Thread.sleep(1000);
		this.startDate.clear();
		Thread.sleep(1000);
		this.startDate.sendKeys("2019-01-01");
		
		Thread.sleep(1000);
		this.endDate.clear();
		Thread.sleep(1000);
		this.endDate.sendKeys("2019-12-31");
	}
	
	public void clickFilter() throws InterruptedException
	{
		Thread.sleep(1000);
		this.Filter.click();
		 Thread.sleep(1000);
	}
	
	public void clkGrpBy()
	{
		Select sd = new Select(this.Groupby);
		List <WebElement> data = sd.getOptions();
		for(int i=0;i<data.size();i++)
			System.out.println(data.get(i).getText());
		sd.selectByVisibleText("Days");
	}
	
	public void clkStatus()
	{
		Select sel = new Select(this.Status);
		List <WebElement> data1 =sel.getOptions();
		for(int i=0;i<data1.size();i++)
			System.out.println(data1.get(i).getText());
		sel.selectByVisibleText("Pending");
		
		//sel.selectByValue("Pending");	//Cannot locate option with value: Pending
	}
	

}
