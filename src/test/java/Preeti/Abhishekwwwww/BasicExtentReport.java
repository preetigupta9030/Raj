package Preeti.Abhishekwwwww;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReport {

	// builds a new report using the html template
	static ExtentHtmlReporter htmlReporter;

	static ExtentReports extent;
	// helps to generate the logs in test report.
	ExtentTest test;

	@BeforeClass
	public static void startReport() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter("Result.html");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// To add system or environment info by using the setSystemInfo method.

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		// htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a
		// '('zzz')'");
	}

	@Test
	public void testCase1() {
		test = extent.createTest("Test Case Name 1", "Test case Description 1");
		test.log(Status.PASS, MarkupHelper.createLabel("Test case1 log /Detail ", ExtentColor.GREEN));

	}

	@Test
	public void testCase2() {
		test = extent.createTest("Test Case Name 2", "Test case Description 2");
		test.log(Status.PASS, MarkupHelper.createLabel("Test case2 log /Detail ", ExtentColor.GREEN));
	}

	@Test
	public void testCase3() {
		test = extent.createTest("Test Case Name 3", "Test case Description 3");
		test.log(Status.PASS, MarkupHelper.createLabel("Test case3 log /Detail", ExtentColor.GREEN));
	}

	@AfterClass
	public static void tearDown() {
		// to write or update test information to reporter
		extent.flush();
	}

}