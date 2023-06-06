package com.orangeHRM.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.orangeHRM.reports.Report;
import com.orangeHRM.utils.Util;

public class BaseClass {
	public WebDriver driver;
	public static ExtentTest report;

	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeMethod
	public void beforeMethod() {
		report = Report.startReport(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html", "LoginValidations", "");
		Report.passTest("*********** Execution starts **************");
		launchApplication(Util.readProperty("browser"));
		
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		Report.infoTest("************** Execution completed *************");
		Report.getReporter(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html").flush();
	}

	@AfterSuite
	public void afterSuite() {

	}

	public void launchApplication(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Util.readProperty("url"));
		Report.infoTest("Browser : "+ browser +", application : "+Util.readProperty("url")+" succesfully launched!!!!");
	}

}
