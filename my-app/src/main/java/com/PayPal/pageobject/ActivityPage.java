package com.PayPal.pageobject;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends BasePage {

	private final WebDriver driver;
	
	public ActivityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy (xpath = "//RelativeLayout[2]/LinearLayout[1]/RobotoTextView[1]")
	private WebElement firstTXRecipient;
	
	@FindBy (xpath = "//RelativeLayout[2]/LinearLayout[1]/RobotoTextView[2]")
	private WebElement firstTXAmount;
	
	@FindBy (xpath = "//RelativeLayout[2]/LinearLayout[2]/RobotoTextView[1]")
	private WebElement firstTXTitle;
	
	@FindBy (xpath = "//RelativeLayout[2]/LinearLayout[2]/RobotoTextView[2]")
	private WebElement firstTXDate;
	
	public HashMap<String, String> getFirstTXDetail(){
		HashMap<String, String> TXDetail = new HashMap<String, String>();
		
		TXDetail.put("Recipient", firstTXRecipient.getText());
		TXDetail.put("Amount", firstTXAmount.getText());
		TXDetail.put("Title", firstTXTitle.getText());
		TXDetail.put("Date", firstTXDate.getText());
		
		return TXDetail;		
	}
	
}
