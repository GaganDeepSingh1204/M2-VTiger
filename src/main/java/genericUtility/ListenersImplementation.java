package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenersImplementation implements ITestListener {
	javaUtility jUtil=new javaUtility();
	String dateTimeStamp=jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	
	ExtentReports report;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"On Test Start Executed");
		Reporter.log(methodName+"On Test Start Executed");
		
		//Adding test method to the extent report
		test=report.createTest(methodName);
		extentTest.set(test);	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"On Test Success Executed");
		Reporter.log(methodName+"On Test Success Executed");
		
		//Logging test info
		//test.log(Status.PASS,methodName+"test successfully executed");
		extentTest.get().log(Status.PASS,methodName+"test successfully executed");
			}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"On Test Failure Executed");
		Reporter.log(methodName+"On Test Failure Executed");
		//Logging test info
//		test.log(Status.FAIL,methodName+"On Test Failure executed");
		extentTest.get().log(Status.FAIL,methodName+"On Test Failure executed");
		//Logging error message
		test.log(Status.INFO, result.getThrowable());
		
		//Taking screenshot when scripts fails
		SeleniumUtility sUtil=new SeleniumUtility();
		try {
		String path=sUtil.takeScreenshot(BaseClass.getDriver(), dateTimeStamp);
		//Attaching screenshot to report
		//test.addScreenCaptureFromPath(path);
		extentTest.get().addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"On Test Skipped Executed");
		Reporter.log(methodName+"On Test Skipped Executed");
		
		//Logging test info
		//test.log(Status.SKIP,methodName +"test skipped");
		extentTest.get().log(Status.SKIP,methodName +"test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start Executed");
		
		//Configuration of Extent Reports
		ExtentSparkReporter reporter= new ExtentSparkReporter(".\\Extent Reports\\report- "+dateTimeStamp+".html");
				reporter.config().setDocumentTitle("VTiger Report");
				reporter.config().setReportName("VTiger CRM Report");
				reporter.config().setTheme(Theme.STANDARD);
				
				//Create an empty report with the configuration
				report=new ExtentReports();
				report.attachReporter(reporter);
				report.setSystemInfo("Base OS", "Windows");
				report.setSystemInfo("Base URL", "https://localhost:8888");
				report.setSystemInfo("Base browser", "Chrome");
				report.setSystemInfo("Reporter", "Gagan");
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("On Finish Executed");
	
	//Flushing the report
	report.flush();
	
	}

}
