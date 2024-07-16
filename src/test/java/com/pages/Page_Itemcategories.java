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

public class Page_Itemcategories extends Baseclass {

	public Page_Itemcategories(WebDriver driver) {

		this.driver = driver;

	}

	public void Add_Itemcategories() throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("inventories"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("new-itemca"))).click();
		Thread.sleep(1000);
		WebElement scw = driver.findElement(By.xpath(loc.getProperty("itemca-name")));
		String aa = data.getProperty("name_itemca");
		scw.sendKeys(aa + UUID.randomUUID().toString());
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("save-itemca"))).click();
	}

	public void Edit_Itemcategories() throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("edit-itemca"))).click();
		Thread.sleep(1500);
		WebElement a1 = driver.findElement(By.xpath(loc.getProperty("edit-name-itemca")));
		a1.click();
		a1.clear();
		String aa = data.getProperty("it_name_itemca") ;
		a1.sendKeys(aa + UUID.randomUUID().toString());

		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("save-editeditemca"))).click();

	}

	public void Search_delete_Itemcategories() throws InterruptedException {

		WebElement b = driver.findElement(By.xpath(loc.getProperty("search-itemca")));
		b.click();
		b.sendKeys(data.getProperty("it_name_itemca"));
		b.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("delete-itemca"))).click();
		// c.click();

		driver.findElement(By.xpath(loc.getProperty("yes-delete-itemca"))).click();
	//	 driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

	/*	By x = By.xpath(loc.getProperty("search-itemca"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement y = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		y.click();  */

	}
			public void Delete_Validation() throws InterruptedException 
		{
		    driver.findElement(By.xpath(loc.getProperty("inventories"))).click();
			By x = By.xpath(loc.getProperty("search-itemca"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
			WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
			// z.click();
			
			Thread.sleep(1000);
			
			WebElement e1w = driver.findElement(By.xpath(loc.getProperty("search-itemca")));
			e1w.click();
			e1w.clear();
			e1w.sendKeys(data.getProperty("search1"));
			e1w.sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);		
			WebElement e2w = driver.findElement(By.xpath(loc.getProperty("Table")));
			String f = e2w.getText();
			
			String c = "No data available in table" ;
		
			{
			if(f.contains(c))
			{
				System.out.println("the Item categories has been  deleted");
			}
			else 
				System.out.println("the Item categories is not deleted");
			}
		}

}
