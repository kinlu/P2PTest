package com.PayPal.test;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PayPal.pageobject.ConfigPage;
import com.PayPal.pageobject.LinkFingerPrint;
import com.PayPal.pageobject.LoginPage;
import com.PayPal.pageobject.NavigationBar;
import com.PayPal.pageobject.ShopPage;
import com.PayPal.pageobject.StartPage;
import com.PayPal.pageobject.Transfer;

public class SendAndRequest {
	private static SelendroidLauncher selendroidServer = null;
	private static WebDriver driver = null;
	private static StartPage startPage = null;
	private static ShopPage shopPage = null;
	private static LoginPage loginPage = null;
	private static ConfigPage configPage = null;
	private static LinkFingerPrint linkFingerPrint = null;
	private static Transfer transfer = null;
	private static NavigationBar navBar = null;
	
	
	@Test
	public void SendMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navBar = null;
		
		navBar = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navBar.chooseMenu("transfer");
		
		transfer = transfer.inputRecipient("kingtest@test.com");
		
		transfer = transfer.inputAmount("20");
		
		transfer = transfer.chooseCurrency("AUD");
		
		transfer = transfer.choosePaymentType("personal");
		
		transfer = transfer.clickReview();
		
		Assert.assertTrue(transfer.getSendAmount().contains("20"));
		Assert.assertTrue(transfer.getSendAmount().contains("AUD"));
		Assert.assertTrue(transfer.getSendFee().contains("0"));
		Assert.assertTrue(transfer.getSendFee().contains("AUD"));
		Assert.assertTrue(transfer.getSendTotal().contains("20"));
		Assert.assertTrue(transfer.getSendTotal().contains("AUD"));
		
		transfer = transfer.clickSend();
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("AUD"));
		
		transfer.clickDone();
		
	}
	
	@Before
	public void startSelendroidServer() throws Exception {
	  SelendroidCapabilities caps = new SelendroidCapabilities("com.paypal.android.p2pmobile:5.11.1-RC1");
	  driver = new SelendroidDriver(caps);
	  
	  startPage = PageFactory.initElements(driver, StartPage.class);
	}

	@After
	public void stopSelendroidServer() {
	  if (driver != null) {
	    driver.quit();
	  }
	  if (selendroidServer != null) {
	    selendroidServer.stopSelendroid();
	  }
	}
	
	public void loginProcess() throws InterruptedException {
		shopPage = startPage.proceedLogin();
		
		
		navBar = shopPage.clickHomeButton();
		 
		configPage = navBar.longclickLogin();
		
		configPage = configPage.chooseEnv("sandbox");
		
		navBar = configPage.backToNav();
		
		loginPage = navBar.clickLogin();
		
		linkFingerPrint = loginPage.loginWithUserName("kingtest@paypal.com","11111111");
		
		shopPage = linkFingerPrint.skipFingerPrint();
		
		Thread.sleep(5000);
	
	}

}
