package day1.browseropening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs {
	public static void main(String args[]) {
		// launch the browser
		System.setProperty("webdriver.chrome.driver", "G:\\\\Automation\\\\Workspace\\\\SeleniumBasic\\\\executables\\\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    // open swag labs web page
	    driver.get("https://www.saucedemo.com");
	    // locate username using single attribute
	     driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	     // locate password using multiple attribute
	     driver.findElement(By.xpath("//*[@id='password'][@name='password']")).sendKeys("secret_sauce");
        // locate login button
	     driver.findElement(By.xpath("//input[@id='login-button']")).click();
	     // switch to product page
	     String currentWindowHandle = driver.getWindowHandle();
	     driver.switchTo().window(currentWindowHandle);
	}
	

}
