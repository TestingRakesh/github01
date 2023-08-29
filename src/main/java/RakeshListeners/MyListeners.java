package RakeshListeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utlities.extentReporter;
import utlities.utile;

public class MyListeners implements ITestListener{
	ExtentReports extenReport;
	ExtentTest extentest;
	String testname;
	
	@Override
	public void onStart(ITestContext context) {
		 extenReport = extentReporter.generateextendreport();
		
	}
	@Override
	public void onTestStart(ITestResult result) {
	     testname=result.getName();
	    extentest = extenReport.createTest(testname);
		extentest.log(Status.INFO,testname+"started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentest.log(Status.PASS,testname+"got successfuly executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		String destinationScreenshotPath=utile.captureScreenshot(driver, testname);
		
		extentest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.FAIL, testname+"got failed");
		


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(testname+"got skiiped");
		System.out.println(result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext context) {
		extenReport.flush();
		
		String pathofExtenReport=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		
		File extentReport=new File(pathofExtenReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
