package com.PayPal.Util;

import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONUtility {

	public JSONUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public static JSONObject parseJSONFile (String filePath) throws Exception
	{
		String string = "";
       	 
		// Step1: Let's 1st read file from fileSystem
        InputStream crunchifyInputStream = new FileInputStream(filePath);
        InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
        BufferedReader br = new BufferedReader(crunchifyReader);
        String line;
        while ((line = br.readLine()) != null) {
            string += line + "\n";
        }

        JSONObject jsonObject = new JSONObject(string);
        br.close();
        
        return jsonObject;
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String string = "";
	        try {
	        	JSONObject obj = parseJSONFile("src\\main\\java\\com\\PayPal\\resource\\CreditCardNumbers\\AMEX.JSON");
	        	String invoiceDate = JsonPath.read(obj.toString(), "$.CreditCard[0].CardNumber");
	            System.out.println(invoiceDate);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
