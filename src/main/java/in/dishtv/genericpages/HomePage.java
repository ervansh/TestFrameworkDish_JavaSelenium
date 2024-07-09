package in.dishtv.genericpages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "a")
	private List<WebElement> links;
	@FindBy(xpath="//span[text()='Home']")
	private WebElement home;

	public void brokenLinks() {
		Reporter.log("Total no of links present on the current webpage are :"+String.valueOf(links.size()), true);
		for (WebElement webElement : links) {
			String url = webElement.getAttribute("href");
			verifyUrls(url);
		}
	}

	public void verifyUrls(String urlLink) {
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				Reporter.log(urlLink + " - " + httpConn.getResponseMessage(), true);
			}
			if (httpConn.getResponseCode() == 404) {
				Reporter.log(urlLink + " - " + httpConn.getResponseMessage(), true);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
	}
}






