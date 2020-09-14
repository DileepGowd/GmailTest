package com.gmail.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.GmailLoginPage;
import com.gmail.util.Base;
import com.gmail.util.ExcelRead;
import com.gmail.util.HelperClass;

public class GmailLoginTest extends Base {

	GmailLoginPage login;
	Base base;
	WebDriver driverTest;
	JavascriptExecutor jsTest;
	HelperClass hc;

	@BeforeClass
	public void setUp() {
		base = new Base();
		driverTest = base.driver;
		jsTest = base.js;
		login = new GmailLoginPage(driverTest, jsTest);
		hc = new HelperClass(driverTest, jsTest);
	}

	@Test(dataProvider = "TestData", dataProviderClass = ExcelRead.class, enabled = true, priority = 1)
	public void loginTest(String username, String password) throws Exception {
		HelperClass.logInfo("Login In Gmail", "Test begins...!");
		HelperClass.logInfo("Logged in with credentials: " + username + ", " + password);
		System.out.println("login started...!");
		login.enterEmailId(username);
		login.clickOnNext();
		login.enterPassword(password);
		login.clickOnNext();
	}

	@Test(dataProvider = "TestData", dataProviderClass = ExcelRead.class, enabled = false)
	public void invalidLoginTest(String username, String password) throws Exception {
		HelperClass.logInfo("Login In Gmail", "Test begins...!");
		HelperClass.logInfo("Logged in with credentials: " + username + ", " + password);
		System.out.println("login started...!");
		login.enterEmailId(username);
		login.clickOnNext();
		login.enterPassword(password);
		login.clickOnNext();
	}

	@Test(dataProvider = "TestData", dataProviderClass = ExcelRead.class, enabled = false, priority = 2)
	public void sendMail(String toAddress, String subject, String message, String title, String link, String path1)
			throws Exception {
		HelperClass.logInfo("Send Email", "Test begins...!");
		HelperClass.logInfo("Excel passed data : " + toAddress + ", " + subject + ", " + message);
		System.out.println("Send mail starts...!");
		login.clickComposeButton();
		login.enterToAddress(toAddress);
		login.enterSubject(subject);
		login.enterMessage(message+"\n");
		login.clickAttachLinkButton();
		login.enterLinkTitle(title);
		login.enterLink(link);
		login.clickOkButton();
		login.clickAttachFileButton();
		login.selectFile(path1);
		login.clickSendButton();
	}

}
