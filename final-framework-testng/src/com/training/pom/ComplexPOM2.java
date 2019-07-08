package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComplexPOM2 {
	
private WebDriver driver; 
	
	public ComplexPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='img-responsive']")
	private WebElement shirt;
	
	@FindBy(name="option[370]")
	private WebElement size;
	
	@FindBy(id="button-cart")
	private WebElement add_cart;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	@FindBy(id="cart")
	private WebElement items;
	
	@FindBy(linkText="View Cart")
	private WebElement view;
	
	@FindBy(linkText="Checkout")
	private WebElement checkout;
	
	@FindBy(xpath="//input[@name='account' and @value='guest']")
	private WebElement guest; 
	
	@FindBy(id="button-account")
	private WebElement cont;
	
	@FindBy(id="input-payment-firstname")
	private WebElement firstnam;
	
	@FindBy(id="input-payment-lastname")
	private WebElement lastnam;
	
	@FindBy(id="input-payment-email")
	private WebElement mail;
	
	@FindBy(id="input-payment-telephone")
	private WebElement phone;
	
	@FindBy(id="input-payment-company")
	private WebElement company;
	
	@FindBy(id="input-payment-address-1")
	private WebElement addr;
	
	@FindBy(id="input-payment-city")
	private WebElement city;
	
	@FindBy(id="input-payment-postcode")
	private WebElement post;
	
	@FindBy(name="zone_id")
	private WebElement zone;
	
	@FindBy(id="button-guest")
	private WebElement continu;
	
	@FindBy(name="shipping_address")
	private WebElement check;
	
	@FindBy(name="comment")
	private WebElement comment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continu1;
	
	@FindBy(name="agree")
	private WebElement agree;
	
	@FindBy(id="button-payment-method")
	private WebElement cont1;
	
	@FindBy(id="button-confirm")
	private WebElement confrm;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement placed;
	
	@FindBy(css="body")
	private WebElement new_tab;
	
	//admin window
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement loginButton; 
	
	@FindBy(xpath="//*[@id='sale']")
	private WebElement salebtn; 
	
	
	@FindBy(linkText="Orders")
	private WebElement ordbtn;  
	
	@FindBy(xpath="//tbody/tr/td[8]/a[@data-original-title='View']")
	private WebElement views;  
	
	@FindBy(id="input-order-status")
	private WebElement ordstatus;
	
	@FindBy(xpath="//div[@class='col-sm-10']/select/option[4]")
	private WebElement complete;
	
	@FindBy(id="button-history")
	private WebElement history;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success1; 
	
	//user tab
	
	@FindBy(xpath="//*[@class='dropdown myaccount']")
	private WebElement loginmenu;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	@FindBy(name="email")
	private WebElement mail1;
	
	@FindBy(name="password")
	private WebElement pass; 
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(linkText="View your order history")
	private WebElement ord_history; 
	
	@FindBy(linkText="History")
	private WebElement element; 
	
	public void scroll() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)", "");
	}
	
	public void selectShirt() throws InterruptedException { 
		Thread.sleep(1000);
		this.shirt.click();
		
		Select sel1 = new Select(this.size);
		 List <WebElement> data1 =sel1.getOptions();
			for(int i=0;i<data1.size();i++)
				System.out.println(data1.get(i).getText());
			sel1.selectByVisibleText("38");
		
		Thread.sleep(1000);
		this.add_cart.click();
		Thread.sleep(1000);
  
	}
	
	public String successftn()
	{
		String Act1 = this.success.getText().replace("\n","");
		String Actual1=Act1.replace("×","");
		System.out.println(Actual1);
		return Actual1;
	}	
	
	public void clickItem() throws InterruptedException
	{
		Thread.sleep(1000);
		this.items.click();
		Thread.sleep(1000);
		this.view.click();
		Thread.sleep(1000);
		this.checkout.click();
		Thread.sleep(1000);
		this.guest.click();
		Thread.sleep(1000);
		this.cont.click();
		Thread.sleep(1000);
	}
	 public void personal(String fname,String lname,String email,String phone_no) throws InterruptedException
	 {
		 this.firstnam.sendKeys(fname);
		 Thread.sleep(1000);
		 this.lastnam.sendKeys(lname);
		 Thread.sleep(1000);
		 this.mail.sendKeys(email);
		 Thread.sleep(1000);
		 this.phone.sendKeys(phone_no);
		 Thread.sleep(1000);
	 }
	 
	 public void address(String company,String address,String city,String postcode) throws InterruptedException
	 {
		 this.company.sendKeys(company);
		 Thread.sleep(1000);
		 this.addr.sendKeys(address);
		 Thread.sleep(1000);
		 this.city.sendKeys(city);
		 Thread.sleep(1000);
		 this.post.sendKeys(postcode);
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,250)", "");
		 
		 Select sel = new Select(this.zone);
		 List <WebElement> data =sel.getOptions();
			for(int i=0;i<data.size();i++)
				System.out.println(data.get(i).getText());
			sel.selectByVisibleText("Karnataka");
	 }
	 public void checkout() throws InterruptedException
	 {
		Thread.sleep(1000);
		if(this.check.isSelected())
			Thread.sleep(1000);
		else 
			this.check.click();

		this.continu.click();	
		this.comment.sendKeys("Comments for ordered product");
		Thread.sleep(1000);
		this.continu1.click();
		Thread.sleep(1000);
		if(this.agree.isSelected())
			Thread.sleep(1000);
		else 
			this.agree.click();
		
		this.cont1.click();
		Thread.sleep(1000);
		this.confrm.click();
	 }
	 
	 public String place_order()
		{
			String Act2 = this.placed.getText().replace("\n","");
			String Actual2=Act2.replace("×","");
			System.out.println(Actual2);
			return Actual2;
		}	

	 //admin window
	 public void adminUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void adminPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		
		public void adminLoginBtn() {
			this.loginButton.click(); 
		}
		
		public void clickSales() throws InterruptedException { 
			Thread.sleep(1000);
			Actions action = new Actions(driver);	 
	        action.moveToElement(salebtn).build().perform();
	        Thread.sleep(1000);
	        this.ordbtn.click();   
	        
		}
		public void clickView() throws InterruptedException {
		this.views.click();
		Thread.sleep(1000);
		}
		
		public void changeStatus() throws InterruptedException {
			
	        this.ordstatus.click();
	        Thread.sleep(1000);
	        this.complete.click();
	        Thread.sleep(1000);
	        this.history.click();
	        Thread.sleep(1000);
	        
		}
		
		public String successftn1()
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.element);
			String Act2 = this.success.getText().replace("\n","");
			String Actual2=Act2.replace("×","");
			System.out.println(Actual2);
			return Actual2;
		}	
		
		public void userLogin(String email,String password) throws InterruptedException
		{
			this.loginmenu.click();
			Thread.sleep(1000);
			this.login.click();
			Thread.sleep(1000);
			this.mail1.sendKeys(email);
			Thread.sleep(1000);
			this.pass.sendKeys(password);
			Thread.sleep(1000);
			this.loginBtn.click();
			Thread.sleep(1000);
			this.ord_history.click();
			Thread.sleep(1000);
			
			
			
		}
	
}
