package dataProvider;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Multiple_Inputs {
	WebDriver driver;
	By name=By.xpath("//input[@name=\"username\"]");
	By pass=By.xpath("//input[@name=\"password\"]");
	By button=By.xpath("//button[@type=\"submit\"]");
	WebDriverWait wait;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	}

	@Test(dataProvider="testData")
public void login(String username,String password) throws InterruptedException {
		driver.manage().window().maximize();
		try{
			driver.get("https://uat-dashboard.fincart.com/Login/");
			
		driver.findElement(name).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(button).click();
		Thread.sleep(4000);
		}
		catch(NoSuchSessionException e){
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("successful");
		}
	}
	@AfterMethod()
	public void teardown() {
	try {	if(driver!=null) {
			driver.quit();
		}
	}
	catch(NoSuchSessionException e){
		System.out.println("yy");
	}
	finally {
		
	}
	}
	@DataProvider(name="testData")
	public Object[][] testdata(){
		return new Object[][] {
			{"test.vishwas17@yopmail.com","12345678"},
			
			{"testvishwas@yopmail.com","UQ9To8"}
		};	
		}
		
}
