package Testng;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed");
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed");
    }

}
