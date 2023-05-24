package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Properties prop;
	public String baseurl;
	public WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		/*
		 * The reader function reads the browser name from the data.properties file and
		 * then decision is made by the below given blocks.
		 */
		if (reader().contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
//			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//			options.addArguments("--headless"); // only if you are ACTUALLY running headless
			options.addArguments("--no-sandbox"); // https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-dev-shm-usage"); // https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-browser-side-navigation"); // https://stackoverflow.com/a/49123152/1689770
			options.addArguments("--disable-gpu");
			// Instantiate the chrome driver
			driver.set(new ChromeDriver(options));
		} else if (reader().contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (reader().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
	}
	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		getDriver().quit();
	}

	public String reader() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		return prop.getProperty("browser").toLowerCase();
	}
}