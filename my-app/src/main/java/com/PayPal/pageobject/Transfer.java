package com.PayPal.pageobject;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Transfer extends BasePage {
	
	@FindBy(id = "recipient")
	private WebElement recipient;
	
	@FindBy(id = "amount_edit")
	private WebElement amount;
	
	@FindBy(id = "choose_currency")
	private WebElement currency;
	
	@FindBy(id = "payment_message_editable")
	private WebElement message;
	
	@FindBy(id = "review_button")
	private WebElement reviewButton;
	
	@FindBy(id = "sending_amount")
	private WebElement sendAmount;
	
	@FindBy(id = "sending_fees")
	private WebElement sendFees;
	
	@FindBy(id = "sending_total")
	private WebElement sendTotal;
	
	@FindBy(id = "send_button")
	private WebElement sendButton;
	
	@FindBy(id = "success_message")
	private WebElement successMessage;
	
	@FindBy(id = "done_button")
	private WebElement doneButton;
	
	private final WebDriver driver;
	
	public Transfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getSendAmount(){
		return sendAmount.getText();
	}
	
	public String getSendFee(){
		return sendFees.getText();
	}
	
	public String getSendTotal(){
		return sendTotal.getText();
	}
	
	public String getSuccessMsg(){
		return successMessage.getText();
	}
	
	public Transfer inputRecipient(String rec){
		recipient.sendKeys(rec);
		
		return this;
	}

	public Transfer inputAmount(String amnt){
		amount.sendKeys(amnt);
		
		return this;
	}
	
	public Transfer chooseCurrency(String cur){
		currency.click();
		
		if(cur.equals("AUD")){
			driver.findElement(By.xpath("//TextView[@value='AUD – Australian dollar']")).click();
		}else if(cur.equals("GBP")){
			driver.findElement(By.xpath("//TextView[@value='EUR – Euro']")).click();
		}else if(cur.equals("HKD")){
			driver.findElement(By.xpath("//TextView[@value='HKD – Hong Kong dollar']")).click();
		}	
		
		return this;
	}
	
	public Transfer choosePaymentType(String type){
		
		if(type.equals("personal")){
			driver.findElement(By.xpath("//RadioButton[@id='radio_button_personal']")).click();
		}else if(type.equals("goods")){
			driver.findElement(By.xpath("//RadioButton[@id='radio_button_goods']")).click();
		}	
		
		return this;
	}
	
	public Transfer clickReview(){
		
		reviewButton.click();
		
		return this;
	}
	
	public Transfer clickSend(){
		
		sendButton.click();
		
		return this;
	}
	
	public Transfer clickDone(){
		
		doneButton.click();
		
		return this;
	}
}
