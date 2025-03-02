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

	@Test(priority = 1)
	public void CreateNewUserwithAdminRole() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("Admin", "Disabled", "A", "Test_User_01");
		admin.DeleteUser();
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRole")
	public void CreateNewUserwithESSRole() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("ESS", "Disabled", "A", "Test_User_02");
		admin.DeleteUser();

	}

	@Test(dependsOnMethods = "CreateNewUserwithESSRole")
	public void CreateNewUserwithAdminRoleAndUserStatusEnable() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("Admin", "Enabled", "A", "Test_User_03");
		admin.DeleteUser();
	}

	@Test(dependsOnMethods = "CreateNewUserwithAdminRoleAndUserStatusEnable")
	public void CreateNewUserwithESSRoleAndUserStatusEnable() {

		AdminTab admin = new AdminTab(BaseTest.getdriver());
		admin.AddUser("ESS", "Enabled", "A", "Test_User_04");
		admin.DeleteUser();

	}
}
