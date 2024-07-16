package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

public class Page_Blooddonation extends Baseclass 

{
	public Page_Blooddonation(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	public void Add_Blooddonation() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("Bloodbank"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("Blood_donations-page"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("new_Blooddonation"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("DD-Donor-name"))).click();
		Thread.sleep(1000);
		WebElement aa = driver.findElement(By.xpath(loc.getProperty("DD-enter-name")));
		aa.click();
		aa.sendKeys(data.getProperty("input_donor_name"));
		aa.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement bb = driver.findElement(By.xpath(loc.getProperty("bags")));
		bb.clear();
		bb.sendKeys(data.getProperty("enter_bags"));
		//bb.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("save-donation"))).click();
		Thread.sleep(1000);
	}
	 
	public void Edit_Blooddonation() throws InterruptedException
	
	{
		
		driver.findElement(By.xpath(loc.getProperty("edit-bdn-icon"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-edit-donorname"))).click();
		Thread.sleep(2000);
		WebElement cc = driver.findElement(By.xpath(loc.getProperty("dd-clcik-donorname")));
		cc.click();
		cc.sendKeys(data.getProperty("edit_donorname"));
		cc.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement dd =  driver.findElement(By.xpath(loc.getProperty("edit-bagdonation")));
		dd.click();
		dd.clear();
		dd.sendKeys(data.getProperty("edit_bags"));
		dd.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("edit_save-donation")));
	}

	public void Search_Blooddonation()
	
	{
		 WebElement ee = driver.findElement(By.xpath(loc.getProperty("search-bdonation")));
		 ee.click();
		 ee.sendKeys(data.getProperty("edit_donorname"));
		 ee.sendKeys(Keys.ENTER);
		 
		 driver.findElement(By.xpath(loc.getProperty("delete-bdonation"))).click();
		 driver.findElement(By.xpath(loc.getProperty("yes-deletebdonation"))).click();
	}
	public void Delete_Validation() throws InterruptedException 
	{
	
	  //  driver.findElement(By.xpath(loc.getProperty("Blood_donations-page"))).click();
		By x = By.xpath(loc.getProperty("search-bdonation"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
		WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		z.click();
		
		Thread.sleep(1000);
		
		WebElement b1w = driver.findElement(By.xpath(loc.getProperty("search-bdonation")));
		
		b1w.clear();
		b1w.sendKeys(data.getProperty("edit_donorname"));
		b1w.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);		
		WebElement b2w = driver.findElement(By.xpath(loc.getProperty("Table")));
		String f = b2w.getText();
		
		String c = "No data available in table" ;
	
		
		if(f.contains(c))
		{
			System.out.println("the blood donation has been  deleted");
		}
		else 
			System.out.println("the blood donation is not deleted");
		}
	
}
