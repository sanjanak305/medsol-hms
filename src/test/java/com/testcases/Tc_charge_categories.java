package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_charge_categories;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_charge_categories extends Baseclass {
	
	Baseclass base = new Baseclass();
	Page_login pl = new Page_login(base.getdriver());
	Page_charge_categories pc = new Page_charge_categories(base.getdriver());
	
	@BeforeTest
	public void url_launch() throws IOException, InterruptedException {
		
		base.setUp();
		pl.LoginTest();
		
	}
	
	@Test
	public void charge_categories_test() throws InterruptedException {
		
		pc.charge_categoriesTest();
		pc.new_charge_category();
		pc.search();
		pc.edit();
		pc.delete_cancel();
		pc.delete();
		
	}
	
	@AfterTest
	public void browser_close() {
		
		base.tearDown();
	}

}
