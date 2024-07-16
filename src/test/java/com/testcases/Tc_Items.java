package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Items;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Items {

	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());
	Page_Items pi = new Page_Items(bc.getdriver()); 
	
	@BeforeTest
	public void Url_Launch() throws IOException, InterruptedException {
		
		bc.setUp();
		pl.loginTest();
	}
	@Test
	public void Items() throws InterruptedException {
		
		pi.Add_Items();
		pi.Edit_Items();
		pi.Search_delete_Items();
		pi.Delete_Validation();
	}
	@AfterTest
	public void Browser_close() {
		
		bc.tearDown();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
