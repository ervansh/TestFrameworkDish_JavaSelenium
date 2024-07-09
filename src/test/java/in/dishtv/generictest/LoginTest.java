package in.dishtv.generictest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import in.dishtv.genericpages.BasePage;
import in.dishtv.genericpages.DishTVCRMLoginLogoutPage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

public class LoginTest extends BaseLibrary {
	String usertype = PropertiesLib.getPropertyValue("usertype");
	String username = PropertiesLib.getPropertyValue("username");
	String password = PropertiesLib.getPropertyValue("password");
	String alerttext;

	@Test(enabled = true)
	public void loginwithValidUserIDPassword() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage lp = new DishTVCRMLoginLogoutPage();
		BasePage bp = new BasePage();
		lp.loginCRM(usertype, username, password);
		Assert.assertTrue(bp.getHomeDishTVCRM().isDisplayed());
		Reporter.log("Login successful.", true);
	}

	@Test(enabled = true)
	public void loginBlankCredentials() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage lp = new DishTVCRMLoginLogoutPage();
		lp.loginCRM(usertype, "", "");
		WaitStatementsLib.sleep(2000);
		alerttext = ApplicationUtilities.getTextandCloseAlert(driver);
		Reporter.log(alerttext + " is alert message", true);
	}

	@Test(enabled = true)
	public void login_InvalidUserIdValidPassword() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage lp = new DishTVCRMLoginLogoutPage();
		lp.loginCRM(usertype, "invalid", password);
		WaitStatementsLib.sleep(2000);
		alerttext = ApplicationUtilities.getTextandCloseAlert(driver);
		Reporter.log(alerttext + " is alert message", true);

	}

	@Test(enabled = true)
	public void login_ValidUserIDInvalidPassword() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage lp = new DishTVCRMLoginLogoutPage();
		lp.loginCRM(usertype, username, "invalid");
		WaitStatementsLib.sleep(2000);
		alerttext = ApplicationUtilities.getTextandCloseAlert(driver);
		Reporter.log(alerttext + " is alert message", true);
	}
	@Test(enabled = true)
	public void login_InvalidUserIDIandPassword() {
		initializeApplication(PropertiesLib.getPropertyValue("URL"));
		DishTVCRMLoginLogoutPage lp = new DishTVCRMLoginLogoutPage();
		lp.loginCRM(usertype, "invalid", "invalid");
		WaitStatementsLib.sleep(2000);
		alerttext = ApplicationUtilities.getTextandCloseAlert(driver);
		Reporter.log(alerttext + " is alert message", true);
	}


}







