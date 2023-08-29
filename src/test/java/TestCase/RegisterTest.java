package TestCase;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Rakeshproject2023.Pages.Accountsuccespage;
import Rakeshproject2023.Pages.Homepage;
import Rakeshproject2023.Pages.Registerpage;
import Testbase.Base;
import utlities.utile;

public class RegisterTest extends Base {
	public RegisterTest() {
		super();
		
	}
 public  WebDriver driver;
 @BeforeMethod
 public void openingBrowser() {
	 
	 driver=setupbrowser(prop.getProperty("browser"));
	 Homepage homepage= new Homepage(driver);
	 homepage.clickOnMyAccount();
	
 }
 @AfterMethod
 public void teardown() {
	 driver.quit();
 }
 @Test(priority=1)
	public void VerifyRegisterWithAllFilead() {
		  
		 driver.findElement(By.xpath("(//a[contains(text(),'Register')])[1]")).click();
		 boolean result3=driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed();
		 if(result3==true) {
			 System.out.println("Register page is displayed");
		 }else {
			 System.out.println("Register page is not displayed");
		 }
		 
		  Registerpage registerpage=new Registerpage(driver);
		  registerpage.enterfistnamefailed(dataprop.getProperty("fistname"));
		  registerpage.enterlastnamefield(dataprop.getProperty("lastname"));
		  registerpage.emailaddress(utile.generateEmailWithTimeStamp());
		  registerpage.telephonefiled(dataprop.getProperty("telephone"));
		  registerpage.passwordfiled(dataprop.getProperty("password"));
		  registerpage.conformpassword(dataprop.getProperty("confirmpassword"));
		  registerpage.privacypolicyfield();
		  registerpage.continuebutton();
		
         Accountsuccespage accountsuccesspage=new Accountsuccespage(driver);
		 String ActualMessage =accountsuccesspage.recivingtheaccountsuccesspage();
		 String expectedMessage =dataprop.getProperty("displayingTheWEbPageTittle");
		 Assert.assertTrue(ActualMessage.contains(expectedMessage),"page is not displayed");

	}
 @Test(priority=2)
 public void VerifyRegisterWithSelleterFilead() {
	 driver.findElement(By.xpath("(//a[contains(text(),'Register')])[1]")).click();
	 boolean result3=driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed();
	 if(result3==true) {
		 System.out.println("Register page is displayed");
	 }else {
		 System.out.println("Register page is not displayed");
	 }
	  Registerpage registerpage=new Registerpage(driver);
	  registerpage.enterfistnamefailed(dataprop.getProperty("fistname"));
	  registerpage.enterlastnamefield(dataprop.getProperty("lastname"));
	  registerpage.emailaddress(utile.generateEmailWithTimeStamp());
	  registerpage.telephonefiled(dataprop.getProperty("telephone"));
	  registerpage.passwordfiled(dataprop.getProperty("password"));
	  registerpage.conformpassword(dataprop.getProperty("confirmpassword"));
	  registerpage.newselector();
	  registerpage.privacypolicyfield();
	  registerpage.continuebutton();
	
     Accountsuccespage accountsuccesspage=new Accountsuccespage(driver);
	 String ActualMessage =accountsuccesspage.recivingtheaccountsuccesspage();
	 String expectedMessage =dataprop.getProperty("displayingTheWEbPageTittle");
	 Assert.assertTrue(ActualMessage.contains(expectedMessage),"page is not displayed");

	
 }
 @Test(priority=3)
 public void VerifyWithExitingEmail() {
	 driver.findElement(By.xpath("(//a[contains(text(),'Register')])[1]")).click();
	 boolean result3=driver.findElement(By.xpath("//h1[text()='Register Account']")).isDisplayed();
	 if(result3==true) {
		 System.out.println("Register page is displayed");
	 }else {
		 System.out.println("Register page is not displayed");
	 }
	 Registerpage registerpage=new Registerpage(driver);
	  registerpage.enterfistnamefailed(dataprop.getProperty("fistname"));
	  registerpage.enterlastnamefield(dataprop.getProperty("lastname"));
	  registerpage.emailaddress(utile.generateEmailWithTimeStamp());
	  registerpage.telephonefiled(dataprop.getProperty("telephone"));
	  registerpage.passwordfiled(dataprop.getProperty("password"));
	  registerpage.conformpassword(dataprop.getProperty("confirmpassword"));
	  registerpage.newselector();
	  registerpage.privacypolicyfield();
	  registerpage.continuebutton();

 }

}
