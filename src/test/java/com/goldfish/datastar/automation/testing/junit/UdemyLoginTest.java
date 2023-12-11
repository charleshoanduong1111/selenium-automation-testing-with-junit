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
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class UdemyLoginTest extends AbstractChromeWebDriverTest {

	@Test
	public void testFacebookLogin() throws Exception {

		// Thread.sleep(50000); //
//		driver.get("https://de-de.facebook.com");
//		Thread.sleep(50000); // Let the user actually see something!
//		driver.quit();

		driver.get("https://www.udemy.com/");
		// driver.manage().window().setSize(new Dimension(1209, 785));

		// Log in HTML
		// <a data-purpose="header-login"
		// href="https://www.udemy.com/join/login-popup/?locale=en_US&amp;
		// response_type=html&amp;next=https%3A%2F%2Fwww.udemy.com%2F" "
		// + "class="ud-btn ud-btn-medium ud-btn-secondary ud-heading-sm">"
		// + "<span>Log in</span></a>
		
		Thread.sleep(5000);
		System.out.println("sleep-1 5000 > click Log in");
		driver.findElement(By.cssSelector("a[href*='www.udemy.com']")).click();

		// https://www.udemy.com/teaching/?ref=teach_home-body
		// www.udemy.com
		// Es wird geprüft, ob die Site-Verbindung sicher ist
		// www.udemy.com muss die Sicherheit Ihrer Verbindung überprüfen, bevor Sie
		// fortfahren können.
		// assertEquals(driver.getCurrentUrl(),
		// "https://www.udemy.com/teaching/?ref=teach_home-body");
		
		Thread.sleep(5000);
		System.out.println("sleep-2 5000 > Switch to Security Page: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://www.udemy.com/teaching/?ref=teach_home-body");

		Thread.sleep(5000);
		if (driver.getCurrentUrl().endsWith("?ref=teach_home-body")) {
			System.out.println("sleep-3 5000 > Switch to Security Page and can not test Email and Password: "
					+ driver.getCurrentUrl());
		} else {
			System.out.println("sleep-3 5000 > Switch to Teaching Home Page: " + driver.getCurrentUrl());

			Thread.sleep(50000);

			System.out.println("sleep-4 5000 > type UserId: charles.duong@testch.com");

			driver.findElement(By.id("form-group--1")).sendKeys("charles.duong@testch.com");
			driver.findElement(By.id("form-group--3")).sendKeys("test");
			driver.findElement(By.id("form-group--1")).click();
			driver.findElement(By.id("form-group--3")).click();

			Thread.sleep(50000);
			System.out.println("sleep-5 5000 > type Passord: test");

			driver.findElement(By.cssSelector(".ud-btn-link use")).click();
			driver.findElement(By.cssSelector(".ud-component--auth--app")).click();
			driver.findElement(By.id("form-group--3")).sendKeys("test");

			Thread.sleep(50000);
			System.out.println("sleep-6 5000 > Click Summit");
			driver.findElement(By.cssSelector(".ud-btn-brand")).click();

			Thread.sleep(5000); // Let the user actually see something!
		}

	}

}
