package com.pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Baseclass;

public class Page_charges extends Baseclass {

	public Page_charges(WebDriver driver) {
		this.driver = driver;
	}
	
	public void chargeTest() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("hospital_categories"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("charges"))).click();
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("new_charge")));
		if(ele.isDisplayed())
			System.out.println("SUCCESSFULY LANDED ON CHARGES PAGE");
		Thread.sleep(1000);
	}
	
	public void search() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_charge"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		//driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	public void new_charge() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("new_charge"))).click();
		driver.findElement(By.xpath(loc.getProperty("new_charge_type"))).click();
		WebElement x = driver.findElement(By.xpath(loc.getProperty("charge_type_dd_input")));
		for(int i=0; i<3; i++) {
			x.sendKeys(Keys.ARROW_DOWN);
		}
		x.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("charge_category"))).click();
		WebElement y = driver.findElement(By.xpath(loc.getProperty("charge_category_input")));
		y.sendKeys(Keys.ARROW_DOWN);
		y.sendKeys(Keys.ENTER);
		WebElement z = driver.findElement(By.xpath(loc.getProperty("code")));
		String code = data.getProperty("code");
		z.sendKeys(code + UUID.randomUUID().toString());
		driver.findElement(By.xpath(loc.getProperty("std_charge"))).sendKeys(data.getProperty("std_charge"));
		driver.findElement(By.xpath(loc.getProperty("description"))).sendKeys(data.getProperty("description_charge"));
		driver.findElement(By.xpath(loc.getProperty("save_charge"))).click();
		Thread.sleep(1500);
		
	}
	
	public void edit() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("edit_icon"))).click();
		driver.findElement(By.xpath(loc.getProperty("edit_charge_type"))).click();
		WebElement x = driver.findElement(By.xpath(loc.getProperty("charge_type_dd_input")));
		for(int i=0; i<4; i++) {
			x.sendKeys(Keys.ARROW_DOWN);
		}
		x.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("edit_charge_category"))).click();
		WebElement y = driver.findElement(By.xpath(loc.getProperty("charge_category_input")));
		y.sendKeys(Keys.ARROW_DOWN);
		y.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("edit_code"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_code"))).sendKeys(data.getProperty("edit_code"));
		driver.findElement(By.xpath(loc.getProperty("edit_std_charge"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_std_charge"))).sendKeys(data.getProperty("edit_std_charge"));
		driver.findElement(By.xpath(loc.getProperty("edit_dscrptn"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_dscrptn"))).sendKeys(data.getProperty("edit_dscrptn"));
		driver.findElement(By.xpath(loc.getProperty("edit_save_charge"))).click();
		Thread.sleep(1500);
		
	}
	
	public void filter() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("filter_charge"))).click();
		driver.findElement(By.xpath(loc.getProperty("filter_search"))).click();
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("filter_input")));
		for(int i=0; i<6; i++) {
			ele.sendKeys(Keys.ARROW_DOWN);
		}
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("filter_charge"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("filter_charge"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("reset"))).click();
		
	}
	
	public void delete() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_charge"));
		driver.findElement(By.xpath(loc.getProperty("delete"))).click();
		driver.findElement(By.xpath(loc.getProperty("delete_confirm"))).click();
		//driver.findElement(By.xpath(loc.getProperty("delete_cancel"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_charge"));
		WebElement z = driver.findElement(By.xpath(loc.getProperty("records")));
		String msg = "No data available in table";	
		if((z.getText()).contains(msg)) {
			System.out.println("Record successfully deleted");
		}
		else
			System.out.println("Record not deleted");
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
//		driver.findElement(By.xpath(loc.getProperty("search"))).click();
//		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		
	}
}
