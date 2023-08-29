package Rakeshproject2023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	//this are objects
	@FindBy(linkText="My Account")
	 private WebElement  MyAccountDropDown;
	
	@FindBy(linkText="Login")
	 private WebElement loginoptions;
	
	@FindBy(xpath="(//input[@type=\"text\"])[1]")
	private WebElement searchproduct;

	@FindBy(xpath="(//button[@type=\"button\"])[4]")
	private WebElement searchbutton;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//actions
	public void clickOnMyAccount() {
		MyAccountDropDown.click();
		
	}
	public Loginpage selectLoginOptions() {
		loginoptions.click();
		return new Loginpage(driver);
		
	}
 public void serachingtheproduct(String searchtext) {
	 searchproduct.sendKeys(searchtext);
 }
 public void searchbuttonForprobuct() {
	 searchbutton.click();
 }
}
