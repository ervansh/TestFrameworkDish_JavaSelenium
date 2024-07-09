package in.dishtv.generictest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import in.dishtv.genericpages.HomePage;
import in.dishtv.genericpages.DishTVCRMLoginLogoutPage;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

public class HomeTest extends BaseLibrary{
	String usertype = PropertiesLib.getPropertyValue("usertype");
	String username = PropertiesLib.getPropertyValue("username");
	String password = PropertiesLib.getPropertyValue("password");
	

	@Test(groups="links")
	public void verifyAlllinksOnHomeScreen() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage llp=new DishTVCRMLoginLogoutPage();
		HomePage hp=new HomePage();
		llp.loginCRM(usertype, username, password);
		hp.brokenLinks();
	}
	
	@Test(groups="logo")
	public void bannerVerification() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage llp=new DishTVCRMLoginLogoutPage();
		HomePage hp=new HomePage();
		llp.loginCRM(usertype, username, password);
		Assert.assertTrue(hp.getlogoDishTVCRM().isDisplayed(), "Logo on home page is verified successfully.");
		Reporter.log("Logo on home page is verified successfully.", true);
	}
	@Test(groups="home")
	public void homeIconVerification() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage llp=new DishTVCRMLoginLogoutPage();
		HomePage hp=new HomePage();
		llp.loginCRM(usertype, username, password);
		WaitStatementsLib.pageLoadWait(driver, 30);
		Assert.assertTrue(hp.getHomeDishTVCRM().isDisplayed());
		Reporter.log("Home is verified.", true);
	}
}
