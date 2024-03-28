package other_Small_fucn;

import java.util.ArrayList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class Small_fuc {
    public static void main(String[] args) {
    	WebDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		WebElement dd = driver.findElement(By.xpath("//select"));
		Select sct=new Select((WebElement) dd);
	    sct.selectByIndex(2);
	    ArrayList<String>Drop=new ArrayList<String>();
	    for(WebElement option:sct.getOptions()) {
	    	Drop.add(option.getText());
	    	
	    }
	    for(String option:Drop) {
	    	System.out.println(option);
	    }
        
	}
}
