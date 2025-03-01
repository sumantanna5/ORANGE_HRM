package TestComponets;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AutoSetup.ScreenShot;
import ORGResue.DataRetrive;

public class BaseTest {

	static WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeSuite
	public void initializedriver() throws IOException {

		if (DataRetrive.getDataGlobal("Browser").equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (DataRetrive.getDataGlobal("Browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	@BeforeTest
	public void launchApplication() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("HIT URL :" + url);
		ScreenShot ss = new ScreenShot(driver);
		ScreenShot.TakeSS("url");
	}

	@AfterSuite
	public void closebroswer() {
		driver.quit();

	}
	
	public static WebDriver getdriver()
	{
		return driver;
	}

}
