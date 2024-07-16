package com.pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Baseclass;

public class Page_charge_categories extends Baseclass {

	public Page_charge_categories(WebDriver driver) {
		this.driver = driver;
	}
	
	public void charge_categoriesTest() throws InterruptedException{
		
		driver.findElement(By.xpath(loc.getProperty("hospital_categories"))).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("charge_categories")));
		if(ele.isDisplayed()) {
			System.out.println("SUCCESSFULLY LANDED ON CHARGE CATEGORIES PAGE");
		}
	}
	
	public void search() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_cc"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(Keys.ENTER);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void new_charge_category() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("new_charge_category"))).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("cc_input")));
		String cc = data.getProperty("cc_input");
		ele.sendKeys(cc + UUID.randomUUID().toString());
		driver.findElement(By.xpath(loc.getProperty("description"))).sendKeys(data.getProperty("description"));
		driver.findElement(By.xpath(loc.getProperty("charge_type_dd"))).click();
		WebElement x = driver.findElement(By.xpath(loc.getProperty("charge_type_dd_input")));
		for(int i = 0; i<3; i++) {
			x.sendKeys(Keys.ARROW_DOWN);
		}
		x.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("save_cc"))).click();
		Thread.sleep(2000);
		
	}
	
	public void edit() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("edit_icon"))).click();
		driver.findElement(By.xpath(loc.getProperty("edit_cc_input"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_cc_input"))).sendKeys(data.getProperty("edit_cc_input"));
		driver.findElement(By.xpath(loc.getProperty("edit_description"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_description"))).sendKeys(data.getProperty("edit_description"));
		driver.findElement(By.xpath(loc.getProperty("edit_charge_type_dd"))).click();
		WebElement x = driver.findElement(By.xpath(loc.getProperty("charge_type_dd_input")));
		for(int i = 0; i<4; i++) {
			x.sendKeys(Keys.ARROW_DOWN);
		}
		x.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("edit_save_cc"))).click();
		Thread.sleep(2000);
		
	}
	
	public void delete() throws InterruptedException {
	
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_cc"));
		driver.findElement(By.xpath(loc.getProperty("delete"))).click();
		driver.findElement(By.xpath(loc.getProperty("delete_confirm"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_cc"));
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
	
	public void delete_cancel() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_cc"));
		driver.findElement(By.xpath(loc.getProperty("delete"))).click();
		driver.findElement(By.xpath(loc.getProperty("delete_cancel"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input_cc"));
		WebElement z = driver.findElement(By.xpath(loc.getProperty("records")));
		String msg = "No data available in table";
		if((z.getText()).contains(msg)) {
			System.out.println("Record successfully deleted");
		}
		else
			System.out.println("Record not deleted");
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.navigate().refresh();
	}			
	
	
}
