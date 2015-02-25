package com.PayPal.pageobject;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Transfer extends BasePage {
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id!='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/RelativeLayout/AutoCompleteTextView")
	private WebElement sendRecipient;
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/RelativeLayout/AutoCompleteTextView")
	private WebElement requestRecipient;
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id!='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/RelativeLayout/EditText")
	private WebElement sendAmount;
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/RelativeLayout/EditText")
	private WebElement requestAmount;
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id!='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/LinearLayout/Spinner")
	private WebElement sendCurrency;
	
	@FindBy(xpath = "//NoSaveStateFrameLayout/RelativeLayout[@id='payment_parent']" +
			"/ScrollView/LinearLayout/RelativeLayout/RelativeLayout/LinearLayout/Spinner")
	private WebElement requestCurrency;
	
	@FindBy(id = "payment_message_editable")
	private WebElement message;
	
	@FindBy(id = "review_button")
	private WebElement reviewButton;
	
	@FindBy(id = "sending_amount")
	private WebElement sendingAmount;
	
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
	
	@FindBy(id = "home")
	private WebElement buttonHome;	
	
	@FindBy(id = "money_send")
	private WebElement sendMoney;
	
	@FindBy(id = "money_request")
	private WebElement requestMoneyTab;
	
	@FindBy(id = "request_button")
	private WebElement requestButton;
	
	private final WebDriver driver;
	
	public Transfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getSendAmount(){
		return sendingAmount.getText();
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
	
	public Transfer inputSendRecipient(String rec){
		sendRecipient.sendKeys(rec);
		
		return this;
	}

	public Transfer inputSendAmount(String amnt){
		sendAmount.sendKeys(amnt);
		
		return this;
	}
	
	public Transfer chooseSendCurrency(String cur){
		sendCurrency.click();
		
		if(cur.equals("AUD")){
			driver.findElement(By.xpath("//TextView[@value='AUD – Australian dollar']")).click();
		}else if(cur.equals("EUR")){
			driver.findElement(By.xpath("//TextView[@value='EUR – Euro']")).click();
		}else if(cur.equals("HKD")){
			driver.findElement(By.xpath("//TextView[@value='HKD – Hong Kong dollar']")).click();
		}	
		
		return this;
	}
	
	public Transfer inputRequestRecipient(String rec){
		requestRecipient.sendKeys(rec);
		
		return this;
	}

	public Transfer inputRequestAmount(String amnt){
		requestAmount.sendKeys(amnt);
		
		return this;
	}
	
	public Transfer chooseRequestCurrency(String cur){
		requestCurrency.click();
		
		if(cur.equals("AUD")){
			driver.findElement(By.xpath("//TextView[@value='AUD – Australian dollar']")).click();
		}else if(cur.equals("EUR")){
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
	
	public Transfer clickRequestTab(){
		
		requestMoneyTab.click();
		
		return this;
	}
	
	public Transfer clickRequestButton(){
		
		requestButton.click();
		
		return this;
	}
	
	public NavigationBar<?> clickHomeButton() throws InterruptedException{
		
		waitElementClickable(buttonHome);
		
		buttonHome.click();
		
		return PageFactory.initElements(driver, NavigationBar.class);
	}
	
}
