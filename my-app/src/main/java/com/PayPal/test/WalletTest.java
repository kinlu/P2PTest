package com.PayPal.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.xml.xpath.XPathExpressionException;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PayPal.Util.CardNumberGenerator;
import com.PayPal.pageobject.ActivityPage;
import com.PayPal.pageobject.ConfigPage;
import com.PayPal.pageobject.LinkFingerPrint;
import com.PayPal.pageobject.LoginPage;
import com.PayPal.pageobject.NavigationBar;
import com.PayPal.pageobject.ShopPage;
import com.PayPal.pageobject.StartPage;
import com.PayPal.pageobject.Transfer;
import com.PayPal.pageobject.WalletPage;

public class WalletTest extends TestBase {

	  private StartPage startPage = null;
	  private ShopPage shopPage = null;
	  private NavigationBar navBar = null;
	  private LoginPage loginPage = null;
	  private ConfigPage configPage = null;
	  private LinkFingerPrint linkFingerPrint = null;
	  private WalletPage walletPage = null;
	  private ActivityPage actPage = null;

	  public void addFundTest() throws InterruptedException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
			
		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage = walletPage.addFundToBalance("100");
		  
		  Assert.assertTrue(walletPage.getSuccessDetails().contains("100"));
		  Assert.assertTrue(walletPage.getSuccessDetails().contains("AUD"));
		  
		  walletPage = walletPage.clickDone();
		  
		  walletPage.clickHomeButton();
		  
		  navToActivityPage = (NavigationBar<ActivityPage>) walletPage.clickHomeButton();
			
		  actPage = navToActivityPage.chooseMenu("activity");

		  TxDetail = actPage.getFirstTXDetail();
			
		  Assert.assertEquals("Bank Account", TxDetail.get("Recipient"));
		  Assert.assertEquals("+ $100.00", TxDetail.get("Amount"));
		  Assert.assertEquals("Transfer", TxDetail.get("Title"));
		  Assert.assertEquals(todayAsString, TxDetail.get("Date"));
	  }
	  
	  public void withdrawFundTest() throws InterruptedException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
			
		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage = walletPage.withdrawFundToBalance("90");
		  
		  Assert.assertTrue(walletPage.getSuccessDetails().contains("90"));
		  Assert.assertTrue(walletPage.getSuccessDetails().contains("AUD"));
		  
		  walletPage = walletPage.clickDone();
		  
		  walletPage.clickHomeButton();
		  
		  navToActivityPage = (NavigationBar<ActivityPage>) walletPage.clickHomeButton();
			
		  actPage = navToActivityPage.chooseMenu("activity");

		  TxDetail = actPage.getFirstTXDetail();
			
		  Assert.assertEquals("Bank Account", TxDetail.get("Recipient"));
		  Assert.assertEquals("- $89.00", TxDetail.get("Amount"));
		  Assert.assertEquals("Transfer", TxDetail.get("Title"));
		  Assert.assertEquals(todayAsString, TxDetail.get("Date"));
	  }
	  
	  public void linkVISACard() throws InterruptedException, XPathExpressionException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
		  String cardNumber = CardNumberGenerator.getCardNumber("Visa");

		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage.addCard(cardNumber, "2019", "123");
		  
		  Assert.assertTrue(walletPage.verifyCardNumberExist(cardNumber));
		  
		  walletPage.removeCard(cardNumber);
		  
		  Assert.assertFalse(walletPage.verifyCardNumberExist(cardNumber));
	  }

	  public void linkMasterCard() throws InterruptedException, XPathExpressionException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
		  String cardNumber = CardNumberGenerator.getCardNumber("MasterCard");

		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage.addCard(cardNumber, "2019", "123");
		  
		  Assert.assertTrue(walletPage.verifyCardNumberExist(cardNumber));
		  
		  walletPage.removeCard(cardNumber);
		  
		  Assert.assertFalse(walletPage.verifyCardNumberExist(cardNumber));
	  }
	  
	  @Test
	  public void linkAMEXCard() throws InterruptedException, XPathExpressionException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
		  String cardNumber = CardNumberGenerator.getCardNumber("AMEX");

		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage.addCard(cardNumber, "2019", "1234");
		  
		  Assert.assertTrue(walletPage.verifyCardNumberExist(cardNumber));
		  
		  walletPage.removeCard(cardNumber);
		  
		  Assert.assertFalse(walletPage.verifyCardNumberExist(cardNumber));
	  }

	  public void addLoyaltyCard() throws InterruptedException {
		  loginProcess();
			
		  NavigationBar<WalletPage> navToWallet = null;
		  NavigationBar<ActivityPage> navToActivityPage = null;
		  HashMap<String, String> TxDetail = null;
			
		  navToWallet = (NavigationBar<WalletPage>) shopPage.clickHomeButton();
		  Random randomGenerator = new Random();
		  int randomInt = randomGenerator.nextInt(999999999);		
		  
		  
		  walletPage = navToWallet.chooseMenu("wallet");
		  
		  walletPage = walletPage.addLoyaltyCard(Integer.toString(randomInt));
		  
		  walletPage = walletPage.clickLoyaltyCard();
		  
		  Thread.sleep(3000);
		  
		  Assert.assertEquals(Integer.toString(randomInt), walletPage.getLoyaltyCardNumber());
		  
		  walletPage = walletPage.removeLoyaltyCard();
	  }
	  
	  @Before
	  public void startSelendroidServer() throws Exception {
		  
		  super.startSelendroidSever();
		    
		  super.startDriver();
		  
		  startPage = PageFactory.initElements(driver, StartPage.class);
	  }

	  @After
	  public void stopSelendroidServer() {
		  super.tearDown();
	  }
	  
		public void loginProcess() throws InterruptedException {
			shopPage = startPage.proceedLogin();
			
			
			navBar = shopPage.clickHomeButton();
			 
			configPage = navBar.longclickLogin();
			
			configPage = configPage.chooseEnv("sandbox");
			
			navBar = configPage.backToNav();
			
			loginPage = navBar.clickLogin();
			
			linkFingerPrint = loginPage.loginWithUserName(SANDBOXUSER, SANDBOXUSERPSW);
			
			shopPage = linkFingerPrint.skipFingerPrint();
			
			Thread.sleep(5000);
		
		}

}
