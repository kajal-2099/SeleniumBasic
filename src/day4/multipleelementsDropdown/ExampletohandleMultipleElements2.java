package day4.multipleelementsDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExampletohandleMultipleElements2 {

	public static void main(String[] args) {
		WebDriver driver = setUp("chrome", "https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Manual Testing");
		// identify all the suggestions
		List<WebElement> suggList=driver.findElements(By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>*:first-child>*:first-child>span"));
		// suggestion count 
		System.out.println("Suggestion count: "+suggList.size());
		for(int i=0;i<suggList.size();i++) {
			System.out.println(((WebElement)suggList).getText());
		}
	}
     public static WebDriver setUp(String browserName,String appUrl) {
    	 WebDriver driver = null;
    	 if(browserName.equalsIgnoreCase("chrome")) {
    		 System.setProperty("webdriver.chrome.driver", ".\\executables\\chromedriver.exe");
    		 driver = new ChromeDriver();
    	 }else if(browserName.equalsIgnoreCase("firefox")) {
    		 System.setProperty("webdriver.gecko.driver", ".\\executables\\gecko.exe");
    	    driver = new FirefoxDriver();
    	 }
    	 driver.manage().window().maximize();
    	 driver.get(appUrl);
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 return driver;
     }
}
