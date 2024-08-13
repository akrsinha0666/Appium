package com.rahulshettyacademy.utils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;

	public Double getFormatedAmount(String amount) {
    	double price = Double.parseDouble(amount.substring(1));
    	return price;
}
	
	
	public AppiumDriverLocalService startAppiumServer(String ipaddress, int i) {
		service = new AppiumServiceBuilder()
	            .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	            .withIPAddress(ipaddress)
	            .usingPort(i)
	            .build();
	        service.start();
	        return service;
	}
	
	
	//we deleted Appiumdriver constructor coz we donot have to write everytime on child class so we added into 
	// waitelementtoapper so that each time it will access to child class
	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException, IOException{
		//convert json File content to json string
		//jsonFilepath =>System.getProperty("user.dir")+"\\src\\test\\java\\org\\rahulshettyacademy\\testData\\ecommerec.json"
		String jsoncontent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		//user.dir -> is dynamic way to amke the path  
		ObjectMapper mapper = new ObjectMapper();
		//Json String -> HashMAp(jackson) => ObjectMaapper will do this one
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, 
				new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
		}
	//List<HashMap<String,String>> data it will store the list of data set and will return the same 
	

	public void waitForElementToappera(WebElement ele,AppiumDriver driver) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
	}
	public String getScreenshot(String testcasename,AppiumDriver driver) throws Throwable {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//\\reports" +testcasename+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture the screenshot an dplace in folder
		//2 extent report pick file from attach to to report folder
	}
		
	
	
}


