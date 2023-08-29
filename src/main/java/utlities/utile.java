package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

    public class utile {
	public static final  int implicitywait_time=10;
	public static final int Pageloade_wait_time=15;
		
	
	public static String generateEmailWithTimeStamp() {
		Date date=new Date();
		String timestamp=date.toString().replace(" ", "_").replace(":", "_");
		return"automations"+timestamp+"@gmail.com";
	}
	public static Object[][] getTextDataFromeExcal(String sheetname) {
		
		File excalFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Rakeshproject2023.xlsx");
		XSSFWorkbook workbook = null;
		try {
		FileInputStream fisexal=new FileInputStream(excalFile);
		 workbook=new XSSFWorkbook(fisexal);
		}catch(Throwable e) {
			e.printStackTrace();
		}
			
		
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		Object[][]data=new Object[rows][cols];
		for(int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				XSSFCell call = row.getCell(j);
				CellType cellType = call.getCellType();
				switch(cellType) {
				case STRING:
					data[i][j]=call.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)call.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=call.getBooleanCellValue();
					break;
				}
			}
			
		}
		return data;
	}
	//taken the screenshot
	public   static String captureScreenshot(WebDriver driver,String testname) {
		File srcScrenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		
		try {
			FileHandler.copy(srcScrenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}

}
