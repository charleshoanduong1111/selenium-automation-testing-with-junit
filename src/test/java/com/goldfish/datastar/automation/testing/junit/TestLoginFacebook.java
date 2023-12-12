package com.goldfish.datastar.automation.testing.junit;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestLoginFacebook extends AbstractChromeWebDriverTest {

	@Test
	public void testFacebookLogin() throws Exception {

		driver.get("https://de-de.facebook.com/");

		Thread.sleep(500); // Let the user actually see something!

		System.out.println("Curent page: " + driver.getCurrentUrl());
		System.out.println("Type Email: Test1111@test.com");

		//TODO: If the page is Cookie, then clicking Cookie page first to avoid ElementClickInterceptedException
		//
		// If ask Cookie? Then ElementClickInterceptedException will occured. Otherwise is ok
		// org.openqa.selenium.ElementClickInterceptedException: element click
		// intercepted:
		// Element <input type="text" class="inputtext _55r1 _6luy" name="email"
		// id="email"
		// data-testid="royal_email" placeholder="E-Mail-Adresse oder Telefonnummer"
		// autofocus="1"
		// aria-label="E-Mail-Adresse oder Telefonnummer"> is not clickable at point
		// (781, 173).
		// Other element would receive the click: <p>...</p>
		try {
			driver.findElement(By.id("email")).click();
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("Test1111@test.com");
			System.out.println("sendKeys OK.");

			Thread.sleep(5000); // Let the user actually see something!

			System.out.println("Type Password: dummy");
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys("dummy");
			driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
			System.out.println("sendKeys OK.");
			
		} catch (ElementClickInterceptedException e) {
			System.out.println("ElementClickInterceptedException occured: " + e.getMessage());
		}

		Thread.sleep(50000); // Let the user actually see something!

	}

}
