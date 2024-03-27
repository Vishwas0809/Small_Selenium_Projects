package page_Factory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.*;

import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Page_Factory_Model {
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
			
			
			public Page_Factory_Model(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
				public void verifyHeader() {
					String header=title.getText();
					sa=new SoftAssert();
					sa.assertEquals(header, "Workpoint | Fincart", "assert fail");
				}
				public void username(String args) {
					username.sendKeys(args);
				}
					public void password(String args) throws InterruptedException {
					password.sendKeys(args);
					Thread.sleep(4000);
					}
					public void click() throws InterruptedException {
					button.click();
					Thread.sleep(4000);
							
				}
					public void verify_name() {
						String Name=name.getText();
						sa=new SoftAssert();
						sa.assertEquals(Name, "abhishek","assert fail");
					}
					public void Verify_button() throws InterruptedException {
						click.click();
						Thread.sleep(4000);			}
					public void My_profile() throws InterruptedException {
						Myprofile.click();
						view.click();
						Thread.sleep(4000);			}
					public void Input_pan(String args) {
						pan.sendKeys(args);
						submit.click();
						Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
					}
					public void compare_screenshot() throws IOException {
//						File image=new File(".\\screenshots\2024_03_18_18_28_41_071.png");
//						BufferedImage expectedImage=ImageIO.read(image);
//						boolean result = Shutterbug.shootPage(driver, Capture.FULL_SCROLL).withName("actual").equals(expectedImage,0.1);
//						Assert.assertTrue(result);
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

