package page_Factory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageFactory_intialisation {
	WebDriver driver;
    Page_Factory_Model Pf;
    
    @BeforeTest
    public void setup() {
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	   driver.get("https://dashboard.fincart.com/Login/");
   	   driver.manage().window().maximize();
    	
    }
    @Test
    public void intialisation() throws InterruptedException, IOException {
    	Pf=new Page_Factory_Model(driver);
    	Pf.verifyHeader();
    	Pf.username("Testentry@fincart.com");
    	Pf.password("fincart@123");
    	Pf.click();
    	Pf.verify_name();
    	Pf.Verify_button();
    	Pf.My_profile();
    	Pf.Input_pan("TNEPT4554I");
    	Pf.compare_screenshot();
    	
    }
}
