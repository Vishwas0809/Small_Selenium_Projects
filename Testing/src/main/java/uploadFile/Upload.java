package uploadFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.filemail.com/share/upload-file");
		driver.manage().window().maximize();
		WebElement uload = driver.findElement(By.xpath("//label[@id=\"addBtn\"]"));
		uload.click();
//		uload.sendKeys("\"C:\\\\Users\\\\FINCART\\\\Desktop\\\\Untitled.png");
//		WebElement upload=driver.findElement(By.xpath("(//span[@role=\"button\"])[2]"));
////		driver.findElement(By.xpath("//div[@jsname=\"R5mgy\"]"));
//		upload.sendKeys("C:\\Users\\FINCART\\eclipse-workspace\\Automation\\screenshots\\xyz.png");
		Runtime.getRuntime().exec("C:\\Users\\FINCART\\Desktop\\ww.exe");
//	driver.close();
		
		// TODO Auto-generated method stub

	}


}
