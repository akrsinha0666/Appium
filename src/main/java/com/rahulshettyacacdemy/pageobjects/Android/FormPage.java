package com.rahulshettyacacdemy.pageobjects.Android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		//we are providing driver of parent to child coz we have to access parent from child
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//driver help to make internally driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
		
	}
	 @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	 
	 @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	 private WebElement femaleoption;
	 
	 @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	 private WebElement maleoption;
	 
	
	 @AndroidFindBy(id="android:id/text1")
	 private WebElement countryselection;
	 
	 @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	 private WebElement shopButton;
	 
	
	 
	 public void setNameFiled(String name) {
		 nameField.sendKeys(name);
		 driver.hideKeyboard();
	 }
	 public void setActivity() {
		 Activity activity =new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		 ((JavascriptExecutor) driver).executeScript("mobile:startActivity", 
	    			ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
		 //driver.startActivity(activity);
		 //This is deprrciated method
		 

		    // Log to confirm the activity has been set
		    System.out.println("Activity set to: " + driver.currentActivity());

		    // Re-initialize the form page object
		    
	 }
	 
	 
//	 public void setActivity() {
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//	 }
//	 
	 public void setGender(String gender) {
		 if(gender.contains("female"))
			 femaleoption.click();
		 else
			 maleoption.click();
			 
	 }
	 public void setCountrySelection(String  countryName) {
		 countryselection.click();
		 ScrollToText(countryName);
		 driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	 }
	 public ProducrsCatalog submitform() {
		 shopButton.click();
		return new ProducrsCatalog (driver);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
