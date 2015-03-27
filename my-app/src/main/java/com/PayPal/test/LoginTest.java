package com.PayPal.test;


import java.util.List;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.PayPal.pageobject.ConfigPage;
import com.PayPal.pageobject.LinkFingerPrint;
import com.PayPal.pageobject.LoginPage;
import com.PayPal.pageobject.NavigationBar;
import com.PayPal.pageobject.ShopPage;
import com.PayPal.pageobject.StartPage;

public class LoginTest implements TestConfiguration{
  private SelendroidLauncher selendroidServer = null;
  private WebDriver driver = null;
  private StartPage startPage = null;
  private ShopPage shopPage = null;
  private NavigationBar navBar = null;
  private LoginPage loginPage = null;
  private ConfigPage configPage = null;
  private LinkFingerPrint linkFingerPrint = null;
  
  @Test
  public void loginWithUserName() throws InterruptedException {
	shopPage = startPage.proceedLogin();
	
	Assert.assertTrue(shopPage.verifyShopPageExist());
	
	navBar = shopPage.clickHomeButton();
	
	configPage = navBar.longclickLogin();
	
	configPage = configPage.chooseEnv("sandbox");
	
	navBar = configPage.backToNav();
	
	loginPage = navBar.clickLogin();
	
	linkFingerPrint = loginPage.loginWithUserName(SANDBOXUSER, SANDBOXUSERPSW);
	
	shopPage = linkFingerPrint.skipFingerPrint();
	
	Thread.sleep(5000);
	
	navBar = shopPage.clickHomeButton();
	
	Assert.assertEquals("Jin", navBar.getFirstName());
	
	Assert.assertEquals("Lu", navBar.getLastName());
	
  }


  public void loginWithMobileNumber() throws InterruptedException {
	shopPage = startPage.proceedLogin();
	
	Assert.assertTrue(shopPage.verifyShopPageExist());
	
	navBar = shopPage.clickHomeButton();
	
	configPage = navBar.longclickLogin();
	
	configPage = configPage.chooseEnv("live");
	
	navBar = configPage.backToNav();
	
	loginPage = navBar.clickLogin();
	
	linkFingerPrint = loginPage.loginWithMobileNumber("","");
	
	shopPage = linkFingerPrint.skipFingerPrint();
	
	Thread.sleep(5000);
	
	navBar = shopPage.clickHomeButton();
	
	Assert.assertEquals("JIN", navBar.getFirstName());
	
	Assert.assertEquals("LU", navBar.getLastName());
  }
  
  @Before
  public void startSelendroidServer() throws Exception {
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

}