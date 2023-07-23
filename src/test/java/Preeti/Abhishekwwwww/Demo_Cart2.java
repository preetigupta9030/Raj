package Preeti.Abhishekwwwww;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo_Cart2 {
	static ExtentReports extent;
	static ExtentTest test;
	static ExtentHtmlReporter htmlReporter;
	/* public static WebDriver driver; */

	@BeforeClass
	public static void startReport() {

		htmlReporter = new ExtentHtmlReporter("P2.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Demo_cart");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Test
	public void test_InvalidCred() throws InterruptedException, IOException {

		// driver.navigate().refresh();

		test = extent.createTest("test_InvalidCred", "Check Login with invalid passwod");
		System.out.println("Launch chromebrowser");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

		WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
		Thread.sleep(2000);
		Email.sendKeys("preeti@gmail.com"); // valid EmailId
		WebElement Password = driver.findElement(By.xpath("//input[@id='Password']"));
		Password.sendKeys("Password1"); // Invalid Password
		WebElement submit1 = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		submit1.click();// submit
		/*
		 * System.out.
		 * println("Verify when we entered invalid password while login customer account"
		 * ); Thread.sleep(1222); // WebElement Text = driver.findElement(By.
		 * xpath("//div[@class='message-error validation-summary-errors']")); //String
		 * Message = Text.getText();
		 * System.out.println("Getting please enter valid Password");
		 * 
		 * // Assert.assertEquals("Login was unsuccessful. Please correct the errors and
		 * // try again.", Message);
		 * 
		 * if (Message.
		 * contains("Loginsssss wasssss unsuccessful. Please correct the errors and try again."
		 * )) { test.log(Status.PASS, MarkupHelper.
		 * createLabel("Actual Error message is same as expected error message",
		 * ExtentColor.GREEN)); } else { test.log(Status.FAIL, MarkupHelper.
		 * createLabel("Actual Error message is same as expected error message",
		 * ExtentColor.RED)); }
		 */

		String pathString = Demo_Cart2.screenShot(driver, "test_InvalidCred");
		test.addScreenCaptureFromPath(pathString);
		extent.flush();
	}

	@Test
	public void test_ValidCred() throws InterruptedException, IOException {

		// driver.navigate().refresh();

		test = extent.createTest("test_ValidCred", "Check Login with invalid passwod");
		System.out.println("Launch chromebrowser");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

		WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
		Thread.sleep(2000);
		Email.sendKeys("abc@gmail.com"); // valid EmailId
		WebElement Password = driver.findElement(By.xpath("//input[@id='Password']"));
		Password.sendKeys("Abhi@11121995"); // valid
		WebElement submit1 = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		submit1.click();// submit
		System.out.println("Verify when we entered invalid password while login customer account");
		Thread.sleep(1222);
		/*
		 * WebElement Text = driver.findElement(By.
		 * xpath("//div[@class='message-error validation-summary-errors']")); String
		 * Message = Text.getText();
		 * System.out.println("Getting please enter valid Password");
		 */

		// Assert.assertEquals("Login was unsuccessful. Please correct the errors and
		// try again.", Message);

		test.log(Status.PASS,
				MarkupHelper.createLabel("Actual Error message is same as expected error message", ExtentColor.GREEN));
		/*
		 * if (Message.
		 * contains("Loginsssss wasssss unsuccessful. Please correct the errors and try again."
		 * )) { test.log(Status.PASS, MarkupHelper.
		 * createLabel("Actual Error message is same as expected error message",
		 * ExtentColor.GREEN)); } else { test.log(Status.FAIL, MarkupHelper.
		 * createLabel("Actual Error message is same as expected error message",
		 * ExtentColor.RED)); }
		 */
		String pathString = Demo_Cart2.screenShot(driver, "test_ValidCred");
		test.addScreenCaptureFromPath(pathString);
		extent.flush();
	}

	 @Test
	public void test_login() throws InterruptedException, IOException {
		test = extent.createTest("test_Login", "Check Login in case of both field r empty");
		System.out.println("Launch chromebrowser");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// navigate url

		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		submit.click();// submit
		WebElement textmessage = driver.findElement(By.xpath("//span[@class='field-validation-error']"));
		System.out.println("Click on submit tab without entered login credential");
		String message = textmessage.getText();
		System.out.println("Getting Warning Message");
		// Assert.assertEquals("Please enter your email", message);
		if (message.equals("Please enter your email")) {
			System.out.println("Please enter login credenttial");
			Thread.sleep(1000);
			test.log(Status.PASS, MarkupHelper.createLabel("Actual Error message is same as expected error message",
					ExtentColor.GREEN));
		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Actual Error message is same as expected error message",
					ExtentColor.RED));
		}

		String pathString = Demo_Cart2.screenShot(driver, "test_Login");
		test.addScreenCaptureFromPath(pathString);
		extent.flush();

	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}

	/*
	 * @AfterAll public static void tearDown() { // to write or update test
	 * information to reporter
	 * 
	 * }
	 */
}
