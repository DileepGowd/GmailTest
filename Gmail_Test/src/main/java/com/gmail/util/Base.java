package com.gmail.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gmail.extentReports.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base extends ExtentManager {

	public static WebDriver driver;

	public static JavascriptExecutor js;

	public static ExtentReports extent;

	public static ExtentTest test;

	public static Properties param;

	@BeforeTest
	public void loadBrowser() throws Exception {
		try {
			System.out.println("param1");
			param = HelperClass.readParam();
		} catch (FileNotFoundException fnd) {
			System.out.println("Properties does not exist in the path");
			throw (fnd);
		} catch (IOException io) {
			System.out.println("Unable to read properties file");
			throw (io);
		}
		if (param.getProperty("browser").equalsIgnoreCase("Chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/BrowserDrivers/"
						+ param.getProperty("os") + "/chromedriver");

				ChromeOptions options = new ChromeOptions();
				// options.addArguments("--disable-gpu");
				// '--disable-gpu'
				options.addArguments("--headless");

				// ptions.addArguments("--window-size=1920,1080");
				options.addArguments("--window-size=1920,1080");

				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, options);

				// set performance logger
				// this sends Network.enable to chromedriver
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
				cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				cap.setAcceptInsecureCerts(true);

				// driver = new ChromeDriver(cap);
				driver = new ChromeDriver();

				System.out.println("Chrome Driver loaded successfully.");
			} catch (WebDriverException wde) {
				System.out.println("Chrome driver cannot be instantiated" + wde.toString());
				throw (wde);
			} catch (Exception ce) {
				System.out.println("Chrome driver instance failed" + ce.toString());
				throw (ce);
			}
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(param.getProperty("siteURL"));
	}

	@BeforeSuite
	public void begin() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReportResults.html", true);

	}

	// @AfterSuite
	public void tearDown() {
		driver.close();
		driver = null;
		param = null;

	}

}
