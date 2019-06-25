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

public class MediumPOM4 {
	
private WebDriver driver; 
	
	public MediumPOM4(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='customer']")
	private WebElement custbtn; 
	
	@FindBy(linkText="Customers")
	private WebElement customer; 
	
	@FindBy(xpath="//tbody/tr[3]/td[8]/a")	
	private WebElement edit;
	
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(linkText="Address 1")
	private WebElement addr;
	
	@FindBy(id="input-postcode1")
	private WebElement post;
	
	@FindBy(linkText="Reward Points")
	private WebElement points;
	
	@FindBy(xpath="//div[@class='tab-content']/div[4]/div/div/input")
	private WebElement desc;
	
	@FindBy(id="input-points")
	private WebElement ipoints;
	
	@FindBy(id="button-reward")
	private WebElement rew_btn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	@FindBy(xpath="//*[@data-original-title='Save']")
	private WebElement savebtn; 
	

	public void clickCustomer() throws InterruptedException
	{
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(custbtn).build().perform();
        Thread.sleep(1000);
        this.customer.click();   
	}
	
	public void Editting(String firstname,String code,String description,String inp_point) throws InterruptedException
	{
		this.edit.click();
		Thread.sleep(1000);
		this.fname.clear();
		Thread.sleep(1000);
		this.fname.sendKeys(firstname);
		System.out.println("First name : " + this.fname.getAttribute("value"));
		Thread.sleep(1000);
		this.addr.click();
		Thread.sleep(1000);
		this.post.clear();
		Thread.sleep(1000);
		this.post.sendKeys(code);
		System.out.println("Post code : " + this.post.getAttribute("value"));
		Thread.sleep(1000);
		this.points.click();
		Thread.sleep(1000);
		this.desc.sendKeys(description);
		System.out.println("Description : " + this.desc.getAttribute("value"));
		Thread.sleep(1000);
		this.ipoints.sendKeys(inp_point);
		System.out.println("Points : " + this.ipoints.getAttribute("value"));
		Thread.sleep(1000);
		this.rew_btn.click();
		Thread.sleep(1000);
		
		String Expect_str="Success: You have modified customers!";
		String Actual=this.success.getText().replace("\n","");
		String Actualstr = Actual.replace("×","");
		System.out.println(Actualstr);
		
		Assert.assertEquals(Actualstr, Expect_str);	
		
		this.savebtn.click();
		String Expect_str1="Success: You have modified customers!";
		String Actual1=this.success.getText().replace("\n","");
		String Actualstr1 = Actual1.replace("×","");
		System.out.println(Actualstr1);
		Assert.assertEquals(Actualstr1, Expect_str1);

		
	}
	
	
	
	
}
