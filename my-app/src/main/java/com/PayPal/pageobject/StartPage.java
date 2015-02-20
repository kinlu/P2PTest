package com.PayPal.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {
	@FindBy(id = "button1")
	private WebElement agreebutton;
	
	@FindBy(id = "start")
	private WebElement startbutton;
	
	@FindBy(id = "arrow1")
	private  WebElement arrow;
	
	private final WebDriver driver;
	
	public StartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public ShopPage proceedLogin(){
		optionalClick(agreebutton);
		
		optionalClick(startbutton);
		
		optionalClick(arrow);
		
		return PageFactory.initElements(driver, ShopPage.class);
	}

}
