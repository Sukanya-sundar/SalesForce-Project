package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ProjectBase {
	public EdgeDriver driver;
	public String excelFile;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public String testName, testDescription, testCategory, testAuthor;
	public EdgeOptions option;

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("Report/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest("testName", "TestDescription");
		test.assignCategory("testCategory");
		test.assignAuthor("testAuthor");
	}

	public int takeScreenShot() throws IOException {
		int random = (int) (Math.random() * 99999 + 10000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Snap/img" + random + ".png");
		FileUtils.copyFile(source, dest);
		return random;
	}

	public void reportStep(String status, String stepDest) throws IOException {
		if (status.equalsIgnoreCase("Pass")) {
			node.pass(stepDest, MediaEntityBuilder
					.createScreenCaptureFromPath(".././Snap/img" + takeScreenShot() + ".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepDest, MediaEntityBuilder
					.createScreenCaptureFromPath(".././Snap/img" + takeScreenShot() + ".png").build());
		}
	}

	@BeforeMethod
	public void LaunchBrowser() {
		node = test.createNode(testName);
		 option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		driver = new EdgeDriver (option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		String[][] readData = utils.ReadExcel.readData(excelFile);
		return readData;

	}

}
