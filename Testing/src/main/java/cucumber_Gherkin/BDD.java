package cucumber_Gherkin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.core.Snapshot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BDD {
	WebDriver driver;
	@FindBy(xpath="//title")
	WebElement title;
	@FindBy(xpath="//input[@title=\"Complete this field\"][@name=\"username\"]")
	WebElement username;
	@FindBy(xpath="//input[@title=\"Complete this field\"][@name=\"password\"]")
	WebElement password;
	@FindBy(xpath="//button[@type=\"submit\"] ")
	WebElement button;
	@FindBy(xpath="(//p[.='abhishek'])[1]")
	WebElement name;
	SoftAssert sa;
	@FindBy(xpath="//button[@class=\"c-jDHsQS\"] ")
	WebElement click;
	@FindBy(xpath="(//p[contains(.,'My Profile')])[1]")
	WebElement Myprofile;
	@FindBy(xpath="//div[text()='View']")
	WebElement view;
	@FindBy(xpath="//input[@name=\"PAN_No\"]")
	WebElement pan;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submit;

	    public BDD() {
	        // Constructor
	        driver = new ChromeDriver();
			PageFactory.initElements(driver,this);
	    }
	    @Given("Verify header")
		public void verifyHeader() {
		driver.manage().window().maximize();
		driver.get("https://dashboard.fincart.com/Login/");
		String header=title.getText();
			sa=new SoftAssert();
			sa.assertEquals(header, "Workpoint | Fincart", "assert fail");
		}
	    @And("Verify username")
		public void username() {
			username.sendKeys("Testentry@fincart.com");
		}
        	@When("Verify password")
			public void password() throws InterruptedException {
			password.sendKeys("fincart@123");
			Thread.sleep(4000);
	  		}
         	@And("click")
			public void click() throws InterruptedException {
			button.click();
			Thread.sleep(4000);
					
		}
			@And("name")
			public void verify_name() {
				String Name=name.getText();
				sa=new SoftAssert();
				sa.assertEquals(Name, "abhishek","assert fail");
			}
			@And("button")
			public void Verify_button() throws InterruptedException {
				click.click();
				Thread.sleep(4000);			}
			@And("Profile")
			public void My_profile() throws InterruptedException {
				Myprofile.click();
				view.click();
				Thread.sleep(4000);			}
			@Then("pan")
			public void Input_pan() {
				pan.sendKeys("TNEPT4554I");
				submit.click();
				Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
			}
			@And("screenshot")
			public void compare_screenshot() throws IOException {
//				File image=new File(".\\screenshots\2024_03_18_18_28_41_071.png");
//				BufferedImage expectedImage=ImageIO.read(image);
//				boolean result = Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("actual").equals(expectedImage,0.1);
//				Assert.assertTrue(result);
				Snapshot result = Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("actual");
				BufferedImage newImage=result.getImage();
				Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
				BufferedImage newimage=screenshot.getImage();
				ImageIO.write(newimage, "png", new File(".\\screenshots\\\\xyz.png"));
				ImageDiffer imagediff=new ImageDiffer();
				ImageDiff result1=imagediff.makeDiff(newImage, newimage);
				Assert.assertFalse(result1.hasDiff(), "IMAGES ARE Diff");
				
			}
			
		
		

}
