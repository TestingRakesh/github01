package TestCase;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rakeshproject2023.Pages.Accountpage;
import Rakeshproject2023.Pages.Homepage;
import Rakeshproject2023.Pages.Loginpage;
import Testbase.Base;
import utlities.utile;

public class LoginTest extends Base{
	
	Loginpage loginpage;
	public LoginTest() {
		super();
		
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void OpeningBrowser() {
		
		
		 driver=setupbrowser(prop.getProperty("browser"));
		 Homepage  homepage= new Homepage(driver);
		 homepage.clickOnMyAccount();
		
		loginpage  = homepage.selectLoginOptions();
		 
		 
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
    @Test(priority=1,dataProvider="validCredentails")
    public void VerifyLoginWithVaildCredentaials(String email,String password) {
   
    	
	 boolean result1= driver.findElement(By.linkText("Qafox.com")).isDisplayed();
		if(result1==true) {
			System.out.println("webpage is visable ");
		}else {
			System.out.println("webpage is not visable");
		}
		
		
		boolean result2=driver.findElement(By.xpath("//input[@type=\"submit\"]")).isDisplayed();
		if(result2==true) {
			System.out.println("login page is displayed");
		}else {
			System.out.println("login is not displayed");
		}
		
		loginpage.emailfailed(email);
		loginpage.enterpassword(password);
		loginpage.submitbutton();
		
		
    }
    
    @DataProvider(name="validCredentails")
    public Object[][] TestData() {
    	Object[][]data= utile.getTextDataFromeExcal("Login");
    	return data;
    }
    
    
    @Test(priority=2)
    public void VerifyLoginWithInVaildCredentaials()  {
    	
    	
    	
		loginpage.emailfailed(utile.generateEmailWithTimeStamp()); 
		loginpage.enterpassword(dataprop.getProperty("invalidpassword"));
		loginpage.submitbutton();
    	
    	
 		 
		
		
		 
		 String ActualMessage =loginpage.recivingthewarringmassage();
		 String expectedMessage =dataprop.getProperty("emailpasswordNomatchwarring");
		 Assert.assertTrue(ActualMessage.contains(expectedMessage),"page is not displayed");
    }
@Test(priority=3)
public void VerifyLoginWithInVaildEmailAndVailedPassword()  {
	
	
	
	loginpage.emailfailed(prop.getProperty("validEmail"));
	loginpage.enterpassword(dataprop.getProperty("invalidpassword"));
	loginpage.submitbutton();
     
	
	 
	 String ActualMessage =loginpage.recivingthewarringmassage();
	 String expectedMessage =dataprop.getProperty("emailpasswordNomatchwarring");
	 Assert.assertTrue(ActualMessage.contains(expectedMessage),"page is not displayed");
	 
}
@Test(priority=4)
public void VerifyLoginWithOutProvindingAnyCredentaials()  {
	
	
	 loginpage.submitbutton();
     driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
     
     String ActualMessage =loginpage.recivingthewarringmassage();
	 String expectedMessage =dataprop.getProperty("emailpasswordNomatchwarring");
	 Assert.assertTrue(ActualMessage.contains(expectedMessage),"page is not displayed");
}
@Test(priority=5)
public void VerifyForgetPassword() {
	 
     driver.findElement(By.linkText("Login")).click();
     driver.findElement(By.xpath("(//a[contains(text(),'Forgotten Password')])[1]")).click();
     
     String ActualForgetmessage= driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]")).getText();
     String expactedForgetMessage="Forgot Your Password?";
     Assert.assertTrue(ActualForgetmessage.contains(expactedForgetMessage),"forgetMessage is not displayed");
     
}

}

