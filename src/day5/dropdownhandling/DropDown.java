package day5.dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\Automation\\Workspace\\SeleniumBasic\\executables\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		// open https://www.opencart.com/index.php?route=account/register
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement element = driver.findElement(By.id("input-country"));
		Select dropdown = new Select(element);
		//dropdown.selectByVisibleText("Hong Kong");
		//dropdown.selectByValue("98");
		dropdown.selectByIndex(1);
		
		
		
		
	}

}
