package com.gmail.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.GmailPage;
import com.gmail.util.Base;
import com.gmail.util.ExcelRead;
import com.gmail.util.HelperClass;

public class GmailSearch_Test extends Base {

	GmailPage search;
	Base base;
	WebDriver driverTest;
	JavascriptExecutor jsTest;
	HelperClass hc;
	By mail_content = By.xpath("//div[@class='a3s aXjCH ']");

	@BeforeClass
	public void setUp() {
		base = new Base();
		driverTest = base.driver;
		jsTest = base.js;
		search = new GmailPage(driverTest, jsTest);
		hc = new HelperClass(driverTest, jsTest);
	}

	@Test(dataProvider = "TestData", dataProviderClass = ExcelRead.class, enabled = true, priority = 3)
	public void searchMail(String fromAddress, String toAddress) throws Exception {
		HelperClass.logInfo("Search Email", "Test begins...!");
		HelperClass.logInfo("Excel passed data : " + fromAddress + ", " + toAddress);
		System.out.println("Search mail starts...!");
		search.clickSearchIcon();
		search.enterFromAddress(fromAddress);
		search.enterToAddress(toAddress);
		search.clickSearchButton();
	}

	@Test(enabled = true, priority = 4)
	public void selectMail() throws Exception {
		HelperClass.logInfo("Validation of Email", "Test begins...!");
		search.clickOnGmail();
		search.selectMail("Dileep Srisailam");
		String content = driver.findElement(mail_content).getText();
		System.out.println("Mail Content : " + content);
		Assert.assertEquals(content.contains("The sample test"), true);
	}

	@Test(enabled = true, priority = 5)
	public void moveMail() throws Exception {
		HelperClass.logInfo("Move a mail", "Test begins...!");
		search.clickOnGmail();
		search.clickOnCheckBox();
		Thread.sleep(2000);
		search.clickOnMoveIcon();
		search.selectTab("Social");
		System.out.println("Moving of mail completed...!");
	}

	@Test(enabled = false, priority = 2)
	public void moveMailPromotions() throws Exception {
		HelperClass.logInfo("Move a mail to promotions", "Test begins...!");
		search.clickOnGmail();
		WebElement element = driver
				.findElement(By.xpath("//div[@class='yW']/span/span[contains(text(),'Dileep Srisailam')]"));
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		List<WebElement> moveTo = driver.findElements(By.xpath("//div[@class='J-N-JX aDE sZ']"));
		act = new Actions(driver);
		act.moveToElement(moveTo.get(1)).perform();
		driver.findElement(By.xpath("//div[@class='J-N']/div[@class='J-N-Jz' and contains(text(), 'Promotions')]"))
				.click();
	}
	
}
