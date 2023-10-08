package day1.browseropening;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Example0 {

	public static void main(String[] args) {
		// open browser
		WebDriver  driver= setUp("chrome");
		// enter application url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter username as Admin, 0-30 seconds time to identify the element
				/**identify username input field*/
				WebElement userNameInputField=driver.findElement(By.name("username"));
				/**once you identify the element perform required action
				 * click ---> click()
				 * type  ---> sendKeys("");
				 * delete existing text ---> clear()
				 */
				userNameInputField.sendKeys("Admin");
				//enter password as admin123,0-30 seconds time to identify the element
//				WebElement passwordInputField=driver.findElement(By.name("password"));
//				passwordInputField.sendKeys("admin123");
					//or
				driver.findElement(By.name("password")).sendKeys("admin123");
				
				//click on login button,0-30 seconds time to identify the element
				/**Identify login button and click on it*/
				driver.findElement(By.className("orangehrm-login-button")).click();	
			}

			public static WebDriver setUp(String browsername) {		
				if(browsername.equalsIgnoreCase("chrome")) {
					/*1. Set the required browser driver executable path using:	System.setProperty( key, value);*/
					System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
					/*2. After setting the path of driver executable, create an instance of required browser*/
					return new ChromeDriver();
				}else if(browsername.equalsIgnoreCase("firefox")) {
					/*1. Set the required browser driver executable path using:	System.setProperty( key, value);*/
					System.setProperty("webdriver.gecko.driver", ".\\executables\\geckodriver.exe");
					/*2. After setting the path of driver executable, create an instance of required browser*/
					return new FirefoxDriver();
				}else if(browsername.equalsIgnoreCase("ie")) {
					/*1. Set the required browser driver executable path using:	System.setProperty( key, value);*/
					System.setProperty("webdriver.ie.driver", ".\\executables\\IEDriverServer.exe");
					/*2. After setting the path of driver executable, create an instance of required browser*/
					return new InternetExplorerDriver();
				}
				return null;
			}
		}
		/*
		open browser
		enter application url
		enter username as Admin
		enter password as admin123
		click on login button
		*/