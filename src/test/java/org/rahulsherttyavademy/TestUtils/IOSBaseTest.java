package org.rahulsherttyavademy.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.pageobject.Ios.Homepage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;
import com.rahulshettyacademy.utils.AppiumUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

          public class IOSBaseTest extends AppiumUtils{
	
        	 
        	  public IOSDriver driver;
        	    public AppiumDriverLocalService service;
        	    public Homepage homepage;

        	    @BeforeClass
        	    public void ConfigurationAppium() throws MalformedURLException, Throwable {
        	        // Start Appium service
        	    	Properties prop= new Properties();
        	    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\rahulshettyacacdemy\\resources\\data.properties");
        	    	prop.load(fis);
        	    	 String ipaddress = prop.getProperty("ipAddress");
        	    	String port = prop.getProperty("port");
        	    	
        	    	
        	        service =  startAppiumServer(ipaddress,Integer.parseInt(port));
        	        
        	        

        	        // Set desired capabilities
        	        XCUITestOptions options = new XCUITestOptions();
        	        options.setDeviceName("iphone 13 Pro");
        	        //options.setApp("C:\\Users\\Admin\\Favorites\\UIKitCatalog.app");
        	       // we have added another coz we are having differnt apk file
        	        options.setApp("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Appium Rahul+ABhshek+PAwan\\\\AppiumTest\\\\src\\\\test\\\\java\\\\resources\\\\TestApp 3 .apk");
        	        options.setPlatformVersion("15.5");// place near below device name 
       //Appium->webDriver Agent-> IOS App (wdriverAgent is middel men to tak to IOs
        	        // Initialize the driver
        	        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        	        
        	        
        	        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	       homepage= new Homepage(driver);
        	    }
        	  


        	    @AfterClass
        	    public void tearDown() {
        	        if (driver != null) {
        	            driver.quit();
        	        }
        	        if (service != null) {
        	            service.stop();
        	        }
}
          }
