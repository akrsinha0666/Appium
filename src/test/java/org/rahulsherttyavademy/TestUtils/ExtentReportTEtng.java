package org.rahulsherttyavademy.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTEtng {

	static ExtentReports extent;
	public static  ExtentReports getREportbject() {
		//ExtentReports ,ExtentSparkReporter
				//ExtentSparkReporter is a helping class which helps extentreports to set the path for reports
				//extentReportsv is main class
				String path = System.getProperty("user.dir")+"\\reports\\index.html" ;
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				 extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Abhshek kumar Sinha");
				return extent;
		
	}
}
