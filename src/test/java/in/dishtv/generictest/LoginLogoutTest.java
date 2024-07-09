package in.dishtv.generictest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.dishtv.genericpages.BasePage;
import in.dishtv.genericpages.DishTVCRMLoginLogoutPage;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

public class LoginLogoutTest extends BaseLibrary{
	BasePage  basepage;
	DishTVCRMLoginLogoutPage loginpage;
	String usertype = PropertiesLib.getPropertyValue("usertype");
	String username = PropertiesLib.getPropertyValue("useridcrm");
	String password = PropertiesLib.getPropertyValue("passwordcrm");
	@Test
	public void loginLogout() {
		basepage=new BasePage();
		loginpage=new DishTVCRMLoginLogoutPage();
		initializeApplication(PropertiesLib.getPropertyValue("urlcrm"));
		Assert.assertTrue(driver.getTitle().contains("DishTV"), "Application launched successfully.");
		loginpage.loginCRM(usertype, username, password);
		assertTrue(basepage.getHomeDishTVCRM().isDisplayed());
		WaitStatementsLib.sleep(3000);
		loginpage.logoutCRM();
		Assert.assertTrue(loginpage.getClickHEREtologinagain().isDisplayed());
	}
}
