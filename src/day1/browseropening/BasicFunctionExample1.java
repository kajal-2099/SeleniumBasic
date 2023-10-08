package day1.browseropening;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicFunctionExample1 {

	public static void main(String[] args) {
		// open a browser
				WebDriver driver = setUp("chrome");
				// enter application URL
				driver.get("https://www.google.com");
				
				// get current page title and print its value and number character in it
				String pageTitle = driver.getTitle();
				System.out.println("Current page title: " + pageTitle);
				System.out.println("Page title char count: " + pageTitle.length());
				
				// get current page url and print its value and number character in it
				String pageUrl = driver.getCurrentUrl();
				System.out.println("Current page url: " + pageUrl);
				System.out.println("Page url char count: " + pageUrl.length());
				
				//get page source code and print its char count
				String pageSource=driver.getPageSource();
				//System.out.println("Page source code: "+pageSource);// source is very big which will show only latest lines
				System.out.println("Page source char count: "+pageSource.length());
				
				//close current browser
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
		 * Open browser enter application URL get current page title and print its value
		 * and number character in it get current page url and print its value and
		 * number character in it close the browser
		 */

