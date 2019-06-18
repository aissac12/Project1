package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Testcase2POM {
	
private WebDriver driver; 
	
	public Testcase2POM(WebDriver driver) {
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
	private WebElement ProdBtn; 
	
	@FindBy(xpath="//input[@name='selected[]' and @value='455']")	//Created 4 blazer products with value 452,453,454,455,456 and deleted 452,453,454
	private WebElement Pname; 
	
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement delet; 
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement success; 
	
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
	
	public void clickCatlogbutton() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(catlogbutton).build().perform();
        Thread.sleep(1000);
        this.ProdBtn.click();   
        
	}
	
	public void checkPname() throws InterruptedException {
		Thread.sleep(1000);
		this.Pname.click(); 
	}
	
	public void clickDelete() throws InterruptedException {
		String Actualstr,Expectedstr,Actual;
		Assert.assertTrue(Pname.isSelected());
		Thread.sleep(1000);
		this.delet.click();
		Thread.sleep(1000);
		//driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		
		Actualstr=this.success.getText().replace("\n","");
		
		Actual=Actualstr.replace("×","");
		System.out.println(Actual);

		Expectedstr="Success: You have modified products!";
		Assert.assertEquals(Actual, Expectedstr);	
		
		
	}
	

	


}
