package Rakeshproject2023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	WebDriver driver;
	
@FindBy(xpath="//input[@id=\"input-firstname\"]")
 private WebElement fistnamefiled;

@FindBy(xpath="//input[@id=\"input-lastname\"]")
 private WebElement lastregisternamefiled;


@FindBy(xpath="//input[@id=\"input-email\"]")
 private WebElement emailaddressfiled;


@FindBy(xpath="//input[@id=\"input-telephone\"]")
 private WebElement telephonefiled;


@FindBy(xpath="//input[@id=\"input-password\"]")
 private WebElement passwordfiled;


@FindBy(xpath="//input[@id=\"input-confirm\"]")
 private WebElement conformpassword;



@FindBy(xpath="//input[@type=\"checkbox\"]")
 private WebElement privacypolicyfield;


@FindBy(xpath="//input[@type=\"submit\"]")
 private WebElement continuebutton;

@FindBy(xpath="(//input[@type=\"radio\"])[2]")
private WebElement Newselector;



public Registerpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
public void enterfistnamefailed(String fistnametext) {
	fistnamefiled.sendKeys(fistnametext);
}
public void enterlastnamefield(String lastnametext) {
	lastregisternamefiled.sendKeys(lastnametext);
}
public void emailaddress(String emailtext) {
	 emailaddressfiled.sendKeys(emailtext);
	
	
}
public void telephonefiled(String telephonetext) {
	telephonefiled.sendKeys(telephonetext);
	
}
public void passwordfiled(String passwordtext) {
	passwordfiled.sendKeys(passwordtext);
}
public void conformpassword(String conformpasswordtext) {
	conformpassword.sendKeys(conformpasswordtext);
	
}
public void  privacypolicyfield() {
	 privacypolicyfield.click();
}
public void continuebutton() {
	continuebutton.click();
}
public void newselector() {
	Newselector.click();
}
}