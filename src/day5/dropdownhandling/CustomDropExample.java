package day5.dropdownhandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CustomDropExample {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://thompsonsj.com/bootstrap-select-dropdown/");
		//click on dropdown list
		driver.findElement(By.cssSelector(".btn-primary")).click();
		//get all the option list
		List<WebElement> optionList=driver.findElements(By.cssSelector(".dropdown-menu-right.show>div>a"));
		System.out.println("Option count: "+optionList.size());
		
		for(int i=0;i<optionList.size();i++) {
			System.out.println(optionList.get(i).getText());
		}

		//select option from dropdown
		optionList.get(2).click();
	}
	public static WebDriver setUp(String browserName, String appUrl) {
		WebDriver driver=null;
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
		return driver;
	}
}
