package Rakeshproject2023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsuccespage {
	WebDriver driver;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
     private WebElement accountsuccesspage;
	
	public  Accountsuccespage(WebDriver driver) {
		this .driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String recivingtheaccountsuccesspage () {
		String accountsuccesspagetext=accountsuccesspage.getText();
		return accountsuccesspagetext;
	}
}
