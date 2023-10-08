package assignment;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.*;
	import Utilities.SeleniumUtil;

	public class OrangeHRMPIMTestNG {
	    WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        driver = KeyboardMouse.SeleniumUtil.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    @Test(priority = 1)
	    public void validateLoginPage() {
	        String expectedTitle = "OrangeHRM";
	        String actualTitle = driver.getTitle();
	        if (actualTitle.equals(expectedTitle)) {
	            System.out.println("Login page validation is passed");
	        } else {
	            System.out.println("Login page validation is failed");
	        }
	    }

	    @Test(priority = 2)
	    public void addEmployee() throws InterruptedException {
	        // Your existing code for adding an employee
	        // ...
	    	//click on add btn
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			//enter first name
		   driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("KAJAL");
			
			//enter last name
			driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("JAISWAL");
			
			//enter emp id
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("12987");
			//clock on save btn
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
			
	    }

	    @Test(priority = 3)
	    public void updateUserJobTitleAndEmploymentStatus() throws InterruptedException {
	        // Your existing code for updating user job title and employment status
	        // ...
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}


}
