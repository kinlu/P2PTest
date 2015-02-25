package com.PayPal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkFingerPrint extends BasePage{

	private final WebDriver driver;
	
	public LinkFingerPrint(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	@FindBy (linkText = "Link Fingerprint")
	private WebElement linkFingerPrintTitle;
	
	@FindBy (linkText = "Not Now")
	private WebElement notNowButton;
	
	@FindBy (linkText = "OK")
	private WebElement okButton;
	
	public ShopPage skipFingerPrint() throws InterruptedException{
		
		Thread.sleep(3000);
		
		if(verifyElementVisibilty(linkFingerPrintTitle)){
			StaleElementClick(notNowButton);
		}
		
		return PageFactory.initElements(driver, ShopPage.class);
	}
	
}
