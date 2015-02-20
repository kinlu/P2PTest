package com.PayPal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private final WebDriver driver;
	
	@FindBy (id = "menuIcon")
	private WebElement buttonMore;
	
	@FindBy (linkText = "Switch User")
	private WebElement buttonSwitchUser;
	
	@FindBy (id = "etEmail")
	private WebElement inputEmail;
	
	@FindBy (id = "password")
	private WebElement inputPassword;
	
	@FindBy (id = "bttnLogin")
	private WebElement buttonLogin;
	
	@FindBy (linkText = "Mobile Number and PIN")
	private WebElement buttonMobileNumber;
	
	@FindBy (id = "etNumber")
	private WebElement phoneNumber;
	
	@FindBy (id = "pin")
	private WebElement pinCode;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public LinkFingerPrint loginWithUserName (String username, String password){
		
		waitElementClickable(buttonMore);
		
		buttonMore.click();
		
		buttonSwitchUser.click();
		
		inputEmail.sendKeys(username);
		
		inputPassword.sendKeys(password);
		
		buttonLogin.click();
		
		return PageFactory.initElements(driver, LinkFingerPrint.class);
	}
	
	public LinkFingerPrint loginWithMobileNumber (String phonenumber, String pin){
		
		waitElementClickable(buttonMore);
		
		buttonMore.click();
		
		optionalClick(buttonSwitchUser);
		
		optionalClick(buttonMore);
		
		buttonMobileNumber.click();
		
		phoneNumber.sendKeys(phonenumber);
		
		pinCode.sendKeys(pin);
		
		buttonLogin.click();
		
		return PageFactory.initElements(driver, LinkFingerPrint.class);
	}
	
	
}
