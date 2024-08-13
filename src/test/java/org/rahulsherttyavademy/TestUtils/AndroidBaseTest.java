package org.rahulsherttyavademy.TestUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;
import com.rahulshettyacacdemy.pageobjects.Android.FormPage;
import com.rahulshettyacademy.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

          public class AndroidBaseTest extends AppiumUtils {
	
        	 
			public AndroidDriver driver;
        	    public AppiumDriverLocalService service;
        	   public  FormPage formpage ;
        	   

        	    @BeforeClass(alwaysRun=true)// it bypass group filter and run always
        	    public void ConfigurationAppium() throws MalformedURLException, Throwable {
        	        // Start Appium service
        	    	Properties prop= new Properties();
        	    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\rahulshettyacacdemy\\resources\\data.properties");
        	    	prop.load(fis);
        	    	 String ipaddress = prop.getProperty("ipAddress");
        	    	String port = prop.getProperty("port");
        	    	
        	    	
        	        service =  startAppiumServer(ipaddress,Integer.parseInt(port));
        	        

        	        // Set desired capabilities
        	        UiAutomator2Options options = new UiAutomator2Options();
        	        options.setDeviceName(prop.getProperty("AndroidDeviceName"));//emulator
        	       // options.setDeviceName("Android Device");//real device will show
        	        //it will tell which device is connected to computer through USB
        	        // go to developer.chrome.com/docs/devtools/remte-debugging 
        	        //Remote debug Android devices andd go to developer options by clicking on the link
        	        options.setChromedriverExecutable("C:\\\\Users\\\\Admin\\\\Favorites\\\\chromedriver.exe");
  // This above code for chromedriver is used for hybrid app
        	        
        	        // Correct the file path for the APK
//        	        File apk = new File(System.getProperty("user.dir")+"src\\test\\resources\\org.ragulshettyacademy.resources\\General-Store .apk");
//        	        options.setApp(apk.getAbsolutePath());
        	        File apk = new File("C:\\Users\\Admin\\eclipse-workspace\\Appium Rahul+ABhshek+PAwan\\Appiumframework\\src\\test\\resources\\org.ragulshettyacademy.resources\\General-Store.apk");
        	        options.setApp(apk.getAbsolutePath());

        	        // Initialize the driver
        	        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723"), options);
        	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	        formpage = new FormPage(driver);
        	       //initalization also take place in base test after driver , it will go to form page
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
