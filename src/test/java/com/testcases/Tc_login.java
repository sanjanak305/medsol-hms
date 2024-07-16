package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_login;

import base.Baseclass;

public class Tc_login {

	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());

	@BeforeTest
	public void url_launch() throws IOException {

		bc.setUp();
	}

	@Test
	public void login() throws InterruptedException {
		
		pl.LoginTest();
		pl.Home_validation();
	}

	@AfterTest
	public void browser_close() {
		
		bc.tearDown();
	}

}
