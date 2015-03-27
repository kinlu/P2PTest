package com.PayPal.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PayPal.pageobject.ActivityPage;
import com.PayPal.pageobject.ConfigPage;
import com.PayPal.pageobject.LinkFingerPrint;
import com.PayPal.pageobject.LoginPage;
import com.PayPal.pageobject.NavigationBar;
import com.PayPal.pageobject.ShopPage;
import com.PayPal.pageobject.StartPage;
import com.PayPal.pageobject.Transfer;

public class SendAndRequestTest implements TestConfiguration {
	private SelendroidLauncher selendroidServer = null;
	private WebDriver driver = null;
	private StartPage startPage = null;
	private ShopPage shopPage = null;
	private LoginPage loginPage = null;
	private ConfigPage configPage = null;
	private LinkFingerPrint linkFingerPrint = null;
	private Transfer transfer = null;
	private NavigationBar navBar = null;
	private ActivityPage actPage = null;
	
	@Test
	public void SendAUDMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.inputSendRecipient("kingtest@test.com");
		
		transfer = transfer.inputSendAmount("20");
		
		transfer = transfer.chooseSendCurrency("AUD");
		
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
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();
		
		Assert.assertEquals("JIN LU", TxDetail.get("Recipient"));
		Assert.assertEquals("- $20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Sent Payment", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Test
	public void SendEURMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.inputSendRecipient("kingtest@test.com");
		
		transfer = transfer.inputSendAmount("20");
		
		transfer = transfer.chooseSendCurrency("EUR");
		
		transfer = transfer.choosePaymentType("personal");
		
		transfer = transfer.clickReview();
		
		Assert.assertTrue(transfer.getSendAmount().contains("20"));
		Assert.assertTrue(transfer.getSendAmount().contains("EUR"));
		Assert.assertTrue(transfer.getSendFee().contains("0"));
		Assert.assertTrue(transfer.getSendFee().contains("EUR"));
		Assert.assertTrue(transfer.getSendTotal().contains("20"));
		Assert.assertTrue(transfer.getSendTotal().contains("EUR"));
		
		transfer = transfer.clickSend();
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("EUR"));
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();

		Assert.assertEquals("JIN LU", TxDetail.get("Recipient"));
		Assert.assertEquals("- €20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Sent Payment", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Test
	public void SendHKDMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.inputSendRecipient("kingtest@test.com");
		
		transfer = transfer.inputSendAmount("20");
		
		transfer = transfer.chooseSendCurrency("HKD");
		
		transfer = transfer.choosePaymentType("personal");
		
		transfer = transfer.clickReview();
		
		Assert.assertTrue(transfer.getSendAmount().contains("20"));
		Assert.assertTrue(transfer.getSendAmount().contains("HKD"));
		Assert.assertTrue(transfer.getSendFee().contains("0"));
		Assert.assertTrue(transfer.getSendFee().contains("HKD"));
		Assert.assertTrue(transfer.getSendTotal().contains("20"));
		Assert.assertTrue(transfer.getSendTotal().contains("HKD"));
		
		transfer = transfer.clickSend();
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("HKD"));
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();

		Assert.assertEquals("JIN LU", TxDetail.get("Recipient"));
		Assert.assertEquals("- HK$20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Sent Payment", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Test
	public void RequestAUDMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.clickRequestTab();
		
		transfer = transfer.inputRequestRecipient("kingtest@test.com");
		
		transfer = transfer.inputRequestAmount("20");
		
		transfer = transfer.chooseRequestCurrency("AUD");
		
		transfer = transfer.clickRequestButton();
		
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("AUD"));
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();

		Assert.assertEquals("kingtest@test.com", TxDetail.get("Recipient"));
		Assert.assertEquals("+ $20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Requested", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Test
	public void RequestEURMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.clickRequestTab();
		
		transfer = transfer.inputRequestRecipient("kingtest@test.com");
		
		transfer = transfer.inputRequestAmount("20");
		
		transfer = transfer.chooseRequestCurrency("EUR");
		
		transfer = transfer.clickRequestButton();
		
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("EUR"));
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();

		Assert.assertEquals("kingtest@test.com", TxDetail.get("Recipient"));
		Assert.assertEquals("+ €20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Requested", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Test
	public void RequestHKDMoney() throws InterruptedException {
		loginProcess();
		
		NavigationBar<Transfer> navToTransfer = null;
		NavigationBar<ActivityPage> navToActivityPage = null;
		HashMap<String, String> TxDetail = null;
		
		String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		navToTransfer = (NavigationBar<Transfer>) shopPage.clickHomeButton();
		
		transfer = navToTransfer.chooseMenu("transfer");
		
		transfer = transfer.clickRequestTab();
		
		transfer = transfer.inputRequestRecipient("kingtest@test.com");
		
		transfer = transfer.inputRequestAmount("20");
		
		transfer = transfer.chooseRequestCurrency("HKD");
		
		transfer = transfer.clickRequestButton();
		
		Assert.assertTrue(transfer.getSuccessMsg().contains("20"));
		Assert.assertTrue(transfer.getSuccessMsg().contains("HKD"));
		
		transfer = transfer.clickDone();
		
		navToActivityPage = (NavigationBar<ActivityPage>) transfer.clickHomeButton();
		
		actPage = navToActivityPage.chooseMenu("activity");
		
		TxDetail = actPage.getFirstTXDetail();

		Assert.assertEquals("kingtest@test.com", TxDetail.get("Recipient"));
		Assert.assertEquals("+ HK$20.00", TxDetail.get("Amount"));
		Assert.assertEquals("Requested", TxDetail.get("Title"));
		Assert.assertEquals(todayAsString, TxDetail.get("Date"));
		
	}
	
	@Before
	public void startSelendroidServer() throws Exception {
		/*
	    SelendroidConfiguration config = new SelendroidConfiguration();
	    config.addSupportedApp(APPPATH);
	    selendroidServer = new SelendroidLauncher(config);
	    selendroidServer.launchSelendroid();
		*/
		SelendroidCapabilities caps = new SelendroidCapabilities(APPNAME);
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
		
		linkFingerPrint = loginPage.loginWithUserName(SANDBOXUSER,SANDBOXUSERPSW);
		
		shopPage = linkFingerPrint.skipFingerPrint();
		
		Thread.sleep(5000);
	
	}

}
