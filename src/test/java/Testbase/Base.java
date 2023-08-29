package Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utlities.utile;

    public class Base {
    	
	 WebDriver driver;
	 public Properties prop;
     public Properties dataprop;
	 
	public Base() {
		
	    prop= new Properties();
		File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\Rakeshproject\\config\\config.properties");
		
		dataprop=new Properties();
		File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\testdata.properties");
		try {
		
		FileInputStream fis2= new FileInputStream(datapropFile);
		dataprop.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
			
		}
		
		
		
		
		try {
		FileInputStream fis=new FileInputStream(propfile);
		prop.load(fis);
		}catch(Throwable e){
			e.printStackTrace();
			
		}
	}
public WebDriver setupbrowser(String browser) {

	
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(browser.equalsIgnoreCase("edge")){
		driver=new EdgeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utile.implicitywait_time));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utile.Pageloade_wait_time));
	 driver.get(prop.getProperty("URL"));
	 return driver;
}
}
