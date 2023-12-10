package com.goldfish.datastar.automation.testing.junit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractChromeWebDriverTest {

	protected WebDriver driver;

	public AbstractChromeWebDriverTest() {
		super();
	}

	//@BeforeTest
	@Before
	public void beforeTest() {
		System.err.println("System.setProperty");
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver-version-120/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
		//Download the web driver executable
		//TODO WebDriverManager.chromedriver().setup();
		//ChromeDriverManager.getInstance(driverManagerType)		
	
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://www.google.com");

		
		//Create a instance of your web driver - chrome
		//driver = new ChromeDriver();
	}

	// WebDriverManager.chromedriver().setup();
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://www.google.com");
	// driver.quit();

	@After
	public void afterTest() {
		driver.quit();
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}