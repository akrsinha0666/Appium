package com.rahulshettyacademy.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{

	//AppiumDriver driver;
	IOSDriver driver;
	public IOSActions(IOSDriver driver) {
		super();
		this.driver=driver;
	}
	public void longPressAction(WebElement ele) {
		Map<String,Object> param= new HashMap<String,Object>();
		   param.put("element", ((RemoteWebElement) ele).getId());
		driver.executeScript("mobile:touchAndHold",param);
		param.put("duration", 5);
       
    }
    
    public void swipeAction(WebElement ele,String direction) {
    	Map<String, Object> param= new HashMap<String, Object>();
		
		param.put("bundleId", "com.apple.mobilesslideshow");
		driver.executeScript("mobile:launchApp", param);
    }
    
    public void scrolltoEndAction(WebElement ele) {
    	Map<String ,Object>param= new HashMap<String, Object>();
		param.put("direction", "down");
		param.put("element", ((RemoteWebElement) ele).getId());
		 driver.executeScript("mobile:scroll",param);
    }
    
    public void ScrollToWebElement(WebElement text) {
    	Map<String ,Object>param= new HashMap<String, Object>();
		param.put("direction", "down");
		param.put("element", ((RemoteWebElement) text).getId());
		 driver.executeScript("mobile:scroll",param);
    }
    
   
}
