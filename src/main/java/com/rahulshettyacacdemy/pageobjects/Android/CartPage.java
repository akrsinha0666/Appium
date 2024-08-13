package com.rahulshettyacacdemy.pageobjects.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{

AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		//we are providing driver of parent to child coz we have to access parent from child
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//driver help to make internally driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productlist; 
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	public List<WebElement> getProductList(){
		
		return productlist;
	}
	
	public double getProductSum() {
		int count = productlist.size();
	    double sum=0;
			for(int i=0;i<count;i++) {
				String amountString = productlist.get(i).getText();
				//$160.46 ->0,1--- index
			double price = getFormatedAmount(amountString);
			sum= sum+price;
	}
			return sum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormatedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	
//	public double  getFormattedAmount(String amount) {
//		double price = Double.parseDouble(amount.substring(1));
//		return price;
//	}
	
	public void submitOrder() {
		proceed.click();
	}
	
	public void checkB0x() {
		checkBox.click();
	}
	
	
	
}
