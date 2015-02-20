package com.PayPal.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.selendroid.SelendroidKeys;
import org.openqa.selenium.interactions.touch.TouchActions;


public class ConfigPage extends BasePage{

	private final WebDriver driver;
	
	public ConfigPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	@FindBy (id = "environment_spinner")
	private WebElement envBox;
	
	@FindBy (linkText = "Sandbox")
	private WebElement sandBoxOption;
	
	@FindBy (linkText = "Live")
	private WebElement liveOption;
	
	public ConfigPage chooseEnv(String env) throws InterruptedException{
		
		if (env.equals("sandbox")){
			envBox.click();
			Thread.sleep(2000);
			waitElementClickable(sandBoxOption);
			
			sandBoxOption.click();
		}else if (env.equals("live")){
			envBox.click();
			Thread.sleep(2000);
			waitElementClickable(liveOption);
			
			liveOption.click();
		}
		
		return this;	
	}
	
	public NavigationBar backToNav() throws InterruptedException{
		//driver.navigate().back();
		
		TouchActions actions=new TouchActions(driver);
		actions.sendKeys(SelendroidKeys.BACK).perform();
		
		Thread.sleep(2000);
		
		return PageFactory.initElements(driver, NavigationBar.class);
	}
}
