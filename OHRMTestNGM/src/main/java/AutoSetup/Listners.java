package AutoSetup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);

		String testname = result.getName();
		System.out.println(testname + " Started ");
		ScreenShot.TakeSS(testname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String testname = result.getName();
		System.out.println(testname + " Success ");
		ScreenShot.TakeSS(testname);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);

		String testname = result.getName();
		System.out.println(testname + " Failed ");
		ScreenShot.TakeSS(testname);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);

		String testname = result.getName();
		System.out.println(testname + " Skipped");
		ScreenShot.TakeSS(testname);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		System.err.println("Test Failed But Within Success Percentage------->>>>>>");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		System.err.println("Test Failed With Timeout------->>>>>>");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		String Contextname = context.getName();
		System.err.println(Contextname + "Test on Start------->>>>>>");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		String Contextname = context.getName();
		System.err.println(Contextname + " on Finish------->>>>>>");

	}

}
