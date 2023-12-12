package com.goldfish.datastar.automation.testing.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestDropDown extends AbstractChromeWebDriverTest {

	@Test
	public void testFacebookLogin() throws Exception {

		//TODO 
		
//		<h2>Dropdown Menu</h2>
//		<p>Move the mouse over the button to open the dropdown menu.</p>
//
//		<div class="dropdown">
//		  <button class="dropbtn">Dropdown</button>
//		  <div class="dropdown-content">
//		  <a href="#">Link 1</a>
//		  <a href="#">Link 2</a>
//		  <a href="#">Link 3</a>
//		  </div>
//		</div>
		driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_dropdown_button");

		//Thread.sleep(500000); 
		// identify element
		WebElement iframeResultID = driver.findElement(By.id("iframeResult"));
		
		System.out.println("iDiframeResult: " + iframeResultID.toString());
		WebElement tagDocument = iframeResultID.findElement(By.tagName("#document"));
		WebElement tagHTML = tagDocument.findElement(By.tagName("html"));
		WebElement tagBody = tagHTML.findElement(By.tagName("body"));
		
		WebElement dropdownClass = tagBody.findElement(By.className("dropdown"));

		System.out.println("dropdownClass: " + dropdownClass.toString());
		
		// Select class for dropdown
		Select select = new Select(dropdownClass);
		// select an item with text visible
		select.selectByVisibleText("Link 2");

		// get selected option with getFirstSelectedOption() with its text
		WebElement o = select.getFirstSelectedOption();
		String selectedoption = o.getText();
		System.out.println("Selected Item: " + selectedoption);
		
		// get selected option with getFirstSelectedOption() with its text
		WebElement list1 = select.getOptions().get(0);
		String selectList1 = list1.getText();
		System.out.println("Selected selectList1: " + selectList1);

		Thread.sleep(5000); // Let the user actually see something!
	}

}
