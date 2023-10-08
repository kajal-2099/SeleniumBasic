package KeyboardMouse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) {
		        // Set the path to the ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		     // Navigate to the Flipkart site
		        driver.get("https://www.flipkart.com/");
		        // Create a new instance of ChromeDriver
		        WebDriver driver = new ChromeDriver();
		        // Define the number of times you want to scroll
		        int scrollTimes = 3;

		        // Locate an element on the page (you can choose any element)
		        WebElement scrollElement = driver.findElement(By.cssSelector("css_selector_of_element_to_scroll"));

		        // Create an instance of Actions for scrolling
		        Actions actions = new Actions(driver);

		        // Perform scrolling using Actions
		        for (int i = 0; i < scrollTimes; i++) {
		            actions.moveToElement(scrollElement).perform();
		            // Add a short delay between scrolls to simulate human interaction
		            try {
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }

		        // Close the browser
		        driver.quit();
		    }

	}
