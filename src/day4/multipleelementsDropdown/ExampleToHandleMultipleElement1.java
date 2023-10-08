package day4.multipleelementsDropdown;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExampleToHandleMultipleElement1 {

	public static void main(String[] args) {
WebDriver driver=setUp("chrome", "https://www.demoblaze.com/");
		
		//identify all the mobile devices
		List<WebElement> deviceList=driver.findElements(By.cssSelector("#tbodyid>div>div>div>h4>a"));
		//print count of identify devices
		System.out.println("Device count: "+deviceList.size());
		
//		WebElement firstDevice=deviceList.get(0);
//		String deviceName=firstDevice.getText();
//		System.out.println("First device name: "+deviceName);
				//or
		System.out.println("First device name: "+deviceList.get(0).getText());
		
		//print all device names
		for(int i=0;i<deviceList.size();i++) {
			System.out.println(deviceList.get(i).getText());
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


