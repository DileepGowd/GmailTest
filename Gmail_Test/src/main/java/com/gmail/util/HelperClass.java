package com.gmail.util;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class HelperClass extends Base {

	static WebDriver driver;

	static JavascriptExecutor js;

	static Properties param;

	public HelperClass(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public static Properties readParam() throws Exception {
		param = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/gmail/util/Gmail.properties");
		param.load(fis);
		System.out.println("Properties file loaded...");
		return param;
	}

	public static void clearElement(By locator) {
		driver.findElement(locator).clear();
	}

	public static void enterWebElement(By locator, String data) {
		driver.findElement(locator).sendKeys(data);
		System.out.println(data + " is entered..!");
	}

	public static void successReport(String msg) {
		test.log(LogStatus.PASS, msg);
		extent.flush();
	}

	public static void enterWhenVisible(By locator, int timeout, String data) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		// waiting until the webelement located with in the specified time @param
		// timeout and assign to element variable
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// to enter the data into text field
		element.sendKeys(data);
		element = null;
	}

	public static void failureReport(String msg) {

		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		// ExtentTestManager.getTest().log(LogStatus.FAIL,"Test
		// Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		test.log(LogStatus.FAIL, test.addBase64ScreenShot(base64Screenshot));
		test.log(LogStatus.FAIL, msg);
		extent.flush();

	}

	public static void logInfo(String msg) {
		test.log(LogStatus.INFO, msg);
		extent.flush();
	}

	public static void logInfo(String methodName, String msg) {
		test = extent.startTest(methodName);
		test.log(LogStatus.INFO, msg);
		extent.flush();
	}

	public static void clickWebElement(By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isEnabled()) {
			element.click();
			element = null;
		} else {
			System.out.println(locator.toString() + " Element is not clickable..! ");
		}
	}

	public static void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		element = null;

	}

	public static void clickPerticularValue(By locator, String element) {
		List<WebElement> list = driver.findElements(locator);
		for (WebElement ele : list) {
			if (ele.getText().equals(element)) {
				ele.click();
				break;
			}
		}
	}

	public static void waitDissappearOfLoader(By locator, int timeout) {
		Boolean flag = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		System.out.println("Loader is dissappear or not ? " + flag);
	}

}
