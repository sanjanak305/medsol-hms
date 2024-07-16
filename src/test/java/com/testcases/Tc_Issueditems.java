package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Issueditems;
import com.pages.Page_login;

import base.Baseclass;


public class Tc_Issueditems {
	
	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());
	Page_Issueditems pii = new Page_Issueditems(bc.getdriver());
	
	@BeforeTest
	public void URL_launch() throws IOException, InterruptedException {
		
		bc.setUp();
		pl.loginTest();
		
	}

	@Test
	public void Issueditems() throws InterruptedException {
		
		pii.Add_Issueditems();
		pii.Filter_Issueditems();
		pii.Search_delete_Issueditems();
		pii.Delete_Validation();
	}
	
	@AfterTest
	public void Browser_close() {
		
		bc.tearDown();
	}


}
