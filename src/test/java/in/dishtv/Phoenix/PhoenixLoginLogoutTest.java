package in.dishtv.Phoenix;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.dishtv.genericpages.BasePage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.BaseLibrary;
import in.dishtv.library.PropertiesLib;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLoginLogoutTest extends BaseLibrary{
	PhoenixLoginLogoutPage login;
	BasePage base;
	String usertype=PropertiesLib.getPropertyValue("usertypephoenix");
	String userid=PropertiesLib.getPropertyValue("useridphoenix");
	String password=PropertiesLib.getPropertyValue("passwordphoenix");
	String urlphoenix=PropertiesLib.getPropertyValue("urlphoenix");
	
	@Test(enabled=true)
	public void phoenixLoginValidUseridValidPassword() {
		login=new PhoenixLoginLogoutPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, userid, password);
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(base.getLogoPhoenixHomepage().isDisplayed());
	}
	@Test(enabled=true)
	public void phoenixLogout() {
		login=new PhoenixLoginLogoutPage();
		login.logoutPhoenix();
		WaitStatementsLib.waitForSeconds(driver, 10);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(enabled=true)
	public void phoenixLoginInvalidUseridValidPassword() {
		login=new PhoenixLoginLogoutPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, "invalid", password);
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	
	@Test(enabled=true)
	public void phoenixLoginValidUseridInvalidPassword() {
		login=new PhoenixLoginLogoutPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, userid, "invalid");
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(enabled=true)
	public void phoenixLoginBlankValidation(){
		login=new PhoenixLoginLogoutPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		ApplicationUtilities.click(login.getBtnsignin());
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
	@Test(invocationCount=2)
	public void phoenixLoginInValidUseridInvalidPassword() {
		login=new PhoenixLoginLogoutPage();
		base=new BasePage();
		initializeApplication(urlphoenix);
		Assert.assertEquals(driver.getTitle(), "Dishtv Biz");
		login.loginPhoenix(usertype, "invalid", "invalid");
		WaitStatementsLib.pageLoadWait(driver, 180);
		Assert.assertTrue(login.getLogoPhoenixLoginPage().isDisplayed());
	}
}
















