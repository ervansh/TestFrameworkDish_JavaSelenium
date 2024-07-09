package in.dishtv.library;
/**
 * @author vanshraj.singh
 */
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

@Listeners(ExtentTestNGIReporterListener.class)
public class BaseLibrary {
	public static WebDriver driver;
	public static void initializeApplication(String url) {
		driver.navigate().to(url);
		int time = Integer.parseInt(PropertiesLib.getPropertyValue("pageloadtime"));
		WaitStatementsLib.pageLoadWait(driver, time);
	}
	@BeforeClass
	@Parameters("browser")
	public void launchBrowser(String browsername) {
		ArrayList<String> al;
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			al = new ArrayList<>();
			al.add("--start-maximized");
			al.add("disable-infobars");
			co.addArguments(al);
			driver = new ChromeDriver(co);
			Reporter.log("Chrome browser has been launched successfully.", true);
			break;

		case "ie":
			System.setProperty("webdriver.chrome.driver", "");
			driver = new InternetExplorerDriver();
			Reporter.log("Internet Explorer browser has been launched successfully.", true);

		default:
			Reporter.log("Given browser does not exits...Please provide a valid browser name.", true);
			break;
		}
	}
	@AfterMethod
	public void resultAnalysis(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		if (result.isSuccess()) {
			ScreenshotsLib.getScreenshot(driver, "passedCases", methodname);
			Reporter.log(methodname.toUpperCase() + " has been passed successfully.", true);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotsLib.getScreenshot(driver, "failedCases", methodname);
			Reporter.log(
					methodname.toUpperCase() + " has been failed. Check log and screenshots in respective folderes.",
					true);
		} else if (result.getStatus() == ITestResult.SKIP) {
			Reporter.log(
					methodname.toUpperCase() + " has been skipped. Check log and screenshots in respective folderes.",
					true);
		}
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
		Reporter.log("Current browser instance has been closed.", true);
	}
}
