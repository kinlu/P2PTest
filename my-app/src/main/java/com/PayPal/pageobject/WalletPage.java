package com.PayPal.pageobject;

import org.openqa.selenium.NoSuchElementException;

import java.util.Random;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.PayPal.Util.CardNumberGenerator;

public class WalletPage extends BasePage {
	
	@FindBy(id = "add_money_button")
	private WebElement buttonAddMoney;
	
	@FindBy(id = "withdraw_money_button")
	private WebElement buttonWithdrawMoney;
	
	@FindBy(id = "menu_wallet_add_card")
	private WebElement buttonAddCard;
	
	@FindBy(id = "menu_add_debit_card")
	private WebElement buttonAddDebitCard;
	
	@FindBy(id = "menu_add_credit_card")
	private WebElement buttonAddCreditCard;
	
	@FindBy(id = "menu_add_loyalty_card")
	private WebElement buttonAddLoyaltyCard;
	
	@FindBy(id = "amount_edit")
	private WebElement txAmount;
	
	@FindBy(id = "add_funds_button")
	private WebElement buttonAddFunds;

	@FindBy(id = "withdraw_funds_button")
	private WebElement buttonWithdrawFunds;
	
	@FindBy(id = "actionbar_next_button")
	private WebElement buttonNext;
	
	@FindBy(id = "success_details")
	private WebElement successDetails;
	
	@FindBy(id = "done_button")
	private WebElement buttonDone;
	
	@FindBy(id = "home")
	private WebElement buttonHome;
	
	@FindBy(id = "done_button")
	private WebElement doneButton;

	@FindBy(id = "card_value")
	private WebElement cardNumber;
	
	@FindBy(id = "expiration_date_spinner")
	private WebElement spinnerExpirationDate;
	
	@FindBy(xpath = "//NumberPicker[@id='year']/CustomEditText")
	private WebElement yearPicker;
	
	@FindBy(linkText = "Set")
	private WebElement buttonSet;
	
	@FindBy(id = "security_code")
	private WebElement securityCode;
	
	@FindBy(id = "action_link")
	private WebElement buttonLinkCard;
	
	@FindBy(linkText = "Aus Seller's Test Store")
	private WebElement loyaltyStoreName;
	
	@FindBy(id = "loyalty_card_value")
	private WebElement inputLoyaltyCardNumber;
	
	@FindBy(id = "action_add")
	private WebElement buttonConfirmAddLoyaltyCard;
	
	@FindBy(id = "remove_card_text")
	private WebElement linkRemoveLoyaltyCard;
	
	private final WebDriver driver;
	
	public WalletPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public WalletPage addFundToBalance(String amount){
		
		waitElementClickable(buttonAddMoney);
		
		buttonAddMoney.click();
		
		txAmount.sendKeys(amount);
		
		buttonAddFunds.click();
		
		return this;
	}
	
	public String getSuccessDetails(){
		return successDetails.getText();
	}

	public WalletPage withdrawFundToBalance(String amount){
		
		waitElementClickable(buttonWithdrawMoney);
		
		buttonWithdrawMoney.click();
		
		waitElementVisible(driver.findElement(By.xpath("//EditText[@id='amount_edit']")));
		driver.findElement(By.xpath("//EditText[@id='amount_edit']")).sendKeys(amount);
		
		buttonWithdrawFunds.click();
		
		driver.findElement(By.linkText("OK")).click();
		
		return this;
	}
	
	public WalletPage clickDone(){
		
		doneButton.click();
		
		return this;
	}

	public NavigationBar<?> clickHomeButton() {

		waitElementClickable(buttonHome);
		
		buttonHome.click();
		
		return PageFactory.initElements(driver, NavigationBar.class);
	}
	
	public WalletPage addCard(String creditcardNumber, String expiryYear, String cardSecurityCode) throws XPathExpressionException, InterruptedException{

		
		buttonAddCard.click();
		
		buttonAddDebitCard.click();
		
		cardNumber.sendKeys(creditcardNumber);
		
		buttonNext.click();
		
		spinnerExpirationDate.click();
		
		yearPicker.click();
		
		yearPicker.sendKeys(expiryYear);
		
		buttonSet.click();
		
		securityCode.sendKeys(cardSecurityCode);
		
		buttonLinkCard.click();
		
		Thread.sleep(3000);
		
		return this;
	}
	
	public boolean verifyCardNumberExist(String creditCardNumber){
		
		String lastFourDigit = "x-" + creditCardNumber.substring(creditCardNumber.length()-4);
		
		try{
			if (driver.findElement(By.linkText(lastFourDigit)).isDisplayed()){
				return true;
			}else{
				return false;
			}}catch (NoSuchElementException e){
				return false;
		}

	}
	
	public void removeCard(String creditCardNumber) throws InterruptedException{
		String lastFourDigit = "x-" + creditCardNumber.substring(creditCardNumber.length()-4);
		driver.findElement(By.linkText(lastFourDigit)).click();
		driver.findElement(By.id("remove_button")).click();
		driver.findElement(By.linkText("Remove")).click();
		
		Thread.sleep(3000);
		
	}
	
	public WalletPage addLoyaltyCard(String cardNumber){
		
		buttonAddCard.click();
		
		buttonAddLoyaltyCard.click();
		
		loyaltyStoreName.click();
		
		inputLoyaltyCardNumber.sendKeys(cardNumber);
		
		buttonConfirmAddLoyaltyCard.click();
		
		return this;
	}
	
	public WalletPage clickLoyaltyCard() throws InterruptedException{
		StaleElementClick(loyaltyStoreName);
		
		return this;
	}
	
	public String getLoyaltyCardNumber(){
		return driver.findElement(By.id("loyalty_card_number")).getText();
	}
	
	public WalletPage removeLoyaltyCard(){
		linkRemoveLoyaltyCard.click();
		driver.findElement(By.linkText("Yes")).click();
		return this;
	}
	
}
