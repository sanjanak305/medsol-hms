package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Itemcategories;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Itemcategories {

	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());
	Page_Itemcategories pic = new Page_Itemcategories(bc.getdriver());

	@BeforeTest
	public void Url_launch() throws IOException, InterruptedException {
		bc.setUp();
		pl.loginTest();
	}

	@Test
	public void Add_Itemcategories() throws InterruptedException {

		pic.Add_Itemcategories();
		pic.Edit_Itemcategories();
		pic.Search_delete_Itemcategories();

	}

	@AfterTest
	public void browser_close() 
	{
     	bc.tearDown();
	}

}
