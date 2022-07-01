package com.rcb.Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class RcbListener extends TestListenerAdapter {
	
	
	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	 
	  public void onStart(ITestContext testContext) {
		  
		  extentSparkReporter=new ExtentSparkReporter(".//reports//Rcb.html");
		  extentSparkReporter.config().setDocumentTitle("Automation Report");
		  extentSparkReporter.config().setReportName("Rcb Team Testing Report");
		  extentSparkReporter.config().setTheme(Theme.DARK);
		  extentSparkReporter.config().setTimelineEnabled(true);
		  
		  extentReports=new ExtentReports();
		  extentReports.attachReporter(extentSparkReporter);
		  extentReports.setSystemInfo("Host-Name", "Localhost");
		  extentReports.setSystemInfo("Environment", "QA");
		  extentReports.setSystemInfo("User", "Aniket");
		  
	  }

	  
	
	  public void onTestSuccess(ITestResult tr) {
	   
		  extentTest=extentReports.createTest(tr.getName());//creating new entry
		  extentTest.log(Status.PASS,"Passed Test Case is "+tr.getName());//adding log details
	  }

	
	  public void onTestFailure(ITestResult tr) {
		  
	   extentTest=extentReports.createTest(tr.getName());
	   extentTest.log(Status.FAIL,"Failed Test Case is "+tr.getName());
	   extentTest.log(Status.FAIL,"Failed Test Case is Failed because "+tr.getThrowable());
		  
	  }

	
	  public void onTestSkipped(ITestResult tr) {
		  
		  extentTest=extentReports.createTest(tr.getName());
		  extentTest.log(Status.SKIP,"Skipped Test Case is "+tr.getName());
		  
	  }
	
	  public void onFinish(ITestContext testContext) {
		  extentReports.flush();
	  }

}
