package day1.browseropening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectIdentificationexample1 {

	public static void main(String[] args) {
		//open browser
				WebDriver driver=setUp("chrome");
				//enter application url
				driver.get("https://www.saucedemo.com/");
				//enter username
				WebElement usernameInputField=driver.findElement(By.id("user-name"));
				usernameInputField.sendKeys("standard_user");
				
				//enter password
				WebElement passwordInputField=driver.findElement(By.id("password"));
				passwordInputField.sendKeys("secret_sauce");
				
				//click on login button
				WebElement loginButton=driver.findElement(By.name("login-button"));
				loginButton.click();
				// close the browser
				//driver.close();
				
			}
			public static WebDriver setUp(String browserName) {
				WebDriver driver = null;
				if (browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", ".\\executables\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				return driver;
			}
		}
		/*
		findElement(By)- it helps us to identify the element from the application opened in the browser
					   - its return type is WebElement
					   - it contains By class as an parameter, which several static methods to locate the
					     element from the application.
					   - these By class static methods are known as Locators in Selenium.
					   - id(String) | name(String) | linkText(String) | partialLinkText(String) | className(String)
					     tagName(String) | cssSelector(String) | xpath(String)
					     
			- once the WebElement is identified, you can perform any requied action on it
			  - type   		----> sendkeys("");
			  - click		----> click();
			  - existing text --> clear();
		 */


		/*
		open browser
		enter application url
		enter username 
		enter password
		click on login button
		close browser
		 */