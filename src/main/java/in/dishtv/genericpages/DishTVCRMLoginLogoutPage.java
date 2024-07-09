package in.dishtv.genericpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.PropertiesLib;

public class DishTVCRMLoginLogoutPage extends BasePage {
	public DishTVCRMLoginLogoutPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlUserType")
	private WebElement ddusertype;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtUserID")
	private WebElement loginuserid;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtPassword")
	private WebElement loginpassword;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnLogin")
	private WebElement btnlogin;
	@FindBy(xpath = "//h3[text()='Sign in ']")
	private WebElement signinpage;
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logout;
	@FindBy(xpath="//span[@class='LargeText']")
	private WebElement logoutmessage;
	@FindBy(xpath="//a[contains(text(),'here')]")
	private WebElement clickHEREtologinagain;
	@FindBy(xpath="//a[@href='ForgotPassword.aspx']")
	private WebElement forgotPasswordCRM;

	public WebElement getDdusertype() {
		return ddusertype;
	}
	public WebElement getLoginuserid() {
		return loginuserid;
	}
	public WebElement getLoginpassword() {
		return loginpassword;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	public WebElement getSigninpage() {
		return signinpage;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getLogoutmessage() {
		return logoutmessage;
	}
	public WebElement getClickHEREtologinagain() {
		return clickHEREtologinagain;
	}
	public WebElement getForgotPasswordCRM() {
		return forgotPasswordCRM;
	}
	public void loginCRM(String usertype, String username, String password) {
		ApplicationUtilities.dropdownTextEqualIgnoreCase(ddusertype, usertype);
		loginuserid.sendKeys(username);
		loginpassword.sendKeys(password);
		ApplicationUtilities.click(btnlogin);
	}
	public void logoutCRM() {
		if(getHomeDishTVCRM().isDisplayed()) {
			ApplicationUtilities.click(logout);
		}
	}
	public void forgotPassword(String usertype, String username, String password) {
		ApplicationUtilities.dropdownTextEqualIgnoreCase(ddusertype, PropertiesLib.getPropertyValue("usertype"));
		loginuserid.sendKeys(username);
		loginpassword.sendKeys(password);
		ApplicationUtilities.click(forgotPasswordCRM);
		//to be continued...
	}
}








