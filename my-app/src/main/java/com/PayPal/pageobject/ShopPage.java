package com.PayPal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends BasePage {
	
	@FindBy (id = "merchant_list")
	private WebElement merchantList;
	
	@FindBy (id = "home")
	private WebElement buttonHome;	
	
	private final WebDriver driver;
	
	public ShopPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyShopPageExist(){
		return verifyElementVisibilty(merchantList);
	}
	
	public NavigationBar<?> clickHomeButton() throws InterruptedException{
		
		waitElementClickable(buttonHome);
		
		buttonHome.click();
		
		return PageFactory.initElements(driver, NavigationBar.class);
	}
	
}
