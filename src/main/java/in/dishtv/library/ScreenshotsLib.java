package in.dishtv.library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

public class ScreenshotsLib {
	private static String PATH;
	public static void getScreenshot(WebDriver driver, String foldername, String filename) {
		PATH="\\screenshots\\"+foldername+"\\";
		EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		File scrfile = efw.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+PATH+filename+".png"));
		} catch (IOException e) {
			Reporter.log(e.getLocalizedMessage(), true);
		}
	}
	
	
}
