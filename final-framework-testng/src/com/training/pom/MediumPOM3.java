package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MediumPOM3 {
	
private WebDriver driver; 
String Exp = "Success: You have modified returns!";
	
	public MediumPOM3(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='sale']")
	private WebElement salebtn; 
	
	@FindBy(linkText="Returns")
	private WebElement ret; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	@FindBy(css="input#input-name1")
	private WebElement prodnam;
	
	@FindBy(name="order_id")
	private WebElement ordid; 
	
	@FindBy(name="customer")
	private WebElement cust_name; 
	
	@FindBy(id="input-firstname")
	private WebElement first;
	
	@FindBy(id="input-lastname")
	private WebElement last;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement phone;
	
	@FindBy(name="product")
	private WebElement product;
	
	@FindBy(name="model")
	private WebElement mod;
	
	@FindBy(xpath="//*[@data-original-title='Save']")
	private WebElement savebtn; 
	
	@FindBy(xpath="//*[@name='selected[]' and @value='164']")	//use 165
	private WebElement retprod;
	
	@FindBy(xpath="//*[@data-original-title='Delete']")
	private WebElement del;
	
	public void clickCart() throws InterruptedException { 
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(salebtn).build().perform();
        Thread.sleep(1000);
        this.ret.click();    
	}
	
	
	public void ReturnDetails(String id,String custom,String first_name,String last_name,String mail,String num,String prod,String model) throws InterruptedException { 
		
		Thread.sleep(1000);
		this.ordid.sendKeys(id);
		Thread.sleep(1000);
		this.cust_name.sendKeys(custom);
		System.out.println("Customer_name : " + this.cust_name.getAttribute("value"));
		Thread.sleep(1000);
		this.first.sendKeys(first_name);
		System.out.println("First name : " + this.first.getAttribute("value"));
		Thread.sleep(1000);
		this.last.sendKeys(last_name);
		System.out.println("Last name : " + this.last.getAttribute("value"));
		Thread.sleep(1000);
		this.email.sendKeys(mail);
		System.out.println("Email : " + this.email.getAttribute("value"));
		Thread.sleep(1000);
		this.phone.sendKeys(num);
		System.out.println("Phone Number : " + this.phone.getAttribute("value"));
		Thread.sleep(1000);
		this.product.sendKeys(prod);
		System.out.println("Product : " + this.product.getAttribute("value"));
		Thread.sleep(1000);
		this.mod.sendKeys(model);
		System.out.println("Model : " + this.mod.getAttribute("value"));
		Thread.sleep(1000);
		this.savebtn.click();
		String Actualstr1,Expectedstr1,Actuals1;
		Expectedstr1="Success: You have modified returns!";
		Actualstr1=this.success.getText().replace("\n","");
		Actuals1=Actualstr1.replace("×","");
		System.out.println(Actuals1);
		
		Assert.assertEquals(Actuals1, Expectedstr1);	
	}
		
	
	public void Delete() throws InterruptedException
	{
		
		String Actualstr,Expectedstr,Actuals;
		this.retprod.click();
		Thread.sleep(1000);
		Assert.assertTrue(retprod.isSelected());
		this.del.click();
		//driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		Expectedstr="Success: You have modified returns!";
		Actualstr=this.success.getText().replace("\n","");
		Actuals=Actualstr.replace("×","");
		System.out.println(Actuals);
		
		Assert.assertEquals(Actuals, Expectedstr);	
	}
	
	
	
	
	
}
