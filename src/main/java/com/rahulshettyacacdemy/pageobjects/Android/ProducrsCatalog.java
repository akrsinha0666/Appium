package com.rahulshettyacacdemy.pageobjects.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProducrsCatalog extends AndroidActions{

AndroidDriver driver;

	
	public ProducrsCatalog(AndroidDriver driver) {
		super(driver);
		//we are providing driver of parent to child coz we have to access parent from child
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//driver help to make internally driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addToCart;
	
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;

	public void AddItemToCartByIndex(int index) {
		addToCart.get(index).click();
		
	}
	
	public CartPage goToCartPage() throws Throwable {
		cart.click();
		Thread.sleep(3000);
		return new CartPage(driver);
	}
		
		
		
		
		
		
		
	
}
