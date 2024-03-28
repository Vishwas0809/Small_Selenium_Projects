package extent_Report;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Reports {
	static ExtentTest test;
	static ExtentReports Reports;

	public static void main(String[] args) throws IOException {
//		test=new ExtentTest(Reports, "", "");
		Reports=new ExtentReports();
	WebDriver driver=new ChromeDriver();
//	driver.get("https://www.google.com/search?q=google&rlz=1C1FKPE_enIN1099IN1099&oq=google&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDM4OTNqMGo0qAIAsAIB&sourceid=chrome&ie=UTF-8");
//    TakesScreenshot shot=(TakesScreenshot)driver;
//    File ss = shot.getScreenshotAs(OutputType.FILE);
//    File des=new File("C:\\xx\\xyz.png");
//    FileUtils.copyFile(ss,des);
	driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
	WebElement dd = driver.findElement(By.xpath("//select"));
    Select sct=new Select(dd);
    sct.selectByIndex(2);
    ArrayList<String> drop1=new ArrayList<>();
	} 
}


