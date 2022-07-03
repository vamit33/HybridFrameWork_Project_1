package Com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Com.Base.BaseClass;
import Com.Utilities.DriverUtils;

public class MyListeners extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"Test case passed with the name as "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test case failed with the name as "+ result.getName());
		String path = DriverUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);	
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test case skipped with the name as" + result.getName());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
