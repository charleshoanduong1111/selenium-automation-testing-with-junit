package com.goldfish.datastar.automation.testing.junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestOpenSwisslinxAndGoogle extends AbstractChromeWebDriverTest {

	@Test
	public void testSwisslinxCom() throws InterruptedException {

		Thread.sleep(50000); //
		driver.get("https://www.swisslinx.com/");
		Thread.sleep(50000); // Let the user actually see something!
		driver.quit();
	}

	@Test
	public void testGoogleSearch() throws InterruptedException {

		driver.get("http://www.google.com/");

		Thread.sleep(5000); // Let the user actually see something!

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("ChromeDriver");

		searchBox.submit();

		Thread.sleep(5000); // Let the user actually see something!

		driver.quit();

	}

	@Test
	/**
	 * 
	 * https://googlechromelabs.github.io/chrome-for-testing/#stable	 * 
	 * 
	 * chromedriver	win64	
	 * 
	 * https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/win64/chromedriver-win64.zip
	 *
	 * @throws InterruptedException
	 */
	public void testGetChromedriverFromGooglechromelabs()
			throws InterruptedException {

		driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");

		Thread.sleep(5000); // Let the user actually see something!

		// TODO
		WebElement browserRow1 = driver
				.findElement(By
						.cssSelector("#table-wrapper > tbody > tr:nth-child(2) > td:nth-child(2)"));
//		WebElement browserRow2 = driver
//				.findElement(By
//						.cssSelector("#dataTables-example > tbody > tr:nth-child(2) > td:nth-child(2)"));
//		WebElement browserRow3 = driver
//				.findElement(By
//						.cssSelector("#dataTables-example > tbody > tr:nth-child(3) > td:nth-child(2)"));
//		assertEquals(browserRow1.getText(), "Firefox 1.0");
//		assertEquals(browserRow2.getText(), "Firefox 1.5");
//		assertEquals(browserRow3.getText(), "Firefox 2.0");

		// WebElement searchBox = driver.findElement(By.name("q"));
		//
		// searchBox.sendKeys("ChromeDriver");
		//
		// searchBox.submit();
		//
		// Thread.sleep(5000); // Let the user actually see something!

		driver.quit();

	}

}
