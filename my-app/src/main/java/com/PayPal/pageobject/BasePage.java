package com.PayPal.pageobject;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.interactions.touch.LongPressAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected final WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean verifyElementVisibilty(WebElement element){
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
		
	}
	
	public boolean verifyElementClickablity(WebElement element){
		
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
		
	}	
	
	public void waitElementVisible(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitElementClickable(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void optionalClick(WebElement element){
		if(verifyElementVisibilty(element)){
			element.click();
		}
	}
	
	public void longClick(WebElement element){
		TouchActions actions=new TouchActions(driver);
		
		Point p=element.getLocation();
		
		actions.down(p.x, p.y);
		actions.pause(3000);
		actions.up(p.x, p.y);
		actions.perform();
		
	}
	
	
	public void StaleElementClick(WebElement element) throws InterruptedException{
		int count = 0; 
		while (count < 4){
		    try {
		    	element.click(); 
				count = count+4;
		     } catch (StaleElementReferenceException e){
		       if (count<4){
		    	   System.out.println("Trying to recover from a stale element.");
			       Thread.sleep(1000);
			       count = count+1;
		       }else{
		    	   System.out.println("Tried 4 times and still catching " + e.toString());
		       }
		       
		     }

		}
	}
}
 