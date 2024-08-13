package com.rahulshettyacademy.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{

	 //AppiumDriver driver;
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		super();
		this.driver=driver;
	}
	public void longPressAction(WebElement ele) {
    	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000  // Duration in milliseconds
            ));
    }
    
    public void swipeAction(WebElement ele,String direction) {
    	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
    			ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),
    	        // Duration in milliseconds
    	    "direction", direction,
    	    "percent", 0.75
    	));
    }
    
    public void scrolltoEndAction() {
    	boolean canScrollMore;
    	do {
    	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
    	 "left", 100, "top", 100, "width", 200, "height", 200,
    	 "direction", "down",
    	 "percent", 1.0
    	));
    	} while(canScrollMore);
    }
    
    public void ScrollToText(String text) {
    	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text+"\"));"));
    }
    
    
}
