package TestComponets;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import OrgScreens.Login;
import OrgScreens.OrgTabs;

public class MenuTest {

	@BeforeMethod
	public void login() throws InterruptedException {
		Login log = new Login(BaseTest.getdriver());
		Thread.sleep(Duration.ofSeconds(5));
		log.Login_user_passowrd(Login.username(), Login.Password());
	}

	@Test
	public void hitAdmin() throws IOException {
		OrgTabs ot = new OrgTabs(BaseTest.getdriver());
		OrgTabs.Menu("Admin");
	}

	@Test
	public void hitPerformance() throws IOException, InterruptedException {
		OrgTabs ot = new OrgTabs(BaseTest.getdriver());
		OrgTabs.Menu("Performance");

	}

	@AfterMethod
	public void logoff() {
		Login.userlogout();
	}
}
