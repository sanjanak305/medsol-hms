package com.pages;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

public class Page_Bloodbank extends Baseclass {

	public Page_Bloodbank(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void Add_Bloodgroup() throws InterruptedException

	{
		
		driver.findElement(By.xpath(loc.getProperty("Bloodbank"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("New_bloodgroup"))).click();
		Thread.sleep(1000);
		
		WebElement saw = driver.findElement(By.xpath(loc.getProperty("bloodgroup")));
		String aa = data.getProperty("bloodgroup") ;
		saw.sendKeys(aa + UUID.randomUUID().toString());
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("remained_bags"))).sendKeys(data.getProperty("remained_bags"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("save-new_bg"))).click();
		Thread.sleep(2000);

	}

	public void Edit_Bloodgroup()

	{
		driver.findElement(By.xpath(loc.getProperty("edit-bg-icon"))).click();
		WebElement a = driver.findElement(By.xpath(loc.getProperty("edit-bloodgroup")));
		a.clear();
		String aa = data.getProperty("edit-bloodgroup") ;
		a.sendKeys(aa + UUID.randomUUID().toString());

		WebElement b = driver.findElement(By.xpath(loc.getProperty("edit-remainedbags")));
		b.clear();
		b.sendKeys(data.getProperty("edit-remainedbags"));

		driver.findElement(By.xpath(loc.getProperty("save-edited-bg"))).click();

	}

	public void Search_Bloodgroup() throws InterruptedException

	{
		WebElement bg = driver.findElement(By.xpath(loc.getProperty("search_bg")));
		bg.click();
		bg.sendKeys(data.getProperty("search1"));
		Thread.sleep(2000);
		bg.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(loc.getProperty("delete_bg"))).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(loc.getProperty("yes_delete_bg"))).click();
		//driver.navigate().refresh();
		driver.findElement(By.xpath(loc.getProperty("no_cancelbg"))).click();
		Thread.sleep(1000);

	}
	
	public void Delete_Validation() throws InterruptedException 
	{
		By x = By.xpath(loc.getProperty("search_bg"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
		WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		z.click();
		
		Thread.sleep(1000);
		
		WebElement a1w = driver.findElement(By.xpath(loc.getProperty("search_bg")));
		a1w.click();
		a1w.clear();
		a1w.sendKeys(data.getProperty("search1"));
		a1w.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);		
		WebElement a2w = driver.findElement(By.xpath(loc.getProperty("Table")));
		String f = a2w.getText();
		
		String c = "No data available in table" ;
	
		{
		if(f.contains(c))
		{
			System.out.println("the blood group has been  deleted");
		}
		else 
			System.out.println("the blood group is not deleted");
		}
		
		
		
		
	}
	

}
