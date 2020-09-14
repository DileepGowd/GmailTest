package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.gmail.util.HelperClass;

public class GmailPage {

	WebDriver driver;
	JavascriptExecutor js;
	
	By icon_search = By.xpath("//button[@class='gb_If']");
	By input_fromAddress = By.xpath("//input[@class='ZH nr aQa']");
	By input_toAddress = By.xpath("//input[@class='ZH nr aQf']");
	By button_search = By.xpath("//div[@role='button' and contains(text(), 'Search')]");
	By select_mail = null;
	By icon_gmail = By.xpath("//a[@title='Gmail']/img");
	By checkbox_select_mail = By.xpath("//tr[@class='zA yO']/td/div");
	By icon_move = By.xpath("//div[@class='T-I J-J5-Ji T-I-Js-IF mA ns T-I-ax7 L3']");
	By oneTab = null;
	
	
	public GmailPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public void clickSearchIcon() throws Exception{
		try {
			HelperClass.clickWebElement(icon_search);
			HelperClass.logInfo("Clicked on search icon");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(icon_search, 5);
				HelperClass.logInfo("Clicked on search icon");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...search icon cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void enterFromAddress(String fromAddress) throws Exception{
		try {
			HelperClass.clearElement(input_fromAddress);
			HelperClass.enterWebElement(input_fromAddress, fromAddress);
			HelperClass.successReport("Entered fromAddress..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_fromAddress);
				HelperClass.enterWhenVisible(input_fromAddress, 5, fromAddress);
				HelperClass.successReport("Entered fromAddress..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...fromAddress filed cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void enterToAddress(String toAddress) throws Exception{
		try {
			HelperClass.clearElement(input_toAddress);
			HelperClass.enterWebElement(input_toAddress, toAddress);
			HelperClass.successReport("Entered toAddress..!");
		} catch (Exception e1) {
			try {
				HelperClass.clearElement(input_toAddress);
				HelperClass.enterWhenVisible(input_toAddress, 5, toAddress);
				HelperClass.successReport("Entered toAddress..!");
			} catch (Exception e2) {
				HelperClass.failureReport("Test failed..!");
				HelperClass.logInfo(
						"Timeout...toAddress filed cannot be found even after waiting for 5 sec.." + e2.toString());
				throw e2;
			}
		}
	}
	
	public void clickSearchButton() throws Exception{
		try {
			HelperClass.clickWebElement(button_search);
			HelperClass.logInfo("Clicked on search button");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(button_search, 5);
				HelperClass.logInfo("Clicked on search button");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...search button cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void selectMail(String mail) throws Exception{
		select_mail = By.xpath("//div[@class='yW']/span/span[contains(text(),'"+mail+"')]");
		try {
			HelperClass.clickWebElement(select_mail);
			HelperClass.logInfo("Clicked on a mail");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(select_mail, 5);
				HelperClass.logInfo("Clicked on a mail");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...a mail cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void clickOnGmail() throws Exception{
		try {
			HelperClass.clickWebElement(icon_gmail);
			HelperClass.logInfo("Clicked on gmail icon");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(icon_gmail, 5);
				HelperClass.logInfo("Clicked on gmail icon");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...gmail icon cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void clickOnCheckBox() throws Exception{
		try {
			HelperClass.clickWebElement(checkbox_select_mail);
			HelperClass.logInfo("Clicked on mail checkbox");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(checkbox_select_mail, 5);
				HelperClass.logInfo("Clicked on mail checkbox");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...mail checkbox cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void clickOnMoveIcon() throws Exception{
		try {
			HelperClass.clickWebElement(icon_move);
			HelperClass.logInfo("Clicked on move icon");
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(icon_move, 5);
				HelperClass.logInfo("Clicked on move icon");
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout...move icon cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	public void selectTab(String tab) throws Exception{
		oneTab = By.xpath("//div[@class='J-N-Jz' and contains(text(), '"+tab+"' )]");
		try {
			HelperClass.clickWebElement(oneTab);
			HelperClass.logInfo("Clicked on "+tab);
		} catch (Exception e1) {
			try {
				HelperClass.clickWhenReady(oneTab, 5);
				HelperClass.logInfo("Clicked on "+tab);
			}

			catch (Exception e2) {
				HelperClass.failureReport("Test failed");
				HelperClass.logInfo(
						"Timeout..."+tab+" cannot be found even after waiting for 5 sec.." + e2.toString());
				throw (e2);
			}
		}
	}
	
	
}
