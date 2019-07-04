package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComplexPOM3 {
	
private WebDriver driver; 
	
	public ComplexPOM3(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='caret']")
	private WebElement loginmenu;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	@FindBy(name="email")
	private WebElement mail1;
	
	@FindBy(name="password")
	private WebElement pass; 
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@class='dropdown myaccount']")
	private WebElement account; 
	
	@FindBy(xpath="//li/ul/li[2]/a")
	private WebElement history; 
	
	@FindBy(xpath="//*[@data-original-title='View']")
	private WebElement view; 
	
	@FindBy(xpath="//*[@data-original-title='Return']")
	private WebElement ret; 
	
	@FindBy(xpath="//*[@name='return_reason_id' and @value='1']")
	private WebElement ret_btn;
	
	
	@FindBy(xpath="//*[@name='opened' and @value='1']")
	private WebElement open_btn;
	
	@FindBy(id="input-comment")
	private WebElement comment;
	
	@FindBy(xpath="//*[@type='submit' and @value='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//*[@name='agree' and @value='1']")
	private WebElement agree;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement submit_ret; 
	
	public void userLogin() throws InterruptedException
	{
		this.loginmenu.click();
		Thread.sleep(1000);
		this.login.click();
		Thread.sleep(1000);
	}
	
	public void sendUserName(String email) {
		this.mail1.sendKeys(email);
	}

	public void sendPassword(String password) {
		this.pass.sendKeys(password);
		
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}	
	
	
	public void ordHistory() throws InterruptedException
	{
		this.account.click();
		Thread.sleep(1000);
		this.history.click();
		Thread.sleep(1000);
		this.view.click();
		Thread.sleep(1000);
		this.ret.click();
		Thread.sleep(1000);
	}
	
		public void ordReturn(String comment) throws InterruptedException
		{
		
		this.ret_btn.click();
		Thread.sleep(1000);
		this.open_btn.click();
		Thread.sleep(1000);
		this.comment.sendKeys(comment);
		Thread.sleep(1000);
		this.agree.click();
		Thread.sleep(1000);
		this.submit.click();
		
	}
	
	public String successftn()
	{
		String Act3 = this.submit_ret.getText().replace("\n","");
		String Actual3=Act3.replace("×","");
		System.out.println(Actual3);
		return Actual3;
	}



	
}
