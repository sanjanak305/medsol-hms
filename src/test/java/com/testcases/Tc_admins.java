package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_admins;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_admins {
	
	Baseclass bc = new Baseclass();
	Page_admins pa = new Page_admins(bc.getdriver());
	Page_login pl = new Page_login(bc.getdriver());
	
	@BeforeTest
	public void url_launch() throws IOException, InterruptedException {
		bc.setUp();
		pl.LoginTest();
	}
	
	
	@Test
	public void adminTest1() throws InterruptedException {
		pa.adminTest();
		pa.new_admin();
		pa.edit();
		pa.search();
		pa.edit_icon();	
	}
	
	
	@Test
	public void adminTest2() throws InterruptedException {
		pa.adminTest();
		pa.delete();
		pa.filter();
		pa.status_toggle();
		pa.search();
		//pa.delete();
		
	}
	
	@AfterTest
	public void browser_close() {
		
		bc.tearDown();
	}
	

}
