package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Bloodbank;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Bloodgroup {
	
	Baseclass bc = new Baseclass() ;
	Page_login pl = new Page_login(bc.getdriver()) ;
	Page_Bloodbank bb = new Page_Bloodbank(bc.getdriver());


	
	@BeforeTest
	public void url_launch() throws IOException, InterruptedException {
		
		bc.setUp();
		pl.loginTest();
	}
	
	@Test
	public void Addbg() throws InterruptedException {
		
		bb.Add_Bloodgroup();
		bb.Edit_Bloodgroup();
		bb.Search_Bloodgroup();
		bb.Delete_Validation();
	}
	
	@AfterTest
	public void browser_close() {
		
		bc.tearDown();
	}
	

}
	
		
		
	


