package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {
	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("Report/result.html");
		reporter.setAppendExisting(true);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test=extent.createTest("Login", "LoginTest for LeafTap Application");
		test.assignCategory("Smoke");
		test.assignAuthor("Sukanya sundar");
		test.pass("Enter UserName");
		test.pass("Enter Password");
		test.pass("click login button",MediaEntityBuilder.createScreenCaptureFromPath(".././Snap/img.png").build());
		extent.flush();
		
	}

}
