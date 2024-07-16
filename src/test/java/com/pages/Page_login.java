package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Baseclass;

public class Page_login extends Baseclass {
	
	public Page_login(WebDriver driver) {
		
		this.driver = driver;
	}

	public void LoginTest() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(prop.getProperty("username"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("login_btn"))).click();
		Thread.sleep(1500);
	}
	
	public void Home_validation() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement db = driver.findElement(By.xpath(loc.getProperty("dashboard")));
		if(db.isDisplayed()) {
			System.out.println("LANDED ON THE HOME PAGE");
		}
	}
}
