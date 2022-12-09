package com.oms.GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MylistenerClass extends BaseUtilityClass implements ITestListener{

	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	FileLibClass fil= new FileLibClass();
	String MethodName;
	WebdriverActionclass webaction;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is Start");
		test=reports.createTest(result.getMethod().getMethodName());
		MethodName=result.getMethod().getMethodName();
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName()+" is Pass",true);
		test.log(Status.PASS,result.getMethod().getMethodName()+" Got Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable().toString(),ExtentColor.RED));
		Reporter.log(result.getMethod().getMethodName()+" Got Failed",true);
		test.log(Status.FAIL,result.getMethod().getMethodName()+" Got Failed");
		
		webaction=new WebdriverActionclass(driver);
		String path = webaction.screenshot_fail(result.getName());
		test.addScreenCaptureFromPath(path);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName()+" Test Case Skipped",true);
		test.log(Status.SKIP,result.getMethod().getMethodName()+" Got Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		webaction=new WebdriverActionclass(driver);
		reporter =new ExtentSparkReporter(System.getProperty("user.dir")+IAutoconstant.Extendreport_PATH+"Extent Report"+".html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("OMS-DEMO");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Created By  ", "Irfan");
		reports.setSystemInfo("Tester Name  ", "Irfan");
		reports.setSystemInfo("Environment  ","QA");
		try {
			reports.setSystemInfo("Browser : ",fil.readPropertyData(PROP_PATH, "Browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		reports.flush();
		
	}	
}
