package day2.basicobjectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VitgerLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=setUp("chrome");
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		//userName input field- visible, editable, default
		WebElement userNameInputField=driver.findElement(By.id("username"));
		System.out.println("is user name input field visible? "+userNameInputField.isDisplayed());
		System.out.println("is user name input field editable? "+userNameInputField.isEnabled());
		System.out.println("default value of user name input field: "+userNameInputField.getAttribute("admin"));
		
		
		WebElement passwordInputField=driver.findElement(By.id("password"));
		System.out.println("is password input field visible? "+passwordInputField.isDisplayed());
		System.out.println("is password input field editable? "+passwordInputField.isEnabled());
		System.out.println("default valud of password name input field: "+passwordInputField.getAttribute("password"));
		
		
		WebElement btn=driver.findElement(By.className("buttonBlue"));
		
		System.out.println("Is button visiable?" +btn.isDisplayed());
		System.out.println("Is button clickable?" +btn.isEnabled());
		System.out.println("button name value?" +btn.getText());
		
		
		
	WebElement user=driver.findElement(By.id("username"));
	user.clear();
  

    user.sendKeys("admin");

    WebElement pass=driver.findElement(By.id("password"));
     pass.clear();
    
	pass.sendKeys("Test@123");
	//click on Sign in button
	WebElement btn1=driver.findElement(By.className("buttonBlue"));

	btn1.click();
//validate home page
	String expectedTitle="Dashboard";
	String actutalTitle=driver.getTitle();
	if(actutalTitle.equals(expectedTitle)) {
		System.out.println("home page validation is passed");
	}else {
		System.out.println("home page validation is failed");
	}		

	
	
	
	//click on profile icon
	WebElement profile=driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[5]/div/a/span[1]"));
	profile.click();
	

	WebElement signout=driver.findElement(By.linkText("Sign Out"));
	signout.click();
	

	
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
		driver.manage().window().maximize();
		//driver.get(appUrl);
		return driver;
	
	}
	}

