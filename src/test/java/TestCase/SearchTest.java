package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Rakeshproject2023.Pages.Homepage;
import Testbase.Base;

public class SearchTest extends Base {
	public SearchTest() {
		super();
		
	}
	 public WebDriver driver;
	
	@BeforeMethod
	public void openingBrowser() {
		driver=setupbrowser(prop.getProperty("browser"));
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	@Test(priority=1)
public void VerifySearchWithValidedproduct() {
		
		Homepage homepage=new Homepage(driver);
		homepage.serachingtheproduct(dataprop.getProperty("validProduct"));
		homepage.searchbuttonForprobuct();
		
		driver.findElement(By.xpath("(//button[@type=\"button\"])[4]")).click();
		boolean result2=driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed();
		if(result2==true) {
			System.out.println("product is visiable in web page");
		}else {
			System.out.println("probuct is not visable in web page");
		}
		
}
	@Test(priority=2)
	public void verifyWithNotVissableProduct() throws InterruptedException {
		
		Homepage homepage=new Homepage(driver);
		homepage.serachingtheproduct(dataprop.getProperty("invalidproduct"));
		homepage.searchbuttonForprobuct();
		
		Thread.sleep(3000);
		String actualMessage=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText();
		String expectedMessage=dataprop.getProperty("GettingTheNonvisableProduct");
		Assert.assertTrue(actualMessage.contains(expectedMessage),"worng product is not displayesd in page ");
	}
	@Test(priority=3)
	public void VerifyWithOutAnyProvidingproduct()  {
		
		
		   Homepage homepage=new Homepage(driver);
		   homepage.searchbuttonForprobuct();
	
		boolean result=driver.findElement(By.xpath("//h2[contains(text(),'Products meeting the search criteria')]")).isDisplayed();
		if(result==true) {
			System.out.println("message is displayed in webPage");
		}else {
			System.out.println("message is not displayed");
		}
	}
}
