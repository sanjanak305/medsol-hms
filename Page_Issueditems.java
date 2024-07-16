package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

public class Page_Issueditems extends Baseclass {
	
	public Page_Issueditems(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void Add_Issueditems() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("inventories"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("issued-items-page"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("new-issued-item"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-usertype"))).click();
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.xpath(loc.getProperty("new_dd-input-usertype")));
		a.click();
		a.sendKeys(data.getProperty("usertype_name"));
		a.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-issuetype"))).click();
		Thread.sleep(1000);
		WebElement b = driver.findElement(By.xpath(loc.getProperty("dd-input-issuetype")));
		b.click();
		b.sendKeys(data.getProperty("issue_to"));
		b.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("issueby"))).sendKeys(data.getProperty("issue_by"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("issuedate"))).click();
		WebElement month1 = driver.findElement(By.xpath(loc.getProperty("month1_ii")));
		Select m = new Select(month1);
		m.selectByVisibleText("April");
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("date_a"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("Returndate"))).click();
		Thread.sleep(1000);
		WebElement month2 = driver.findElement(By.xpath(loc.getProperty("month2_ii")));
		Select n = new Select(month2);
		n.selectByVisibleText("April");
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("date_b"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("itemcatego"))).click();
		Thread.sleep(1000);
		WebElement c = driver.findElement(By.xpath(loc.getProperty("input-itemcateg0")));
		c.click();
		c.sendKeys(data.getProperty("itemca_name_ii"));
		c.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-itemmm"))).click();
		Thread.sleep(1000);
		WebElement d = driver.findElement(By.xpath(loc.getProperty("dd-input-itemmm")));
		d.click();
		d.sendKeys(data.getProperty("item_ii"));
		d.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("quantity1"))).sendKeys(data.getProperty("quantity_ii"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("description-2"))).sendKeys(data.getProperty("description_ii"));
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		WebElement xyz = driver.findElement(By.xpath(loc.getProperty("save-issueditem")));
		act.moveToElement(xyz).click().build().perform();
		Thread.sleep(1000);
		
	}
	public void Filter_Issueditems() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("filter_icon"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("dd-filter"))).click();
		Thread.sleep(1000);
		WebElement g = driver.findElement(By.xpath(loc.getProperty("dd-input-filter")));
		g.click();
		g.sendKeys(Keys.ARROW_DOWN);
		g.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	
	}
	
	public void Search_delete_Issueditems() throws InterruptedException 
	
	{
		WebElement h = driver.findElement(By.xpath(loc.getProperty("searchissueditem")));
        h.click();
        h.sendKeys(data.getProperty("item_ii"));
        h.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("delete-issueditem"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("yes-delete-issueditem"))).click();	
		
	}
	public void Delete_Validation() throws InterruptedException 
	{
		driver.findElement(By.xpath(loc.getProperty("issued-items-page"))).click();
		By x = By.xpath(loc.getProperty("search_bg"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
		WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		// z.click();
		
		Thread.sleep(1000);
		
		WebElement d1w = driver.findElement(By.xpath(loc.getProperty("searchissueditem")));
		d1w.click();
		d1w.clear();
		d1w.sendKeys(data.getProperty("item_ii"));
		d1w.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);		
		WebElement d2w = driver.findElement(By.xpath(loc.getProperty("Table")));
		String f = d2w.getText();
		
		String c = "No data available in table" ;
	
		{
		if(f.contains(c))
		{
			System.out.println("the Issued Item has been  deleted");
		}
		else 
			System.out.println("the Issued Item is not deleted");
		}
	
	
	}
	
	

}
