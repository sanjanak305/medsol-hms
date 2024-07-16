package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Blooddonor;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Blooddonor

{

	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());
	Page_Blooddonor bd = new Page_Blooddonor(bc.getdriver());

	@BeforeTest
	public void url_launch() throws IOException, InterruptedException {

		bc.setUp();
		pl.loginTest();

	}

	@Test
	public void Adddonor() throws InterruptedException {

		bd.Add_blooddonor();
		bd.Edit_Blooddonor();
		bd.Search_Blooddonor();
		bd.Delete_Validation();
	}
    
	@AfterTest
	public void Browser_close() {
		bc.tearDown();
	}

}
