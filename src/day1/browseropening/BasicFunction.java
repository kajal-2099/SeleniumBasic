package day1.browseropening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasicFunction {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome");
		//enter required url in the opened browser
		driver.get("https://demo.actitime.com/");
		//get current page source code
		String pageSource=driver.getPageSource();
		System.out.println(pageSource.length());
		//System.out.println(pageSource);
		//print current page title
		System.out.println("current page title: "+driver.getTitle());
		//print current page url
		System.out.println("current page url: "+driver.getCurrentUrl());
		//to close current instance of browser use
		driver.close();
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
 * every time selenium launches new browser, it won't work on existing opened browser 
 * browser opened by selenium won't be having- 
 * 1. history 2. cache & cookies
 */