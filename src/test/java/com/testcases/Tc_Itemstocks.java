package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Page_Itemstocks;
import com.pages.Page_login;

import base.Baseclass;

public class Tc_Itemstocks {
	
	Baseclass bc = new Baseclass();
	Page_login pl = new Page_login(bc.getdriver());
	Page_Itemstocks pis = new Page_Itemstocks(bc.getdriver());
	
	@BeforeTest
    public void Url_launch() throws IOException, InterruptedException {
    	
    	bc.setUp();
    	pl.loginTest();
    }

    @Test
    public void Items() throws InterruptedException {
    	
    	pis.Add_Itemstocks();
    	pis.Edit_Itemstocks();
    	pis.Searchanddelete_Itemstock();
    	pis.Delete_Validation();
    	
    	
    }
    @AfterTest
    public void browser_close() {
    	
    	bc.tearDown();
    }
    
    
    
    
}
