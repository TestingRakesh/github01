package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {

	public static  ExtentReports generateextendreport() {
		ExtentReports extenReport=new ExtentReports();
		File ExtentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(ExtentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Rakesh AutomationsTesting Project2023 Results");
		sparkReporter.config().setDocumentTitle("Rakesh Automations Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YY/HH:MM:SS");

		extenReport.attachReporter(sparkReporter);
		
		Properties configprop=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\Rakeshproject\\config\\config.properties");
		
		try {
		FileInputStream fisconfigprop= new FileInputStream(configPropFile);
		configprop.load(fisconfigprop);
		}catch(Throwable e) {
			e.printStackTrace();
		
		}
		extenReport.setSystemInfo("Application URL",configprop.getProperty("URL"));
		extenReport.setSystemInfo("Browser", configprop.getProperty("browser"));
		extenReport.setSystemInfo("Email", configprop.getProperty("validEmail"));
		extenReport.setSystemInfo("password", configprop.getProperty("validPassword"));
		extenReport.setSystemInfo("operating System",System.getProperty("os.name"));
		extenReport.setSystemInfo("username",System.getProperty("user.name"));
		extenReport.setSystemInfo("java version",System.getProperty("java.version"));
        return extenReport;
	}
}
