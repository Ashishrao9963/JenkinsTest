package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test START");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test SUCCESS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test FAILURE");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test SKIPPED");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("On Test FAILED WITH TIME OUT");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On START");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On FINISH");
	}
	
	
	
	
}