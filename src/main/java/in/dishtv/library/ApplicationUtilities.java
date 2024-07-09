package in.dishtv.library;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class ApplicationUtilities {

	static Select sel;
	public static String StrDt;

	public static void dropdownTextContains(WebElement element, String text) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String txt = webElement.getText();
			if (txt.contains(text)) {
				sel.selectByVisibleText(txt);
				break;
			}
		}
	}

	public static void dropdownTextEqualIgnoreCase(WebElement element, String text) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String txt = webElement.getText();
			if (txt.equalsIgnoreCase(text)) {
				sel.selectByVisibleText(txt);
				break;
			}
		}
	}

	public static void dropdownValue(WebElement element, String value) {
		sel = new Select(element);
		List<WebElement> ops = sel.getOptions();
		for (WebElement webElement : ops) {
			String val = webElement.getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				sel.selectByValue(val);
				break;
			}
		}
	}

	public static void dropdownIndex(WebElement element, int index) {
		sel = new Select(element);
		sel.selectByIndex(index);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String[] split(String inputstring, String regex) {
		return inputstring.split(regex);
	}

	public static String getTextandCloseAlert(WebDriver driver) {
		try {
			boolean acceptNextAlert = true;
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				if (acceptNextAlert) {
					alert.accept();
				} else {
					alert.dismiss();
				}
				return alertText;
			} finally {
				acceptNextAlert = true;
			}
		} catch (Exception e) {
			System.out.println("Alert message clicked.");
		}
		return StrDt;
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			Reporter.log("No Alert Present.", true);
			return false;
		}
	}

	public static void acceptAlert(WebDriver driver) {
		boolean bool = true;
		bool = isAlertPresent(driver);
		if (bool) {
			driver.switchTo().alert().accept();
		}
	}
	
}

















