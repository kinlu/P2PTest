package com.PayPal.test;

import org.openqa.selenium.WebDriver;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

public class TestBase implements TestConfiguration{
	  protected SelendroidLauncher selendroidServer = null;
	  protected WebDriver driver = null;
	  
	  public void startSelendroidSever(){
		  SelendroidConfiguration config = new SelendroidConfiguration();
		  config.addSupportedApp(APPPATH);
		  selendroidServer = new SelendroidLauncher(config);
		  selendroidServer.launchSelendroid();
		    
	  }
	  
	  public void startDriver() throws Exception{
		  SelendroidCapabilities caps = new SelendroidCapabilities(APPNAME);
		  driver = new SelendroidDriver(caps);
	  }
	  
	  public void tearDown(){
		  if (driver != null) {
			  driver.quit();
		  }
		  if (selendroidServer != null) {
			  selendroidServer.stopSelendroid();
		  }		  
	  }
	  
}
