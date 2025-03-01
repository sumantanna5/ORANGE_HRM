package AutoSetup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class BrowserSetup {

	public static WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeSuite
	public void initializedriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void Browserurl() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("HIT URL :" + url);
		ScreenShot.TakeSS("Web Page");

	}

	@AfterSuite
	public void closebroswer() {
		driver.quit();

	}

	public static WebDriver getdriver() {
		return driver;
	}

}
