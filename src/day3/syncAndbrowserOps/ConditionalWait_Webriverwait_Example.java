package day3.syncAndbrowserOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConditionalWait_Webriverwait_Example {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://demo.actitime.com/login.do");
		System.out.println("Before Login, page title: "+driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		//conditional wait to wait for a particular element to available on the screen
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		String expectedHomePageTitle="actiTIME - Enter Time-Track";
		//WebDriver will wait till the page title is not getting match with expected title with in given time
		wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
			
		System.out.println("After login, page title: "+driver.getTitle());
	}
	public static WebDriver setUp(String browserName,String appUrl) {
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
	}

}
