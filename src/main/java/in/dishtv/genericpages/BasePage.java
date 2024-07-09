package in.dishtv.genericpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dishtv.library.BaseLibrary;

public class BasePage extends BaseLibrary{

	public BasePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHomeDishTVCRM() {
		return homeDishTVCRM;
	}

	public void setHomeDishTVCRM(WebElement home) {
		this.homeDishTVCRM = home;
	}

	public WebElement getlogoDishTVCRM() {
		return logoDishTVCRM;
	}

	public void setlogoDishTVCRM(WebElement dishTVLogo) {
		this.logoDishTVCRM = dishTVLogo;
	}
	public WebElement getErrorMessageOnPage() {
		return errorMessageOnPage;
	}


	public WebElement getLogoPhoenixHomepage() {
		return logoPhoenixHomepage;
	}

	public void setLogoPhoenixHomepage(WebElement logoPhoenixHomepage) {
		this.logoPhoenixHomepage = logoPhoenixHomepage;
	}
	public WebElement getWelcomeIconPhoenix() {
		return welcomeIconPhoenix;
	}

	public WebElement getLogoutPhoenix() {
		return logoutPhoenix;
	}
	@FindBy(xpath="//span[text()='Home']")
	private WebElement homeDishTVCRM;
	@FindBy(id="DishTV-Logo")
	private WebElement logoDishTVCRM;
	@FindBy(xpath="//img[@src='/Images/logo3.png']")
	private WebElement logoPhoenixHomepage;
	@FindBy(id="ctl00_ContentPlaceHolder1_lblMessage")
	private WebElement errorMessageOnPage;
	@FindBy(xpath="//small[contains(text(),'Welcome')]")
	private WebElement welcomeIconPhoenix;
	@FindBy(xpath="//a[@href='/Login/Login']")
	private WebElement logoutPhoenix;
}
