package Rakeshproject2023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	 WebDriver driver;
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	 private WebElement Accountpage;
	
	public Accountpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	//actions//
	public boolean getDisplayStatus() {
		// it will the boolean value
		boolean displaystatus= Accountpage.isDisplayed();
		return displaystatus;
	}

}
