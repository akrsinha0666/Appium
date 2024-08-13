package org.rahulsherttyavademy.TestUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rahulshettyacademy.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener{
	AppiumDriver driver;
	ExtentTest test ;
	 ExtentReports extent=ExtentReportTEtng.getREportbject() ;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());// this will provide testcasename result.get....
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}
//result hold the information about test method
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		
	
			try {
				driver=(AppiumDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				//upcasting to appiumdriver and taking to the real test clas and their opertaing fiels driver or any fiels like total sum and son on
				//and get the the instance of that 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
			//first wull take the path of report and driver where it is executing and 2nd will take the name of the test case  
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
