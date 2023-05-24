package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Webdriver;

public class Helpers extends Webdriver{
	
	public Properties prop;
	
	
	/*
	 * Methods that are being used for every webpage
	 */
	
	public void get_Url() throws IOException {
		if(baseurl!= null) {
			manage_driver();
		}
		else{
			baseurl = assign_url("url");
			manage_driver();
		}
	}
	
	public String assign_url(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		baseurl = prop.getProperty(url);
		return baseurl;
	}

	public void manage_driver() {
		getDriver().get(baseurl);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	public String get_Screenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_File = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(dest_File));
		return dest_File;
	}
	
	
	public void wait_until_element_visible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void wait_until_element_visible(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
}
