package day3.syncAndbrowserOps;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitExample {

	public static void main(String[] args) {
		 WebDriver driver = setUp("chrome","https://demo.actitime.com/login.do");
		 System.out.println("Login page title: "+driver.getTitle());
			//type user name as admin  
			driver.findElement(By.id("username")).sendKeys("admin");
			/*type password as manager */ 
			driver.findElement(By.name("pwd")).sendKeys("manager");
			/*click on login button*/
			driver.findElement(By.id("loginButton")).click();
			
			//validate HOME page
			String expectedtHomePageTitle="actiTIME - Enter Time-Track";
			//In real world, Actitime home page title changes after sometime, thats why Selenium will get Login page title 
			// to avoid this we can use conditional wait of selenium
			
			//Create an instance of FluentWait class with timeout, polling time(retry) and exception to be ignored
			FluentWait wait=new FluentWait(driver)
			.withTimeout(Duration.ofSeconds(20))//max time
			.pollingEvery(Duration.ofSeconds(5))//retry time 
			.ignoring(NoSuchElementException.class);//to ignore expected exception if element is not visible in retry
			
			wait.until(ExpectedConditions.titleIs(expectedtHomePageTitle));
			
			String actualHomePageTile=driver.getTitle();
			System.out.println("Actual Home page title: "+actualHomePageTile);
			System.out.println("Expected Home page title: "+expectedtHomePageTitle);
			if(actualHomePageTile.equals(expectedtHomePageTitle)) {
				System.out.println("Home page validation is successfull, logout from the application now");
				//step7:logout from the application
				/*identify the login button using findElement(By) and perform the required operation*/
				driver.findElement(By.id("logoutLink")).click();
			}else {
				System.out.println("Home page validation is failed, not allowed to logout from the application");
			}		
			//step8: close the browser
			//driver.close();
		}

	private static WebDriver setUp(String browserName, String appUrl) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}
