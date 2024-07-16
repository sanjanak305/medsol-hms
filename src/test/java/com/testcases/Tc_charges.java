package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_charges;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_charges extends Baseclass{
	
	Baseclass base = new Baseclass();
	Page_login pl = new Page_login(base.getdriver());
	Page_charges pc = new Page_charges(base.getdriver());
	
	@BeforeTest
	public void url_launch() throws IOException, InterruptedException {
		
		base.setUp();
		pl.LoginTest();
		
	}
	
	@Test(priority = 1)
	public void chargesTest1() throws InterruptedException {
		
		pc.chargeTest();
		pc.new_charge();
		pc.search();
		pc.edit();
		
	}
	
	@Test(priority = 2)
	public void chargesTest2() throws InterruptedException {
		
		pc.chargeTest();
		pc.filter();
		pc.delete();
		
	}
	
	@AfterTest
	public void browser_close() {
		
		base.tearDown();
		
	}

}
