package in.dishtv.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WaitStatementsLib {
	static WebDriverWait wait;
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Reporter.log(e.getMessage(), true);
		}
	}
	public static void pageLoadWait(WebDriver driver, int timeSeconds) {
		driver.manage().timeouts().pageLoadTimeout(timeSeconds, TimeUnit.SECONDS);
	}
	public static void waitForSeconds(WebDriver driver, int timeSeconds) {
		driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
	}
	public static void waitForMinutes(WebDriver driver, int timeMinutes) {
		driver.manage().timeouts().implicitlyWait(timeMinutes, TimeUnit.MINUTES);
	}
	public static void waitForVisibilityOfElement(WebDriver driver,WebElement element, int timeSeconds) {
		wait=new WebDriverWait(driver, timeSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForElementToBeClickable(WebDriver driver,WebElement element, int timeSeconds) {
		wait=new WebDriverWait(driver, timeSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}







