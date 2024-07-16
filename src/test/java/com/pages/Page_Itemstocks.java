package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

public class Page_Itemstocks extends Baseclass{
	
 public 	Page_Itemstocks(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Add_Itemstocks() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("inventories"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("itemstocks-page"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("new-itemstock"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("itemcate"))).click();
	    Thread.sleep(1000);
	    WebElement a = driver.findElement(By.xpath(loc.getProperty("input-itemcate")));
	    a.click();
	    a.sendKeys("syrup");
	    a.sendKeys(Keys.ENTER);
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("itemname1"))).click();
	    WebElement b = driver.findElement(By.xpath(loc.getProperty("input-itemname1"))); 
	    b.click();
	    b.sendKeys("123");
	    b.sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("suppliername"))).sendKeys("a1");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("storename"))).sendKeys("a2");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("quantity"))).sendKeys("a3");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("purchase-price"))).sendKeys("100");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(loc.getProperty("description-1"))).sendKeys("here is the new Itemstcok");
	    Thread.sleep(1000);
	   
	   WebElement is =  driver.findElement(By.xpath(loc.getProperty("save-itemstock")));
	   Actions act = new Actions(getdriver());
	    act.moveToElement(is).build().perform();
	    is.click();
	   
	}
	
	public void Edit_Itemstocks() throws InterruptedException {
		
	//	driver.findElement(By.xpath(loc.getProperty("itemstocks-page")));
		
		driver.findElement(By.xpath(loc.getProperty("edit-itemstock"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("edit-itemcate"))).click();
		Thread.sleep(1000);
		WebElement d = driver.findElement(By.xpath(loc.getProperty("edit-input-itemcate")));
		d.click();
		d.sendKeys("syrup");
		d.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("edit-itemname1"))).click();
		Thread.sleep(1000);
		WebElement e = driver.findElement(By.xpath(loc.getProperty("edit-input-itemname1")));
        e.click();
        e.sendKeys("123");
        e.sendKeys(Keys.ENTER);
        
        Thread.sleep(1000);
		WebElement f =driver.findElement(By.xpath(loc.getProperty("edit-suppliername")));
		f.click();
		f.clear();
		f.sendKeys("b1");
		Thread.sleep(1000);
		WebElement g = driver.findElement(By.xpath(loc.getProperty("edit-storename")));
		g.click();
		g.clear();
		g.sendKeys("b2");
		Thread.sleep(1000);
		WebElement h = driver.findElement(By.xpath(loc.getProperty("edit-quantity")));
		h.click();
		h.clear();
		h.sendKeys("b3");
		Thread.sleep(1000);
		WebElement i = driver.findElement(By.xpath(loc.getProperty("edit-purchase-price")));
		i.click();
		i.clear();
		i.sendKeys("200");
		Thread.sleep(1000);
		WebElement j = driver.findElement(By.xpath(loc.getProperty("edit-description-1")));
		j.click();
		j.clear();
		j.sendKeys("This is the edited new Itemstcok");
		Thread.sleep(1000);
		WebElement is1 = driver.findElement(By.xpath(loc.getProperty("edit-save-itemstock")));
		Actions act1 = new Actions(getdriver());
		act1.moveToElement(is1).build().perform();
		is1.click();
		
		
	}
	
	public void Searchanddelete_Itemstock() throws InterruptedException {
		
		WebElement k = driver.findElement(By.xpath(loc.getProperty("search-itemsto")));
		k.click();
		k.sendKeys("123");
		k.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("delete-itemstock"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("no-cancel-itemstock"))).click();
		
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
				System.out.println("the Item has been deleted");
			}
			else 
				System.out.println("the Item is not deleted");
			}
		
		
		
		
		
	}
	

}
