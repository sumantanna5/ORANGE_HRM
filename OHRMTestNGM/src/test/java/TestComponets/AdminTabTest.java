package TestComponets;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import OrgScreens.AdminTab;
import OrgScreens.Login;
import OrgScreens.OrgTabs;

public class AdminTabTest extends BaseTest {

	@BeforeTest
	public void AdminMenu() {
		Login log = new Login(BaseTest.getdriver());
		log.Login_user_passowrd(Login.username(), Login.Password());
		OrgTabs ot = new OrgTabs(BaseTest.getdriver());
		try {
			OrgTabs.Menu("Admin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CreateNewUserwithAdminRole() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("Admin", "Disabled", "A", "TestUser01");
		admin.DeleteUser();
	}

	@Test
	public void CreateNewUserwithESSRole() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("ESS", "Disabled", "A", "TestUser02");
		admin.DeleteUser();

	}

	@Test
	public void CreateNewUserwithAdminRoleAndUserStatusEnable() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("Admin", "Enabled", "A", "TestUser03");
		admin.DeleteUser();
	}

	@Test
	public void CreateNewUserwithESSRoleAndUserStatusEnable() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("ESS", "Enabled", "A", "TestUser05");
		admin.DeleteUser();

	}
}
