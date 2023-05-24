package configurations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SnapFunction extends Webdriver{
	
	
	public String get_Screenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_File = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(dest_File));
		return dest_File;
	}
	
	public String getFailed_Screenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_File = System.getProperty("user.dir") + "\\Failed_testcases\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(dest_File));
		return dest_File;
	}
}
