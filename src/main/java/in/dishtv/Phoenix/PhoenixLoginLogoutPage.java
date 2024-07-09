package in.dishtv.Phoenix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.genericpages.BasePage;
import in.dishtv.library.ApplicationUtilities;
import in.dishtv.library.WaitStatementsLib;

public class PhoenixLoginLogoutPage extends BasePage {

	public PhoenixLoginLogoutPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ddlUserType")
	private WebElement usertypephoenix;
	@FindBy(id = "txtUserID")
	private WebElement useridphoenix;
	@FindBy(id = "Password")
	private WebElement passwordphoenix;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement btnsignin;
	@FindBy(xpath = "//img[@src='../../Images/logo.png']")
	private WebElement logoPhoenixLoginPage;

	public WebElement getUsertypephoenix() {
		return usertypephoenix;
	}

	public WebElement getUseridphoenix() {
		return useridphoenix;
	}

	public WebElement getPasswordphoenix() {
		return passwordphoenix;
	}

	public WebElement getBtnsignin() {
		return btnsignin;
	}

	public WebElement getLogoPhoenixLoginPage() {
		return logoPhoenixLoginPage;
	}

	public void loginPhoenix(String usertype, String userid, String password) {
		ApplicationUtilities.dropdownTextEqualIgnoreCase(usertypephoenix, usertype);
		useridphoenix.sendKeys(userid);
		passwordphoenix.sendKeys(password);
		ApplicationUtilities.click(btnsignin);
	}

	public void logoutPhoenix() {
		WaitStatementsLib.waitForSeconds(driver, 20);
		getWelcomeIconPhoenix().click();
		WaitStatementsLib.waitForSeconds(driver, 10);
		getLogoutPhoenix().click();
	}
}
