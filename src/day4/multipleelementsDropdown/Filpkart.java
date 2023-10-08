package day4.multipleelementsDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Filpkart {
  static WebDriver driver;
	public static void main(String[] args) {
		setUp("chrome", "https://www.flipkart.com/");
		List<WebElement> brandNameList=driver.findElements(By.cssSelector(".brandmenu-v2>ul>li>a"));
		System.out.println("Brand Names: "+brandNameList.size());
		for(int i=0;i<brandNameList.size();i++) {
			System.out.println(brandNameList.get(i).getText());
		}
		
		brandNameList.get(0).click();
		List<WebElement> deviceNames=driver.findElements(By.cssSelector(".makers>ul>li>a>strong>span"));
		System.out.println("Device count: "+deviceNames.size());
		for(int i=0;i<deviceNames.size();i++) {
			System.out.println(deviceNames.get(i).getText());
		}
		
	}
	public static void setUp(String browserName, String appUrl) {
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
		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// maximize browser window
		driver.manage().window().maximize();
		// enter the required URL
		driver.get(appUrl);
	}
}
