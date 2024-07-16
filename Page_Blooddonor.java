package com.pages;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Baseclass;

public class Page_Blooddonor extends Baseclass {

	public Page_Blooddonor(WebDriver driver) {
		this.driver = driver;
	}

	public void Add_blooddonor() throws InterruptedException {

		By x = By.xpath("//span[text()='Blood Banks']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement y = wait.until(ExpectedConditions.elementToBeClickable(x));
		y.click();
		// driver.findElement(By.xpath(loc.getProperty("Bloodbank"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("Blooddonor_page"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("New_Blooddonor"))).click();
		Thread.sleep(1000);
		WebElement sbw = driver.findElement(By.xpath(loc.getProperty("Blooddonor_name")));
		String aa = data.getProperty("donor_name");
		sbw.sendKeys(aa + UUID.randomUUID().toString());
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("Blooddonor_age"))).sendKeys(data.getProperty("donor_age"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("bd_gender_male"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("DD-bloodgroup"))).click();
		Thread.sleep(1000);
		WebElement abc = driver.findElement(By.xpath(loc.getProperty("DD-enterbg")));
		abc.click();

		abc.sendKeys(data.getProperty("enter_bg"));
		abc.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("calender"))).click();
		WebElement month = driver.findElement(By.xpath(loc.getProperty("month")));
		Select m = new Select(month);
		m.selectByVisibleText("April");
		Thread.sleep(2000);

		driver.findElement(By.xpath(loc.getProperty("date"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("savenew_blooddonor"))).click();
		Thread.sleep(2000);
	}

	public void Edit_Blooddonor() {

		driver.findElement(By.xpath(loc.getProperty("edit-bd"))).click();
		WebElement p = driver.findElement(By.xpath(loc.getProperty("edit-name")));
		p.click();
		p.clear();
		String aa = data.getProperty("edit_bd_name");
		p.sendKeys(aa + UUID.randomUUID().toString());

		WebElement q = driver.findElement(By.xpath(loc.getProperty("edit-age")));
		q.click();
		q.clear();
		q.sendKeys(data.getProperty("edit_bd_age"));

		driver.findElement(By.xpath(loc.getProperty("edit-gender-female"))).click();
		driver.findElement(By.xpath(loc.getProperty("edit-bd-save"))).click();

	}

	public void Search_Blooddonor() throws InterruptedException {

		WebElement aa = driver.findElement(By.xpath(loc.getProperty("search_bd")));
		aa.click();
		aa.sendKeys(data.getProperty("edit_bd_name"));
		aa.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(loc.getProperty("delete_bd"))).click();
		driver.findElement(By.xpath(loc.getProperty("yes_delete_bd"))).click();

	}

	public void Delete_Validation() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("Blooddonor_page"))).click();
		By x = By.xpath(loc.getProperty("search_bg"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement z = wait.until(ExpectedConditions.visibilityOfElementLocated(x));
		// z.click();

		Thread.sleep(1000);

		WebElement c1w = driver.findElement(By.xpath(loc.getProperty("search_bd")));
		c1w.click();
		c1w.clear();
		c1w.sendKeys(data.getProperty("edit_bd_name"));
		c1w.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		WebElement c2w = driver.findElement(By.xpath(loc.getProperty("Table")));
		String f = c2w.getText();

		String c = "No data available in table";

		{
			if (f.contains(c)) {
				System.out.println("the blood donor has been  deleted");
			} else
				System.out.println("the blood donor is not deleted");
		}

	}
}
