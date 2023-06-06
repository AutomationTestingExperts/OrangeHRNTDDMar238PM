package com.orangeHRM.testCases;

import org.testng.annotations.Test;

import com.orangeHRM.config.BaseClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.Util;

public class Test_LoginFunctionality extends BaseClass {
	
	
	@Test
	public void validateLoginPage() {
		LoginPage login = new LoginPage(driver);
		login.isPageOpened();
		login.logIntoPage(Util.readProperty("username"), Util.readProperty("password"));
		HomePage home = new HomePage(driver);
		home.isPageOpened();
		home.laogoutOfAPplication();
		login.isPageOpened();
	}

}
