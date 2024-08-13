package org.rahulsherttyavademy;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulsherttyavademy.TestUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rahulshettyacacdemy.pageobjects.Android.CartPage;
import com.rahulshettyacacdemy.pageobjects.Android.FormPage;
import com.rahulshettyacacdemy.pageobjects.Android.ProducrsCatalog;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerce_tc_3 extends AndroidBaseTest{
	
	public Ecommerce_tc_3() {
        // No-argument constructor for TestNG
    }

	AppiumDriver driver;
	public Ecommerce_tc_3(AppiumDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test(dataProvider = "getData" , groups= {"Smoke"})
	public void FillForm(HashMap<String,String> input) throws Throwable {
		
	
	// FormPage formpage = new FormPage(driver);
		formpage.setNameFiled(input.get("name"));
		formpage.setGender(input.get("gender"));
		formpage.setCountrySelection(input.get("country"));
		ProducrsCatalog productcatalog =formpage.submitform();
		//reeturn productcatalog thats it 
		//ProducrsCatalog  productcatalog = new ProducrsCatalog(driver) ;
		//This is not required coz it takes return from formpage and we have driver in this alredy
		 productcatalog.AddItemToCartByIndex(0);
		 productcatalog.AddItemToCartByIndex(0);
		 CartPage cartPage = productcatalog.goToCartPage();
		
		 //Thread.sleep(4000);
		
		 double totalsum = cartPage.getProductSum();
		 Double displayformatedsum = cartPage.getTotalAmountDisplayed();
		
		
		//android.widget.Toast => this is used for popup or error message to get the text
		//if more error mesage is there we have to go for index
//		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
//		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
		//driver.findElements(By.xpath("\\android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//both are same coz they have added to cart and only one left thats why we are doing the same process
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
			//This wait is for waiting for another page is fully loaded
//				Thread.sleep(3000);
		
		Assert.assertEquals(totalsum,displayformatedsum);
		cartPage.acceptTermsConditions();
		cartPage.checkB0x();
		cartPage.submitOrder();
		
	}
	@BeforeMethod(alwaysRun=true)
	public void preSetup() {
		formpage.setActivity();
	}
//	@BeforeMethod
//    public void preSetup() {
//        // Reset app to start with a clean state
//        driver.resetApp();
//        formpage = new FormPage(driver); // Re-initialize the page object after app reset
//	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>>	 data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\rahulshettyacademy\\testData\\ecommerec.json");
		return new Object [][] { {data.get(0)},{data.get(1)}};
		//this is single data set and parametrized
		//when @nd dataset will run , it will run where first test data is finished nit inital 
		// Thats the problem , how will be resolved , By adding BeforeMethod
		// we can use dataset in json and excel is outdated , we can use this json to provide daatset
		
		//{{hashmapobject1dataset1},{hashmapobject1dataset2} data => hashobject  is stored in data and we dirrectly can get by using data.get(index)
		//internally key-pair value -> name :Abhishek then using data.
	}
	
	
	
	
	
	
	
	
	
	
}
