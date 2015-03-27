package com.PayPal.Util;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.util.Random;

public class CardNumberGenerator {


	public static String getCardNumber(String cardBrand) throws XPathExpressionException{
		// TODO Auto-generated method stub
		XPath xpath = XPathFactory.newInstance().newXPath();
		String expression = "//CardNumber";
		
		InputSource inputSource;
		
		if (cardBrand.equals("AMEX")){
			inputSource = new InputSource("src\\main\\java\\com\\PayPal\\resource\\CreditCardNumbers\\AMEX.xml");
		}else if(cardBrand.equals("MasterCard")){
			inputSource = new InputSource("src\\main\\java\\com\\PayPal\\resource\\CreditCardNumbers\\MasterCard.xml");
		}else{
			inputSource = new InputSource("src\\main\\java\\com\\PayPal\\resource\\CreditCardNumbers\\Visa.xml");
		}
		
		NodeList nodes = (NodeList) xpath.evaluate(expression, inputSource, XPathConstants.NODESET);
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);

		return nodes.item(randomInt).getTextContent();
	}

}
