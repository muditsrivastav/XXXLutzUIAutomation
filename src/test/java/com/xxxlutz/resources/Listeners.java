package com.xxxlutz.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.xxxlutz.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {
  ExtentTest test;
  ExtentReports extentReports = ExtentReporterNG.getReportObject();
  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

  @Override
  public void onTestStart(ITestResult result) {
    test = extentReports.createTest(result.getMethod().getMethodName());
    extentTest.set(test);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    extentTest.get().log(Status.PASS, "Test Passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    //Screenshot
    extentTest.get().fail(result.getThrowable());
    WebDriver driver = null;
    String testMethodName = result.getMethod().getMethodName();
    try {
      driver =
        (WebDriver) result
          .getTestClass()
          .getRealClass()
          .getDeclaredField("driver")
          .get(result.getInstance());
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      extentTest
        .get()
        .addScreenCaptureFromPath(
          getScreenshotPath(testMethodName, driver),
          result.getMethod().getMethodName()
        );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onStart(ITestContext context) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onFinish(ITestContext context) {
    extentReports.flush();
  }
}
