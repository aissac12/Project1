package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MediumPOM1 {
	
private WebDriver driver; 
	
	public MediumPOM1(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='sale']")
	private WebElement salebtn; 
	
	@FindBy(linkText="Orders")
	private WebElement ordbtn; 
	
	@FindBy(xpath="//input[@name='filter_order_id']")
	private WebElement OrderId; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement Filter; 
	
	@FindBy(xpath="//*[@name='filter_order_status']")
	private WebElement OrderStatus; 

	@FindBy(xpath="//*[@class='col-sm-4']/div[1]/div/span/button/i")
	private WebElement calendar; 
	
	@FindBy(xpath="//div[2]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement month; 
	
	@FindBy(xpath="//div[2]/div/div[2]/table/tbody/tr/td/span[2]")
	private WebElement selmonth; 
	
	@FindBy(xpath="//div[2]/div/div[2]/table/thead/tr/th[2]")
	private WebElement selyear;
	
	@FindBy(xpath="//div[2]/div/div[3]/table/tbody/tr/td/span[10]")
	private WebElement year;
	
	@FindBy(xpath="//div[2]/div/div[1]/table/tbody/tr[4]/td[1]")
	private WebElement seldate;
	
	@FindBy(xpath="//input[@name='filter_customer']")
	private WebElement custnam;
	
	@FindBy(xpath="//input[@name='filter_total']")
	private WebElement total;
	
	@FindBy(xpath="//input[@name='filter_date_modified']")
	public WebElement mod_date;
	
	@FindBy(xpath="//input[@name='filter_date_added']")
	public WebElement add_date;
	
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
	
	public void clickOrders() throws InterruptedException { 
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(salebtn).build().perform();
        Thread.sleep(1000);
        this.ordbtn.click(); 
        
        
	}
	
	public void sendOrderId(String ordid) throws InterruptedException
	{
		Thread.sleep(1000);
		this.OrderId.clear(); 
		Thread.sleep(1000);
		this.OrderId.sendKeys(ordid);
		System.out.println("Order Id : " + this.OrderId.getAttribute("value"));
		
	}
	public void selOrdStatus() throws InterruptedException
	{
		Thread.sleep(1000);
		Select sd = new Select(this.OrderStatus);
		List <WebElement> data = sd.getOptions();
		for(int i=0;i<data.size();i++)
			System.out.println(data.get(i).getText());
		sd.selectByVisibleText("Processing");
		
		System.out.println("Order Status : " + this.OrderStatus.getAttribute("value"));		//showing 2,text=showing null
	}
	public void clickFilter() throws InterruptedException
	{
		Thread.sleep(1000);
		this.Filter.click();
		 
	}
	
	public void clickCalendar() throws InterruptedException
	{
		Thread.sleep(1000);
		this.calendar.click();
		Thread.sleep(1000);
		this.month.click();
		Thread.sleep(1000);
		this.selyear.click();
		Thread.sleep(1000);
		this.year.click();
		Thread.sleep(1000);
		this.selmonth.click();
		Thread.sleep(1000);
		this.seldate.click();
		Thread.sleep(1000);
		
	}
	
	public void sendCustName(String custname) {
		this.custnam.clear();
		this.custnam.sendKeys(custname);
		System.out.println("Name : " + this.custnam.getAttribute("value"));
	}

	public void sendTotal(String tot) {
		this.total.clear();
		this.total.sendKeys(tot);
		System.out.println("Total : " + this.total.getAttribute("value"));
	}
	
	public void sendModDate(String modified) {
		this.mod_date.clear();
		this.mod_date.sendKeys(modified);
		System.out.println("Modify Date : " + this.mod_date.getAttribute("value"));
	}
	
	public void sendAddDate(String added) {
		this.add_date.clear();
		this.add_date.sendKeys(added);
		System.out.println("Add Date : " + this.add_date.getAttribute("value"));
	}

}
