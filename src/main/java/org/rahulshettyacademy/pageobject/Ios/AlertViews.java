package org.rahulshettyacademy.pageobject.Ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettyacademy.utils.IOSActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends IOSActions{

IOSDriver driver;
	
	public AlertViews(IOSDriver driver) {
		super(driver);
		//we are providing driver of parent to child coz we have to access parent from child
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
}
	//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click(); 
	@iOSXCUITFindBy(iOSClassChain="**//XCUIElementTypeStaticText[@name='Text Entry']")
	private WebElement textEntrymeenu;
	//driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"));
	
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
	private WebElement cinfirmpopup;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement textBox;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement acceptpopup;
	
	@iOSXCUITFindBy(iOSNsPredicate="name BEGINSWITH[c] 'A message'")
	private WebElement confirmmessage;
	

	@iOSXCUITFindBy(iOSNsPredicate="label=='Confirm'")
	private WebElement submit;
	
	
	public void selectViews() {
		alertViews.click();
	}
	
	
	public void filltextLabel(String name) {
		textEntrymeenu.click();
		textBox.sendKeys(name);
		 acceptpopup.click();
	}
	
	public String getConfirmMessage() {
		cinfirmpopup.click();
		return confirmmessage.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
