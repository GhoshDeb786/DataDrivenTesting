package ddt;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataTesting {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\INFOCOM\\Downloads\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.freecrm.com/index.html?e=1");
		
	}
	
	@Test(dataProvider = "testdata")
	public void test(String username, String password) {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@DataProvider(name = "testdata")
	public void method() throws BiffException, IOException {
		
		//Using File class to set the location of the sheet
		
		File obj = new File("C:\\Users\\INFOCOM\\Desktop\\DataForTestNG_1.xls");
		System.out.println("Excel located Successfully");
		
		//Workbook is a predefined Class - To work with Excel file
		
		// To Load the Workbook
		Workbook wb = Workbook.getWorkbook(obj); 
		System.out.println("Workbook Loaded Successfully");
		
		//Using wb object it has to read the sheet
		
		String value = wb.getSheet("Sheet1").getCell(0, 1).getContents();
		String value1 = wb.getSheet("Sheet1").getCell(1, 2).getContents();
		String value2 = wb.getSheet("Sheet1").getCell(1, 1).getContents();
		String value3 = wb.getSheet("Sheet1").getCell(1, 2).getContents();
		System.out.println("The Contents are : " + value + " " + value1 + " "+ value1 +" "+ value1 );
		
		
		//To get the No.of Rows & coloumns
		
		int a = wb.getSheet(0).getRows();
		int b = wb.getSheet(0).getColumns();
		System.out.println(a);
		System.out.println(b);
					
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
	
}
	


