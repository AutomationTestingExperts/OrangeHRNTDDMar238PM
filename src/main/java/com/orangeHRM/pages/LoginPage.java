package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.config.BaseClass;
import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class LoginPage {
	String expTitle = "OrangeHRM";
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
/*	@FindBy(name="username")
	WebElement input_UserName;*/
	
	By input_userNAme = By.name("username");
	By input_passWord = By.name("password");
	By btn_Login = By.xpath("//button[@type='submit']");
	
	public void isPageOpened() {
		String actTtile = driver.getTitle();
		Util.hardWait(2);
		if(actTtile.equalsIgnoreCase(expTitle)) {
			
			Report.passTest(driver, "Login page launched succefully!!!!!!!!!!!");
		}else {
			Report.failTest(driver, "Login page not launched as expected!!!!!!!!!!!");
		}
	}
	
	public void logIntoPage(String userName, String password) {
		Util.sendKeys(driver, input_userNAme, userName, "Username");
		Util.sendKeys(driver, input_passWord, password, "Password");
		Util.click(driver, btn_Login, "Login");
	}

}
