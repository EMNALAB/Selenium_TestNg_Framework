package configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport extends Webdriver{
	static ExtentReports extent;
	public static ExtentReports report_handler() {
		String path = System.getProperty("user.dir")+"\\Extentreports\\reports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Reports");
		reporter.config().setDocumentTitle("Coin Gecko Testing");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("WebBrowser", "Chrome");
		extent.setSystemInfo("Tester", "Shafat Masood");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Role","Guest");
		return extent;
	}
}