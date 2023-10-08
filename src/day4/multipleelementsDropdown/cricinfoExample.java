package day4.multipleelementsDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cricinfoExample {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://www.espncricinfo.com");
		String expectedTitle1="Today's Cricket Match | Cricket Update | Cricket News | ESPNcricinfo";
		String actutalTitle1=driver.getTitle();
		if(actutalTitle1.equals(expectedTitle1)) {
			System.out.println(" page title validation is passed");
		}else {
			System.out.println(" page title validation is failed");
		}
		
		
		//identify all the suggestions
		List<WebElement> suggList=driver.findElements(By.cssSelector(".ds-bg-fill-navbar>div>div>.ds-justify-between>*:first-child>div>a"));
		
		//suggestion count
		System.out.println("Suggestion count: "+suggList.size());
		
		for(int i=0;i<suggList.size();i++) {
			System.out.println(suggList.get(i).getText());
		}
		
		
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}