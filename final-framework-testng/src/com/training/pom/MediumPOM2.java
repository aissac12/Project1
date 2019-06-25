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

public class MediumPOM2 {
	
private WebDriver driver; 
	
	public MediumPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='catalog']")
	private WebElement catbtn; 
	
	@FindBy(linkText="Categories")
	private WebElement categbtn; 
	
	@FindBy(linkText="Products")
	private WebElement prodbtn; 
	
	@FindBy(xpath="//*[@data-original-title='Add New']")
	private WebElement addnew; 
	
	@FindBy(xpath="//*[@name='category_description[1][name]']")
	private WebElement catname; 
	
	@FindBy(xpath="//*[@class='note-editable panel-body']")
	private WebElement description; 
	
	@FindBy(xpath="//*[@name='category_description[1][meta_title]']")
	private WebElement megatitle; 
	
	@FindBy(xpath="//*[@name='category_description[1][meta_description]']")
	private WebElement megadesc; 
	
	@FindBy(xpath="//*[@data-original-title='Save']")
	private WebElement savebtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	@FindBy(css="input#input-name1")
	private WebElement prodnam;
	
	@FindBy(css="input#input-meta-title1")
	private WebElement prodtitle;
	
	@FindBy(linkText="Data")
	private WebElement datatab; 
	
	@FindBy(linkText="Links")
	private WebElement linktab; 
	
	@FindBy(name="model")
	private WebElement model; 
	
	@FindBy(name="category")
	private WebElement categ;
	
	@FindBy(xpath="//div[@class='col-sm-10']/ul/li[7]/a")
	private WebElement sports;
	
	@FindBy(xpath="//*[@name='category']")
	private WebElement list;
	
	@FindBy(xpath="//div[@id='product-category285']")
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
	

	public void clickCategories() throws InterruptedException { 
		Thread.sleep(1000);
		Actions action = new Actions(driver);	 
        action.moveToElement(catbtn).build().perform();
        Thread.sleep(1000);
        this.categbtn.click();   
        
	}
	
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
	
	public void CatDetails(String name,String desc,String mega,String megades) throws InterruptedException { 
		String Exp = "Success: You have modified categories!";
		Thread.sleep(1000);
		this.catname.sendKeys(name);
		System.out.println("Category name : " + this.catname.getAttribute("value"));
		Thread.sleep(1000);
		this.description.sendKeys(desc);
		System.out.println("Category description : " + this.description.getText());	
		Thread.sleep(1000);
		this.megatitle.sendKeys(mega);
		System.out.println("Meta tag title : " + this.megatitle.getAttribute("value"));
		Thread.sleep(1000);
		this.megadesc.sendKeys(megades);
		System.out.println("Meta tag description : " + this.megadesc.getAttribute("value"));
		Thread.sleep(1000);
		this.savebtn.click();
		Thread.sleep(1000);
		String Act = this.success.getText().replace("\n","");
		String Actual=Act.replace("×","");
		System.out.println(Actual);
		
		Assert.assertEquals(Exp, Actual);
		
	}
	
	public void ProdDetails(String name, String title, String mod) throws InterruptedException
	{
		String Exp1 = "Success: You have modified products!";
		
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
		Thread.sleep(2000);
		this.datatab.click();
		Thread.sleep(1000);
		this.model.sendKeys(mod);
		System.out.println("Model : " + this.model.getAttribute("value"));
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
		String Act1 = this.success.getText().replace("\n","");
		String Actual1=Act1.replace("×","");
		System.out.println(Actual1);
		
		Assert.assertEquals(Exp1, Actual1);
		
	}
	
	
	
}
