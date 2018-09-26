package ddt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrameWorkDDT {
	
	//Object Identification on my 1st Test Method
	
	@Test(dataProvider = "WordPress")
	public void loginMethod(String username, String Password){
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\de543804\\Downloads\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://wordpress.com/log-in");
		
		// Will collect this data from provider
		
		driver.findElement(By.xpath(".//*[@id='usernameOrEmail']")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);
        
		driver.findElement(By.xpath(".//*[@id='primary']/div/main/div/div[1]/div/form/div[1]/div[2]/button")).submit();
		
		//Data Provider - Providing data to the script
		
		@DataProvider(name="WordPress")
		
        public String method(){
	    Object[][] data = new Object[3][2];
	
}
		
		
		
		
		
	}
}