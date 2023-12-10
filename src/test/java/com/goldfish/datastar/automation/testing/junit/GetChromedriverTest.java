package com.goldfish.datastar.automation.testing.junit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetChromedriverTest extends AbstractChromeWebDriverTest {

	@Test
	/**
	 * 
	 * https://googlechromelabs.github.io/chrome-for-testing/#stable 
	 * 
	 * Including chromedriver win64
	 * https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/win64/chromedriver-win64.zip
	 *
	 * @throws InterruptedException
	 */
	public void testGetChromedriverFromGooglechromelabsByTagName() throws InterruptedException {

		driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");

		// Thread.sleep(5000); // Let the user actually see something!

		WebElement stable = driver.findElement(By.id("stable"));
		System.err.println("*** TestByTestByTagName stable: " + stable.getText());

		WebElement table = stable.findElement(By.tagName("table"));
		System.err.println("*** TestByTestByTagName table: " + table.getText());

		WebElement thead = table.findElement(By.tagName("thead"));
		System.err.println("*** TestByTestByTagName thead: " + thead.getText());

		// Now get all the TR elements from the table
		List<WebElement> allRows = thead.findElements(By.tagName("tr"));

		System.err.println("*** TestByTestByTagName allRows: " + allRows.toString());

		System.err.println(
				"*** TestByTestByTagName allRows.get(3).getText(): " + allRows.get(0).findElements(By.tagName("th")).get(0).getText());

		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(0).getText(), "Binary");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(1).getText(), "Platform");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(2).getText(), "URL");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(3).getText(), "HTTP status");

		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("th"));
			for (WebElement cell : cells) {
				System.err.println("*** TestByTestByTagName cell: " + cell.getText()); // And so on

			}
		}

	}

	@Test
	/**
	 * 
	 * https://googlechromelabs.github.io/chrome-for-testing/#stable 
	 * 
	 * Including chromedriver win64
	 * https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/120.0.6099.71/win64/chromedriver-win64.zip
	 *
	 * @throws InterruptedException
	 */
	public void testGetChromedriverFromGooglechromelabsByXPath() throws InterruptedException {

		driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");
		
		// Thread.sleep(5000); // Let the user actually see something!

		WebElement stable = driver.findElement(By.xpath("//section[@id='stable']"));
		System.err.println("*** TestByTestXPath stable: " + stable.getText());

		WebElement table = stable.findElement(By.xpath(".//table"));
		System.err.println("*** TestByTestXPath table: " + table.getText());

		WebElement thead = table.findElement(By.xpath(".//thead"));
		System.err.println("*** TestByTestXPath thead: " + thead.getText());

		// Now get all the TR elements from the table
		List<WebElement> allRows = thead.findElements(By.xpath(".//tr"));
		System.err.println("*** TestByTestXPath allRows: " + allRows.toString());
		
		System.err.println(
				"*** TestByTestXPath allRows.get(3).getText(): " + allRows.get(0).findElements(By.tagName("th")).get(0).getText());

		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(0).getText(), "Binary");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(1).getText(), "Platform");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(2).getText(), "URL");
		assertEquals(allRows.get(0).findElements(By.tagName("th")).get(3).getText(), "HTTP status");

		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.xpath(".//th"));
			for (WebElement cell : cells) {
				System.err.println("*** TestByTestXPath cell: " + cell.getText()); // And so on

			}
		}
	}
}
