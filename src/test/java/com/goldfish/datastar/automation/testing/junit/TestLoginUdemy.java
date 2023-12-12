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

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestLoginUdemy extends AbstractChromeWebDriverTest {

	@Test
	public void testFacebookLogin() throws Exception {

		driver.get("https://www.udemy.com/");
		// driver.manage().window().setSize(new Dimension(1209, 785));

		Thread.sleep(5000);
		System.out.println("sleep-1 5000 > View Udemy Home Page: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://www.udemy.com/");

		Thread.sleep(5000);
		System.out.println("sleep-2 5000 > click OK Button");
		WebElement oKButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
		System.out.println("sleep-3 5000 > View Current Page: " + driver.getCurrentUrl());
		oKButton.click();
		
		// Log in HTML
		// <a data-purpose="header-login"
		// href="https://www.udemy.com/join/login-popup/?locale=en_US&amp;
		// response_type=html&amp;next=https%3A%2F%2Fwww.udemy.com%2F" "
		// + "class="ud-btn ud-btn-medium ud-btn-secondary ud-heading-sm">"
		// + "<span>Log in</span></a>
		System.out.println("sleep-3 5000 > click Log in");
		driver.findElement(By.cssSelector("a[href*='www.udemy.com']")).click();

		Thread.sleep(5000);
		System.out.println("sleep-4 5000 > View Udemy Teaching Page: " + driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://www.udemy.com/teaching/?ref=teach_home-body");

		//driver.findElement(By.linkText("Log in")).click();
		System.out.println("sleep-3 5000 > click Log in");
		driver.findElement(By.cssSelector("a[href*='https://www.udemy.com/join/login-popup/']")).click();
		
		// TODO: If the page contains security information like German message as below:
		// ...www.udemy.com muss die Sicherheit Ihrer Verbindung überprüfen...
		//
		// https://www.udemy.com/teaching/?ref=teach_home-body www.udemy.com
		// Es wird geprüft, ob die Site-Verbindung sicher ist www.udemy.com muss die
		// Sicherheit Ihrer Verbindung überprüfen, bevor Sie fortfahren können.
		Thread.sleep(5000);
		System.out.println("sleep-5 5000 > type UserId: charles.duong@testch.com");

		driver.findElement(By.id("form-group--1")).sendKeys("charles.duong@testch.com");
		/*
		 * driver.findElement(By.id("form-group--3")).sendKeys("test");
		 * driver.findElement(By.id("form-group--1")).click();
		 * driver.findElement(By.id("form-group--3")).click();
		 */

		Thread.sleep(50000);
		System.out.println("sleep-6 5000 > type Passord: test");

//		driver.findElement(By.cssSelector(".ud-btn-link use")).click();
//		driver.findElement(By.cssSelector(".ud-component--auth--app")).click();
		driver.findElement(By.id("form-group--3")).sendKeys("test");

		Thread.sleep(50000);
		System.out.println("sleep-7 5000 > Click Summit");
		driver.findElement(By.cssSelector(".ud-btn-brand")).click();

		Thread.sleep(5000); // Let the user actually see something!

	}

}
