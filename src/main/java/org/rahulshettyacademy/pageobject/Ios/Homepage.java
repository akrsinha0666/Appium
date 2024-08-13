package org.rahulshettyacademy.pageobject.Ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Homepage extends IOSActions{

         IOSDriver driver;
	
	public Homepage(IOSDriver driver) {
		super(driver);
		//we are providing driver of parent to child coz we have to access parent from child
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
}
	//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	public AlertViews selectViews() {
		 alertViews.click();
		return new AlertViews(driver);
		
	}
	//Assert.assertrue("driver.findelemt().size<1)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
