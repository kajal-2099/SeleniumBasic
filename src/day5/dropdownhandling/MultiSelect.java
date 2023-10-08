package day5.dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class MultiSelect {

	public static void main(String[] args) {
	 WebDriver driver = setUp("chrome", "http://omayo.blogspot.com");
	 WebElement dropdown = driver.findElement(By.id("multiselect1"));
	 Select select = new Select(dropdown);
	 System.out.println(select.isMultiple());
	 /*
	  * in multi select we get some additional functions like
	  * 1- if you have selected multiple option & you want count for them dn use
	  * getAllSelectedOption() --> List<WebElement>
	  *  2- if you want to un-select selected option dn use
	  *  deselectByIndex(int)
	  *  deselectByIndex(String)
	  *  deselectByVisibleText(String)
	  *  deselectAll()
	  *  we don't have any method to select all option, for that we need write some logic 
	  */
	 select.selectByValue("swiftx");
	 select.selectByIndex(0);
	 select.selectByIndex(2);
	 System.out.println(Select.getAllSelectedOptions().size());
	 for(int i=0;i<select.getAllSelectedOptions().size();i++) {
		 System.out.println(Select.getAllSelectedOptions().get(i).getText());
	 }
	    select.deselectAll();
	}
      public static WebDriver setUp(String browserName, String appUrl) {
    	  WebDriver driver = null;
    	  
      }
}
