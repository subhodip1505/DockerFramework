package test.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import test.vendorPortal.utils.Constants;

public class TestListeners implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot driver = (TakesScreenshot)result.getTestContext().getAttribute(Constants.DRIVER);
		String screenShot = driver.getScreenshotAs(OutputType.BASE64);
		String htmlImageFormat = "<img width=700px src='data:img/png;base64,%s'/>";
		String htmlImage = String.format(htmlImageFormat, screenShot);
		Reporter.log(htmlImage);
	}
	

}
