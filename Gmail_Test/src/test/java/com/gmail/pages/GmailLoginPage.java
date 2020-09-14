package com.gmail.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.gmail.util.HelperClass;

public class GmailLoginPage {

	WebDriver driver;
	JavascriptExecutor js;

	By input_mailId = By.xpath("//input[@name='identifier']");
	By button_next = By.xpath("//span[contains(text(), 'Next')]");
	By input_password = By.xpath("//input[@type='password']");
	By button_compose = By.xpath("//div[@class='aic']/div/div");
	By input_toAddress = By.xpath("//textarea[@name='to']");
	By input_subject = By.xpath("//input[@name='subjectbox']");
	By textarea_content = By.xpath("//div[@role='textbox']");
	By icon_attachFile = By.xpath("//div[@class='a1 aaA aMZ']");
	By icon_attachLink = By.xpath("//div[@class='e5 aaA aMZ']");
	By input_linkTitle = By.id("linkdialog-text");
	By input_link = By.id("linkdialog-onweb-tab-input");
	By button_ok = By.xpath("//button[@name='ok']");
	By button_send = By.xpath("//div[@role='button' and contains(text(), 'Send')]");
	
	public GmailLoginPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public void enterEmailId(String mailId) throws Exception{
		try {
			HelperClass.clearElement(input_mailId);
			HelperClass.enterWebElement(input_mailId, mailId);
			HelperClass.successReport("Entered username");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_mailId);
				HelperClass.enterWhenVisible(input_mailId, 5, mailId);
				HelperClass.successReport("Entered username.!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...Username field cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void enterPassword(String password) throws Exception{
		try {
			HelperClass.clearElement(input_password);
			HelperClass.enterWebElement(input_password, password);
			HelperClass.successReport("Entered password..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_password);
				HelperClass.enterWhenVisible(input_password, 5, password);
				HelperClass.successReport("Entered password..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...password field cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void clickOnNext() throws Exception{
		try {
			HelperClass.clickWebElement(button_next);
			HelperClass.logInfo("Clicked on next button");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(button_next, 5);
				HelperClass.logInfo("Clicked on next button");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...next button cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void clickComposeButton() throws Exception{
		try {
			HelperClass.clickWebElement(button_compose);
			HelperClass.logInfo("Clicked on compress button");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(button_compose, 5);
				HelperClass.logInfo("Clicked on compress button");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...compress button cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void enterToAddress(String toaddress) throws Exception{
		try {
			HelperClass.clearElement(input_toAddress);
			HelperClass.enterWebElement(input_toAddress, toaddress);
			HelperClass.successReport("Entered toaddress..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_toAddress);
				HelperClass.enterWhenVisible(input_toAddress, 5, toaddress);
				HelperClass.successReport("Entered toaddress..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...toAddress field cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void enterSubject(String subject) throws Exception{
		try {
			HelperClass.clearElement(input_subject);
			HelperClass.enterWebElement(input_subject, subject);
			HelperClass.successReport("Entered subject..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_subject);
				HelperClass.enterWhenVisible(input_subject, 5, subject);
				HelperClass.successReport("Entered subject..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...subject field cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void enterMessage(String message) throws Exception{
		try {
			HelperClass.clearElement(textarea_content);
			HelperClass.enterWebElement(textarea_content, message);
			HelperClass.successReport("Entered content..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(textarea_content);
				HelperClass.enterWhenVisible(textarea_content, 5, message);
				HelperClass.successReport("Entered content..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...content textarea cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void clickAttachFileButton() throws Exception{
		try {
			HelperClass.clickWebElement(icon_attachFile);
			HelperClass.logInfo("Clicked on Attach file icon");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(icon_attachFile, 5);
				HelperClass.logInfo("Clicked on Attach file icon");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...Attach file icon cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void clickAttachLinkButton() throws Exception{
		try {
			HelperClass.clickWebElement(icon_attachLink);
			HelperClass.logInfo("Clicked on Attach Link icon");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(icon_attachLink, 5);
				HelperClass.logInfo("Clicked on Attach Link icon");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...Attach Link icon cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void enterLinkTitle(String title) throws Exception{
		try {
			HelperClass.clearElement(input_linkTitle);
			HelperClass.enterWebElement(input_linkTitle, title);
			HelperClass.successReport("Entered link title..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_linkTitle);
				HelperClass.enterWhenVisible(input_linkTitle, 5, title);
				HelperClass.successReport("Entered link title..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...title filed cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void enterLink(String link) throws Exception{
		try {
			HelperClass.clearElement(input_link);
			HelperClass.enterWebElement(input_link, link);
			HelperClass.successReport("Entered link..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_link);
				HelperClass.enterWhenVisible(input_link, 5, link);
				HelperClass.successReport("Entered link..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...link filed cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void clickOkButton() throws Exception{
		try {
			HelperClass.clickWebElement(button_ok);
			HelperClass.logInfo("Clicked on ok button");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(button_ok, 5);
				HelperClass.logInfo("Clicked on ok button");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...ok button cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void selectFile(String path) throws Exception {
		try {
			// Setting clipboard with file location
			StringSelection stringSelection = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			HelperClass.successReport(" File is selected..!");
			Thread.sleep(8000);
		} catch (Exception exp) {
			HelperClass.failureReport("Test failed");
			HelperClass.logInfo(
					"Timeout...ok button cannot be found even after waiting for 5 sec.." + exp.toString());
			throw (exp);
		}
	}
	
	public void clickSendButton() throws Exception{
		try {
			HelperClass.clickWebElement(button_send);
			HelperClass.logInfo("Clicked on send button");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(button_send, 5);
				HelperClass.logInfo("Clicked on send button");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...send button cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
}
