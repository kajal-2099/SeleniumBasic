package openbrowser;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefoxBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","G:\\Automation\\Workspace\\SeleniumBasic\\executables\\geckodriver.exe");
		FirefoxDriver fdrive = new FirefoxDriver();
	}

}
