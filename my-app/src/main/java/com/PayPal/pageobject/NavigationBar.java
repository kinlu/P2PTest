package com.PayPal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar<T extends BasePage> extends BasePage {
	
	private final WebDriver driver;

	
	@FindBy (id = "button_shop")
	private WebElement buttonShop;
	
	@FindBy (id = "Button_activity")
	private WebElement buttonActivity;
	
	@FindBy (id = "Button_transfer")
	private WebElement buttonTransfer;
	
	@FindBy (id = "Button_wallet")
	private WebElement buttonWallet;
	
	@FindBy (id = "Button_settings")
	private WebElement buttonSettings;
	
	@FindBy (linkText = "Log In")
	private WebElement buttonLogin;
	
	@FindBy (id = "txt_lname")
	private WebElement lastName;
	
	@FindBy (id = "txt_fname")
	private WebElement firstName;

	public NavigationBar(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public LoginPage clickLogin(){
		
		waitElementVisible(buttonLogin);
		
		buttonLogin.click();
		
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	public T chooseMenu(String item){
		switch(item){
		
		case "shop":
			buttonShop.click();
			return (T) PageFactory.initElements(driver, ShopPage.class);
		
		case "activity":
			buttonActivity.click();
			return (T) PageFactory.initElements(driver, ActivityPage.class); 
			
		case "transfer":
			buttonTransfer.click();
			return (T) PageFactory.initElements(driver, Transfer.class);
		
		case "wallet":
			buttonWallet.click();
			
		case "settings":
			buttonSettings.click();
			
		}	
		
		return null;
		
	}
	
	public ConfigPage longclickLogin(){
		
		longClick(buttonLogin);
		
		return PageFactory.initElements(driver, ConfigPage.class);
	}
	
	public String getLastName(){
		
		waitElementVisible(lastName);

		return lastName.getText();
	}
	
	public String getFirstName(){
		
		waitElementVisible(firstName);
		
		return firstName.getText();
	}
}
