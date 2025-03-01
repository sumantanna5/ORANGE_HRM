package TestComponets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import OrgScreens.Login;


public class LoginTest {
	
	WebDriver driver = BaseTest.getdriver();

	@BeforeSuite
	public void LoginWithCorrectUsernamPassword() throws InterruptedException {
		Login log = new Login(BaseTest.getdriver());
		log.Login_user_passowrd(Login.username(), Login.Password());
		Login.userlogout();
	}

	@Test
	public void LoginWithinCorrectUsernamePassword() throws InterruptedException {
		Login log = new Login(BaseTest.getdriver());
		log.Login_user_passowrd("Sumant", "Test");
		driver.navigate().refresh();
		Thread.sleep(Duration.ofSeconds(5));
	}

	@AfterSuite
	public void LoginWithinCorrectUsernameAndCorrectPassword() throws InterruptedException {
		Login log = new Login(BaseTest.getdriver());
		log.Login_user_passowrd("", Login.Password());
	}
	

}
