package com.pages;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import base.Baseclass;

public class Page_admins extends Baseclass {
	public Page_admins(WebDriver driver) {
		this.driver = driver;
	}

	public void adminTest() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("admin"))).click();
		Thread.sleep(1000);
		WebElement ad = driver.findElement(By.xpath(loc.getProperty("admin_page")));
		if (ad.isDisplayed()) {
			System.out.println("SUCCESSFULLY LANDED ON ADMINS PAGE");
		}
	}

	public void search() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public void new_admin() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("new_admin"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("firstname"))).sendKeys(data.getProperty("new_admin_firstname"));
		driver.findElement(By.xpath(loc.getProperty("lastname"))).sendKeys(data.getProperty("new_admin_lastname"));
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("new_email")));
		String email = data.getProperty("new_admin_email");
		ele.sendKeys(UUID.randomUUID().toString() + email );
		driver.findElement(By.xpath(loc.getProperty("new_password"))).sendKeys(data.getProperty("new_admin_password"));
		driver.findElement(By.xpath(loc.getProperty("confirm_password")))
				.sendKeys(data.getProperty("new_admin_password"));
		
//		List<WebElement> gender_opt_radio = driver.findElements(By.xpath(loc.getProperty("gender_radio_btn")));
//		
//		for(int i=0;i<gender_opt_radio.size();i++) {
//			WebElement gender_opt = gender_opt_radio.get(i);
//			String gender = gender_opt.getAttribute("value");
//			if (gender.equalsIgnoreCase(prop.getProperty("new_gender"))) {
//				gender_opt.click();
//				System.out.println("gender clicked is "+ gender+" [0-->male 1-->female]");
//				
//				System.out.println("gender added is "+ prop.getProperty("new_gender")+" [0-->male 1-->female]");
//				Thread.sleep(1000);
//				break;
//			}
//		}
		if(data.getProperty("new_gender").equalsIgnoreCase("0")) {
			driver.findElement(By.xpath(loc.getProperty("new_gender_male"))).click();
		}
		else if(data.getProperty("new_gender").equalsIgnoreCase("1")) {
			driver.findElement(By.xpath(loc.getProperty("new_gender_female"))).click();
		}
		
		String year = "1993";String month = "May";String day = "30";
		driver.findElement(By.xpath(loc.getProperty("new_DOB"))).click();
		
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).clear();
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).sendKeys(year);
		
		driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']")).click();
		WebElement monthDD = driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']"));
		Select dd = new Select(monthDD);
		dd.selectByVisibleText(month);
		
		driver.findElement(By.xpath("(//span[@class='flatpickr-day'])["+day+"]")).click();
		
		Actions act = new Actions(driver);
		WebElement x = driver.findElement(By.xpath(loc.getProperty("save")));
		act.moveToElement(x).click(x).build().perform();

	}
	
	public void filter() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(By.xpath(loc.getProperty("filter"))).click();
		driver.findElement(By.xpath(loc.getProperty("filter_search"))).click();
		Thread.sleep(1000);
		WebElement dd = driver.findElement(By.xpath(loc.getProperty("filter_input")));
		for(int i=0; i<3;i++) {
			dd.sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		dd.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("filter"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("filter"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("reset"))).click();
			
	}

	public void edit() throws InterruptedException {
	
		driver.findElement(By.xpath(loc.getProperty("new_record"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(loc.getProperty("edit"))).click();
		driver.findElement(By.xpath(loc.getProperty("firstname"))).clear();
		driver.findElement(By.xpath(loc.getProperty("firstname"))).sendKeys(data.getProperty("edit_admin_firstname"));
		driver.findElement(By.xpath(loc.getProperty("lastname"))).clear();
		driver.findElement(By.xpath(loc.getProperty("lastname"))).sendKeys(data.getProperty("edit_admin_lastname"));
		driver.findElement(By.xpath(loc.getProperty("edit_email"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_email"))).sendKeys(data.getProperty("edit_admin_email"));
		driver.findElement(By.xpath(loc.getProperty("phone"))).clear();
		driver.findElement(By.xpath(loc.getProperty("phone"))).sendKeys(data.getProperty("edit_phone"));
		
	/*	WebElement ele1 = driver.findElement(By.xpath("//input[@id='editAdminGenderMale']"));
		WebElement ele2 = driver.findElement(By.xpath("//input[@id='editAdminGenderFemale']"));
		if(ele1.isSelected()) {
			//if (prop.getProperty("edit_gender").equalsIgnoreCase("0")) {
			//	By x = By.xpath("//input[@id='editAdminGenderMale']");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement y = wait.until(ExpectedConditions.elementToBeClickable(ele1));
				y.click();
				// driver.findElement(By.xpath("//input[@id='editAdminGenderMale']")).click();
				//System.out.println(driver.findElement(By.xpath("//input[@id='editAdminGenderMale']")).isSelected());
			} else if (prop.getProperty("edit_gender").equalsIgnoreCase("1")) {
				By x = By.xpath("//input[@id='editAdminGenderFemale']");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement y = wait.until(ExpectedConditions.elementToBeClickable(x));
				y.click();
				// driver.findElement(By.xpath("//input[@id='editAdminGenderFemale']")).click();
				//System.out.println(driver.findElement(By.xpath("//input[@id='editAdminGenderFemale']")).isSelected());
			}              */
		
		driver.findElement(By.xpath(loc.getProperty("edit_gender_female"))).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(loc.getProperty("status_toggle"))).click();
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		WebElement x = driver.findElement(By.xpath(loc.getProperty("save")));
		act.moveToElement(x).click(x).build().perform();
		
	}
	
	public void edit_icon() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("edit_icon"))).click();
		driver.findElement(By.xpath(loc.getProperty("firstname"))).clear();
		driver.findElement(By.xpath(loc.getProperty("firstname"))).sendKeys(data.getProperty("edit_admin_firstname"));
		driver.findElement(By.xpath(loc.getProperty("lastname"))).clear();
		driver.findElement(By.xpath(loc.getProperty("lastname"))).sendKeys(data.getProperty("edit_admin_lastname"));
		driver.findElement(By.xpath(loc.getProperty("edit_email"))).clear();
		driver.findElement(By.xpath(loc.getProperty("edit_email"))).sendKeys(data.getProperty("edit_admin_email"));
		driver.findElement(By.xpath(loc.getProperty("phone"))).clear();
		driver.findElement(By.xpath(loc.getProperty("phone"))).sendKeys(data.getProperty("edit_phone"));
		
		List<WebElement> gender_opt_radio = driver.findElements(By.xpath(loc.getProperty("gender_radio_btn")));
		
		for(int i=0;i<gender_opt_radio.size();i++) {
			WebElement gender_opt = gender_opt_radio.get(i);
			String gender = gender_opt.getAttribute("value");
			if (gender.equals(data.getProperty("edit_gender"))) {
				gender_opt.click();
				//System.out.println(gender_opt.isSelected());
				System.out.println("gender clicked is "+ gender+" [0-->male 1-->female]");
				System.out.println("gender required is "+ prop.getProperty("edit_gender")+" [0-->male 1-->female]");
				Thread.sleep(1000);
				break;
			}
		}
		driver.findElement(By.xpath(loc.getProperty("status_toggle"))).click();
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		WebElement x = driver.findElement(By.xpath(loc.getProperty("save")));
		act.moveToElement(x).click(x).build().perform();
		
	}
	
	public void status_toggle() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("status"))).click();
		Thread.sleep(2000);
	}
	
	public void delete() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input"));
		driver.findElement(By.xpath(loc.getProperty("delete"))).click();
		driver.findElement(By.xpath(loc.getProperty("delete_confirm"))).click();
		//driver.findElement(By.xpath(loc.getProperty("delete_cancel"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("search"))).clear();
		driver.findElement(By.xpath(loc.getProperty("search"))).sendKeys(data.getProperty("search_input"));
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
