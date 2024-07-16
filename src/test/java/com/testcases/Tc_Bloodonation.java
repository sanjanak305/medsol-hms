package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Blooddonation;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Bloodonation {
	
	Baseclass bc = new Baseclass() ;
	Page_login pl = new Page_login(bc.getdriver());
	Page_Blooddonation pbd = new Page_Blooddonation(bc.getdriver());

	
	@BeforeTest
	public void url_launch( ) throws IOException, InterruptedException 
	
	{	
		bc.setUp();
		pl.loginTest();
	}
	

	@Test
	public void Add_donation( ) throws InterruptedException 
	
	{	
		pbd.Add_Blooddonation();
		pbd.Edit_Blooddonation();
		pbd.Search_Blooddonation();
		pbd.Delete_Validation();
	}
	
	@AfterTest
	public void Browser_close() 
	{	
		bc.tearDown();
	}
}
