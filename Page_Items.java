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

public class Page_Items extends Baseclass {

	public Page_Items(WebDriver driver) {

		this.driver = driver;

	}

	public void Add_Items() throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("inventories"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("items-page"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("new-item"))).click();
		Thread.sleep(1000);
	   WebElement sdw =	driver.findElement(By.xpath(loc.getProperty("item-name")));
		String aa = data.getProperty("new_item_name");
		sdw.sendKeys(aa + UUID.randomUUID().toString());
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-itemca"))).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath(loc.getProperty("dd-add-itemca")));
		a.click();
		a.sendKeys(data.getProperty("dd-add-itemca_name"));
		a.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("unit"))).sendKeys(data.getProperty("add_unit"));
		driver.findElement(By.xpath(loc.getProperty("description"))).sendKeys(data.getProperty("item_description"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("save-item"))).click();

	}

	public void Edit_Items() throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("edit-item"))).click();
		Thread.sleep(1000);
		WebElement b = driver.findElement(By.xpath(loc.getProperty("edit-itemname")));
		b.click();
		b.clear();
		b.sendKeys(data.getProperty("edit_new_item_name"));

		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("edit-dd-itemca"))).click();
		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath(loc.getProperty("edit-dd-add-itemca")));
		c.clear();
		c.sendKeys(data.getProperty("edit_dd-add-itemca_name"));
		c.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		WebElement d = driver.findElement(By.xpath(loc.getProperty("edit-unit")));
		d.clear();
		d.sendKeys(data.getProperty("edit_add_unit"));

		Thread.sleep(1000);

		WebElement e = driver.findElement(By.xpath(loc.getProperty("edit-description")));
		e.clear();
		e.sendKeys(data.getProperty("edit_item_description"));
		Thread.sleep(1000);

		driver.findElement(By.xpath(loc.getProperty("edit-saveitem"))).click();

	}

	public void Search_delete_Items() throws InterruptedException {

		WebElement b = driver.findElement(By.xpath(loc.getProperty("search-item")));
		b.click();
		b.sendKeys(data.getProperty("edit_dd-add-itemca_name"));
		b.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath(loc.getProperty("delete-item")));
		c.click();

		driver.findElement(By.xpath(loc.getProperty("no,cancel-deleteitem"))).click();

	}
		public void Delete_Validation() throws InterruptedException 
		{
			driver.findElement(By.xpath(loc.getProperty("items-page"))).click();
			By x = By.xpath(loc.getProperty("search-item"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
			WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		//	z.click();
			
			Thread.sleep(1000);
			
			WebElement f1w = driver.findElement(By.xpath(loc.getProperty("search-item")));
			f1w.click();
			f1w.clear();
			f1w.sendKeys(data.getProperty("edit_dd-add-itemca_name"));
			f1w.sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);		
			WebElement f2w = driver.findElement(By.xpath(loc.getProperty("Table")));
			String f = f2w.getText();
			
			String c = "No data available in table" ;
		
			{
			if(f.contains(c))
			{
				System.out.println("the Item is not deleted");
			}
			else 
				System.out.println("the Item has been deleted");
			}
	}

}
