package Preeti.Abhishekwwwww;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo_Cart {
	static ExtentReports extent;
	ExtentTest test;
	static ExtentHtmlReporter htmlReporter;

	@BeforeClass
	public static void startReport() {

		htmlReporter = new ExtentHtmlReporter("P1.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Demo_cart");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Test
	public void test_AlertBox() throws InterruptedException {
		test = extent.createTest("test_AlertBox", "Check valid message or invalide message in alert box");
		System.out.println("dd");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
		WebElement submit = driver.findElement(By.xpath("//input[@name=\"submit\"]"));
		submit.click();
		System.out.println("ddd");
		Thread.sleep(1222);

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		// Assert.assertEquals("Do you really want to delete this Customer?", text);

		if (text.contains("Do you really want to delete this")) {
			test.log(Status.PASS, MarkupHelper.createLabel("Actual Error message is same as expected error message",
					ExtentColor.GREEN));
		} else {

			test.log(Status.PASS, MarkupHelper.createLabel("Actual Error message is not same as expected error message",
					ExtentColor.RED));
		}
		// driver.close();
	}

	@Test
	public void test_login() throws InterruptedException {
		test = extent.createTest("test_Login", "Check Login in case of both field r empty");
		System.out.println("Launch chromebrowser");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// navigate url

		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
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

	}

	@Test
	public void test_InvalidCred() throws InterruptedException {

		test = extent.createTest("test_InvalidCred", "Check Login with invalid passwod");
		System.out.println("Launch chromebrowser");
		System.setProperty("webdriver.chrome.driver", "C:\\MyAbhi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.navigate().refresh();
		driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
		WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
		Thread.sleep(2000);
		Email.sendKeys("preeti@gmail.com"); // valid EmailId
		WebElement Password = driver.findElement(By.xpath("//input[@id='Password']"));
		Password.sendKeys("Password1"); // Invalid Password
		WebElement submit1 = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		submit1.click();// submit
		System.out.println("Verify when we entered invalid password while login customer account");
		Thread.sleep(1222);
		WebElement Text = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
		String Message = Text.getText();
		System.out.println("Getting please enter valid Password");

		// Assert.assertEquals("Login was unsuccessful. Please correct the errors and
		// try again.", Message);
		if (Message.contains("Loginsssss wasssss unsuccessful. Please correct the errors and try again.")) {
			test.log(Status.PASS, MarkupHelper.createLabel("Actual Error message is same as expected error message",
					ExtentColor.GREEN));
		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Actual Error message is same as expected error message",
					ExtentColor.RED));
		}
	}

	@AfterClass
	public static void tearDown() {
		// to write or update test information to reporter
		extent.flush();
	}
}
