package day1.browseropening;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Example1 {
	 static WebDriver driver;
	private static WebElement userNameInputField;
	public static void main(String[] args) {
	 // step1
		setUp("chrome");
		// step2
		driver.get("https://demo.actitime.com/login.do");
		 // step 3
		/* identify the user name feild using findElement(By)
		*/
		userNameInputField=driver.findElement(By.id("username"));
	    /** once element id identified, perform requied operation-
	     * type text----> sendKeys("");
	     * click---------> click();
	     * delete existing text---> clear();
	     */
		userNameInputField.sendKeys("admin");
		// step 4: enter password as manager
		/* identify the password field using findElement(By) 
		 */
		WebElement passwordInputfield = driver.findElement(By.name("pwd"));
		/**once element id identified, perform required operation-
		 * type text----> sendKeys("");
		 * click--------> click();
		 * delete existing text---> clear();
		 */
		passwordInputfield.sendKeys("manager");
//step5: click on login button
		/*identify the login button using findElement(By)*/
		WebElement loginButton=driver.findElement(By.id("loginButton"));
		/**once element id identified, perform required operation-
		 * type text----> sendKeys("");
		 * click--------> click();
		 * delete existing text---> clear();
		 */
		loginButton.click();
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
/*
1. open chrome browser
2. enter application url
3. enter username as admin
4. enter password as manager
5. click on login button
6. validate home page
7. close the browser
*/
	
