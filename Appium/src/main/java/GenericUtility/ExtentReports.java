
package GenericUtility;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;

public class ExtentReports implements ITestListener{

	com.aventstack.extentreports.ExtentReports report;
	AppiumDriver driver;
	ExtentTest test;
	Date date;

	public void onTestStart(ITestResult result) {
		//3
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//4
		test.log(Status.PASS, result.getMethod().getMethodName()+ " is passed");
	}

	public void onTestFailure(ITestResult result) {
		//5
		String dd = date.toString().replace(":", "-").replace(" ", "-");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			File destination = new File("./Screenshot/"+result.getMethod().getMethodName()+dd+".png");
			FileUtils.copyFile(source, destination);
		} 
		catch (Exception e) {
			e.printStackTrace(); //To print the error
		}
	}

	public void onTestSkipped(ITestResult result) {
		//6
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		//1
		date = new Date();
		String dd = date.toString().replace(":", "-").replace(" ", "-");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(new File("./Reports/extentReports"+dd+".png"));
		htmlReport.config().setDocumentTitle("ExtentReport");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Functional Test");

		//2
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("environment", "Testing Environment");
		report.setSystemInfo("URL", "http://localhost:4723/wd/hub");
		report.setSystemInfo("Reporter Name", "PAVAN");
	}

	public void onFinish(ITestContext context) {
		//7
		report.flush();
	}
}
