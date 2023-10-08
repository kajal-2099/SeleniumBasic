package day2.basicobjectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserOperations {

	public static void main(String[] args) {
		// open the browser and enter application url
		WebDriver driver = setUp("chrome","https://demo.automationtesting.in/Register.html");
	    // to maximize browser window
		driver.manage().window().maximize();
		// to minimize you need to user setsize() method
		driver.manage().window().setSize(new Dimension(500,600));
		// to maximize browser window 
		driver.manage().window().maximize();
		// click on Webtable link
		driver.findElement(By.linkText("WebTable")).click();
		// if you want to move to another application/url dn use 
		driver.navigate().to("https://www.google.com");
	}
	public static WebDriver setUp(String browserName,String appUrl) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver","\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("WeDriver.gecko.driver","\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(appUrl);
		return driver;
	}

}
