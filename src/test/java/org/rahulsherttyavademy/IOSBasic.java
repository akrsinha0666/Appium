package org.rahulsherttyavademy;

import org.openqa.selenium.By;
import org.rahulsherttyavademy.TestUtils.IOSBaseTest;
import org.rahulshettyacademy.pageobject.Ios.AlertViews;
import org.rahulshettyacademy.pageobject.Ios.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

//import basicAppium.BaseTest;
import io.appium.java_client.AppiumBy;

public class IOSBasic extends IOSBaseTest{
	
	//xpath,classname,IOS,iosClassChain,IOSPredicateString,accessibilityId,Id
	@Test
	public void IosBAsicTest() {
	
 AlertViews	alertviews=homepage.selectViews();
	alertviews.filltextLabel("hello");
	String actualmessage = alertviews.getConfirmMessage();
	Assert.assertEquals(actualmessage, "A message should be short,complete sentence");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
