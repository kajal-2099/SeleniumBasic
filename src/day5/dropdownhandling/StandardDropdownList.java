package day5.dropdownhandling;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardDropdownList {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://demo.automationtesting.in/Register.html");
		//identify dropdown list uniquely
		WebElement skillDropdown=driver.findElement(By.id("Skills"));
		//create an instance of Select class and pass above dropdown to its constructor
		Select skillDrop=new Select(skillDropdown);
		/*
		 * operation:
		 * 		1. is this multiselect dropdown
		 * 		2. default/selected value
		 * 		3. total option
		 * 		4. options name
		 * 		5. select option and check newly selected option is visible or not
		 */
		System.out.println("is multi select allowed? "+skillDrop.isMultiple());
		
//		WebElement defaultOption=skillDrop.getFirstSelectedOption();
//		String defaultValue=defaultOption.getText();
//		System.out.println("Dropdown default selected value: "+defaultValue);
				//or
		System.out.println("Dropdown default selected value: "+skillDrop.getFirstSelectedOption().getText());
		
		
//		List<WebElement> optionList=skillDrop.getOptions();
//		int count=optionList.size();
//		System.out.println("Option count in dropdown: "+count);
				//or
		System.out.println("Option count in dropdown: "+skillDrop.getOptions().size());
		
		for(int i=0;i<skillDrop.getOptions().size();i++) {
			System.out.println(skillDrop.getOptions().get(i).getText());
		}
		
		//select option from dropdown
		//skillDrop.selectByIndex(2);
				//or
		//skillDrop.selectByValue("Adobe Photoshop");
				//or
		skillDrop.selectByVisibleText("Adobe Photoshop");
		System.out.println("Newly selected value: "+skillDrop.getFirstSelectedOption().getText());

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