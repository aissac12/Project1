package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComplexPOM1 {
	
private WebDriver driver; 
	
	public ComplexPOM1(WebDriver driver) {
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
	private WebElement catbtn; 
	
	
	@FindBy(linkText="Products")
	private WebElement prodbtn;  
	
	@FindBy(xpath="//*[@data-original-title='Add New']")
	private WebElement addnew; 
	
	@FindBy(css="input#input-name1")
	private WebElement prodnam;
	
	@FindBy(css="input#input-meta-title1")
	private WebElement prodtitle;

	@FindBy(linkText="Data")
	private WebElement datatab; 

	@FindBy(name="model")
	private WebElement model; 
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-quantity")
	private WebElement qty;
	
	
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
	
	@FindBy(linkText="Links")
	private WebElement linktab; 
	
	
	@FindBy(name="category")
	private WebElement categ;
	
	@FindBy(xpath="//div[@class='col-sm-10']/ul/li[7]/a")
	private WebElement sports;
	
	@FindBy(xpath="//*[@name='category']")
	private WebElement list;
	
	@FindBy(xpath="//div[@id='product-category']")
	private WebElement text;
	
	@FindBy(linkText="Attribute")
	private WebElement attribute_tab; 
	
	@FindBy(linkText="Option")
	private WebElement option_tab; 
	
	@FindBy(linkText="Recurring")
	private WebElement recurring_tab;
	
	@FindBy(linkText="Discount")
	private WebElement discount_tab;
	
	@FindBy(linkText="Special")
	private WebElement special_tab;
	
	@FindBy(linkText="Image")
	private WebElement image_tab;
	
	@FindBy(linkText="Reward Points")
	private WebElement reward_tab;
	
	@FindBy(linkText="Design")
	private WebElement design_tab;
	
	@FindBy(xpath="//*[@data-original-title='Save']")
	private WebElement savebtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	public void clickProducts() throws InterruptedException { 
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(catbtn).build().perform();
        Thread.sleep(1000);
        this.prodbtn.click();   
        
	}
	
	public void clickAddNew() throws InterruptedException { 
		Thread.sleep(1000);
		this.addnew.click();
	}
	
	public void ProdDetails(String name, String title, String mod, String rs, String quant) throws InterruptedException
	{
		
		Thread.sleep(1000);
		this.prodnam.sendKeys(name);
		Thread.sleep(1000);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		this.prodtitle.sendKeys(title);
		System.out.println("Title : " + this.prodtitle.getAttribute("value"));
		Thread.sleep(1000);
		//jse.executeScript("window.scrollBy(350,0)", "");	//scrolling fast
		this.datatab.click();
		Thread.sleep(1000);
		this.model.sendKeys(mod);
		System.out.println("Model : " + this.model.getAttribute("value"));
		Thread.sleep(1000);
		this.price.sendKeys(rs);
		System.out.println("Price : " + this.price.getAttribute("value"));
		Thread.sleep(1000);
		this.qty.sendKeys(quant);
		System.out.println("Quantity : " + this.qty.getAttribute("value"));
		Thread.sleep(1000);
		
		this.linktab.click();
		Thread.sleep(1000);
		this.categ.click();
		Thread.sleep(1000);
		this.sports.click();
		System.out.println("Category List : " + this.text.getText());
		Thread.sleep(1000);
		this.attribute_tab.click();
		Thread.sleep(1000);
		this.option_tab.click();
		Thread.sleep(1000);
		this.recurring_tab.click();
		Thread.sleep(1000);
		this.discount_tab.click();
		Thread.sleep(1000);
		this.special_tab.click();
		Thread.sleep(1000);
		this.image_tab.click();
		Thread.sleep(1000);
		this.reward_tab.click();
		Thread.sleep(1000);
		this.design_tab.click();
		Thread.sleep(1000);
		
		this.savebtn.click();
		Thread.sleep(1000);
		
	}
	
	public String successftn()
	{
		String Act1 = this.success.getText().replace("\n","");
		String Actual1=Act1.replace("×","");
		System.out.println(Actual1);
		return Actual1;
	}	
	
	
	
}
