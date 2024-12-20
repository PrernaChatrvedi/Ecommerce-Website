package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificMethods;

public class ListenerClass extends ProjectSpecificMethods implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"Test passed");

	}
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		String filepath = null;
		try {
			filepath = screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped");
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


}
