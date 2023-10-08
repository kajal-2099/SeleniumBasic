package day1.browseropening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Example2 {
  static WebDriver driver;
	public static void main(String[] args) {
		// step 1
		setUp("chrome");
		// step 2
		driver.get("https://demo.actitime.com/login.do");
		// step 3: enter username as admin 
		/* identify the user name field using findElement(By) and perform the required operation
		 */
		driver.findElement(By.id("pwd")).sendKeys("manager");
		// step 5: click on login button 
		/*
		 * identify the login button using findElement(By) and perform the required operation
		 */
		driver.findElement(By.id("loginbutton")).click();
		// step7: close the browser 
		  driver.close();

	}
	public static void setUp(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
	}

}
}