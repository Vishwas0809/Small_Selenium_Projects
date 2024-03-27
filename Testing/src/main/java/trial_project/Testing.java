package trial_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Testing {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://dashboard.fincart.com/Login/");
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@title=\"Complete this field\"][@name=\"username\"]")).sendKeys("Testentry@fincart.com");
		driver.findElement(By.xpath("//input[@title=\"Complete this field\"][@name=\"password\"]")).sendKeys("fincart@123");
		driver.findElement(By.xpath("//button[@type=\"submit\"] ")).click();
		Thread.sleep(4000);
		String Name=driver.findElement(By.xpath("(//p[.='abhishek'])[1]")).getText();
		Assert.assertEquals(Name, "abhishek");
		driver.findElement(By.xpath("//button[@class=\"c-jDHsQS\"] ")).click();
		Actions act=new Actions(driver);
	    WebElement My_Profile=driver.findElement(By.xpath("(//p[contains(.,'My Profile')])[1]"));
		act.click(My_Profile).perform();
		act.click(driver.findElement(By.xpath("//div[text()='View']"))).perform();
		driver.findElement(By.xpath("//input[@name=\"PAN_No\"]")).sendKeys("TNEPT4554I");
		Thread.sleep(4000);
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//		WebElement status=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		element.click();
		Thread.sleep(3000);
//		act.click(status).perform();
		SoftAssert sa=new SoftAssert();
		String message=driver.findElement(By.xpath("//p[contains(.,'Oh no! KYC for the given PAN has n')]")).getText();
		sa.assertEquals(message,"Oh no! KYC for the given PAN has not been completed. To complete your KYC, click on proceed");
		sa.assertAll();
		driver.findElement(By.xpath("//button[.='Ok']")).click();
		driver.findElement(By.xpath("//input[@name=\"Name\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"Name\"]")).sendKeys("Abhishek");
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys("mamgain.vishwas@fincart.com");
		driver.findElement(By.xpath("//input[@name=\"Mobile\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"Mobile\"]")).sendKeys("8267822915");
		
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("mamgain.vishwas@fincart.com");
        driver.findElement(By.xpath("(//button)[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Vishwas@17");
        driver.findElement(By.xpath("(//button)[4]")).click();


        Set<String> child = driver.getWindowHandles();
        ArrayList<String> list=new ArrayList<>(child);
        driver.switchTo().window(list.get(0));
        
		
		

	}

}
