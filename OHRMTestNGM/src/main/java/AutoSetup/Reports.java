package AutoSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;

	public static ExtentReports createInstance(String filePath) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(filePath);

		// Set theme, document title, and report name
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		spark.config().setReportName("Automation Test Report");

		// Add custom CSS to include background images
		String css = "body { background-image: url('path/to/your/image.jpg'); background-size: cover; }";
		spark.config().setCss(css);

		extent.attachReporter(spark);
		return extent;
	}

	public static void main(String[] args) {



	        // Initialize ExtentReports using HtmlReportConfig
	        ExtentReports extent = Reports.createInstance("target/Report.html");

	        // Initialize WebDriver
	        ChromeOptions options = new ChromeOptions();
	        driver = new ChromeDriver(options);

	        // Create a test in the report
	        test = extent.createTest("Google Search test");
	        driver.get("https://www.google.com");
	        test.info("Navigate to Google Search");

	        // Capture and log the page title
	        String pageTitle = driver.getTitle();
	        test.info("Page Title Captured: " + pageTitle);

	        // Close the report and the browser
	        extent.flush();
	        driver.quit();
	}

}
