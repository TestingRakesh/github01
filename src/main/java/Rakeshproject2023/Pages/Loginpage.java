package Rakeshproject2023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage  {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
      private WebElement EmailelementFiled;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	   private WebElement passwordfiled;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	 private WebElement loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	 private WebElement emailpasswordNomatchwarring;
	
	public Loginpage(WebDriver driver) {
		this .driver=driver;
		
		PageFactory.initElements(driver, this);
		
		}
	
	//Actions
			public void emailfailed(String email) {
				EmailelementFiled.sendKeys(email);
			}

			public void enterpassword(String password) {
				passwordfiled.sendKeys(password);
			}
           public void submitbutton() {
        	   loginbutton.click();
           }
           public String recivingthewarringmassage() {
        	  String warringtext= emailpasswordNomatchwarring.getText();
        	  return warringtext;
           }
			
			}
	

