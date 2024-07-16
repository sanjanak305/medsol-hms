package utilities;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pages.Page_admins;
import com.pages.Page_login;

import base.Baseclass;

public class DatePickerDemo extends Baseclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Baseclass b = new Baseclass();
		Page_login p = new Page_login(b.getdriver());
		Page_admins p2 = new Page_admins(b.getdriver());
		
//		String date=(prop.getProperty("new_admin_DOB"));
		
//		String DOB[] = date.split("-");
//		String year=DOB[0];
//		String month= DOB[1];
//		String day=DOB[2];
//		System.out.println(year+"-"+month+"-"+day);
//		
		String year = "1993";
		String month = "May";
		String day = "30";
		
		b.setUp();
		p.LoginTest();
		p2.adminTest();
		
		driver.findElement(By.xpath(loc.getProperty("new_admin"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("firstname"))).sendKeys(prop.getProperty("new_admin_firstname"));
		driver.findElement(By.xpath(loc.getProperty("lastname"))).sendKeys(prop.getProperty("new_admin_lastname"));
		driver.findElement(By.xpath(loc.getProperty("new_email"))).sendKeys(prop.getProperty("new_admin_email"));
		driver.findElement(By.xpath(loc.getProperty("new_password"))).sendKeys(prop.getProperty("new_admin_password"));
		driver.findElement(By.xpath(loc.getProperty("confirm_password")))
				.sendKeys(prop.getProperty("new_admin_password"));
		
		List<WebElement> gender_opt_radio = driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(int i=0;i<gender_opt_radio.size();i++) {
			WebElement gender_opt = gender_opt_radio.get(i);
			String gender = gender_opt.getAttribute("value");
			if (gender.equalsIgnoreCase(prop.getProperty("new_gender"))) {
				gender_opt.click();
				System.out.println("gender clicked is "+ gender+" [0-->male 1-->female]");
				System.out.println("gender added is-->"+ prop.getProperty("new_gender")+" [0-->male 1-->female]" );
				Thread.sleep(1000);
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='adminBirthDate']")).click();
		
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).clear();
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).sendKeys(year);
		
		driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']")).click();
		WebElement monthDD = driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']"));
		Select dd = new Select(monthDD);
		dd.selectByVisibleText(month);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[@class='flatpickr-day'])["+day+"]")).click();
		Thread.sleep(3000); 	
		
//		String YearDisplayed = driver.findElement(By.xpath("//input[@class='numInput cur-year']")).getText();
//		System.out.println(YearDisplayed);
//		while(true) {
//			
//			YearDisplayed = driver.findElement(By.xpath("//input[@class='numInput cur-year']")).getText();
//			if(YearDisplayed.equals(year))
//				break;
//			else
//				driver.findElement(By.xpath("//span[@class='arrowDown']")).click();
//		}
//		String monthDisplayed = monthDD.getText();
//		System.out.println(monthDisplayed);
//		String dateDisplayed= driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText();
//		System.out.println(dateDisplayed);
		
		
		
//		Actions act = new Actions(driver);
//		WebElement x = driver.findElement(By.xpath(loc.getProperty("save")));
//		act.moveToElement(x).click(x).build().perform();	
			
	driver.close();	
	}
	

}
