package other_Small_fucn;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handling {
        public static void main(String[] args) {
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
//			String parent = driver.getWindowHandle();
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://www.eclipse.org/forums/index.php/t/1103287/");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://stage-dashboard.fincart.com/Login/");
			Set<String> child = driver.getWindowHandles();
			ArrayList<String> win=new ArrayList<>(child);
			driver.switchTo().window(win.get(1));
			driver.switchTo().window(win.get(0));
			driver.switchTo().window(win.get(2));
			driver.switchTo().window(win.get(0));
			driver.switchTo().window(win.get(1));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeAsyncScript("window.scrollBy(0,2000)", args);
			js.executeAsyncScript("arguments[0].click()", args);
			js.executeAsyncScript("arguments[0].value='dd'", args);
//			driver.quit();
 }
}
