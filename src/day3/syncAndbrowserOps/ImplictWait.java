package day3.syncAndbrowserOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplictWait {

	public static void main(String[] args) {
	 WebDriver driver = setUp("chrome","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 // implicit wait
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 // identify username field with in implicit wait 0-30sec
	 driver.findElement(By.name("username")).sendKeys("Admin");
	 // identify password field with in implicit wait 0-30sec
	 driver.findElement(By.className("orangehrm-login-button")).click();
	
	}

	private static WebDriver setUp(String browserName, String appUrl) {
     WebDriver driver = null;
     if(browserName.equalsIgnoreCase("chrome")) {
    	 System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
    	 driver = new ChromeDriver();
     }else if(browserName.equalsIgnoreCase("firefox")){
    	 System.setProperty("webdriver.gecko.driver", ".\\executables\\geckodriver.exe");
         driver = new FirefoxDriver();
     }
       driver.manage().window().maximize();
       driver.get(appUrl);
		return driver;
	}

}
