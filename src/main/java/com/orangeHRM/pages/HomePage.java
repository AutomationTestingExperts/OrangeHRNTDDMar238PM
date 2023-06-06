package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class HomePage {
	String expTitle = "Dashboard";
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By title = By.xpath("//h6");
	By menu = By.xpath("//span[@class='oxd-userdropdown-tab']");
	By lnk_Logout = By.linkText("Logout");
	
	
	public void isPageOpened() {
		String actTtile = Util.getText(driver, title) ;
		Util.hardWait(2);
		if(actTtile.equalsIgnoreCase(expTitle)) {
			Report.passTest(driver, "Succesfully logged in!!!!!!!!!!!");
		}else {
			Report.failTest(driver, "Login failed!!!!!!!!!!!");
			System.out.println("Small change");
		}
	}
	
	public void laogoutOfAPplication() {
		Util.click(driver, menu, "Menu");
		Util.click(driver, lnk_Logout, "Logout");
	}
	
	
	
	

}
