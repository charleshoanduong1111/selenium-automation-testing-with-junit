package com.goldfish.datastar.automation.testing.junit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOpenSwisslinxAndGoogleWithoutAbstract {
	protected WebDriver driver;

	@Test
	public void testSwisslinxCom() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver-version-120/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(50000); //
		driver.get("https://www.swisslinx.com/");
		Thread.sleep(50000); // Let the user actually see something!
		driver.quit();
	}
	

	@Test
	public void testGoogleSearch() throws InterruptedException {

		// Optional. If not specified, WebDriver searches the PATH for
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver-version-120/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/");		

		Thread.sleep(5000); // Let the user actually see something!

		driver.quit();

	}

}
