package test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.Helpers;
import page_Object.Homepage;
import test_Data.Td_Home;

public class Navigation extends Webdriver {
	Homepage hm = new Homepage(getDriver());
	Helpers sf = new Helpers();

	@Test(priority = 1, testName = "TC_01", dataProvider = "home", dataProviderClass = Td_Home.class)
	public void TC01_Verify_the_user_is_redirected_to_the_homepage_when_he_access_the_link(String heading, String url)
		throws IOException {
		// Navigate to the site url
		sf.get_Url();
		// Wait until the element is visible
		sf.wait_until_element_visible(getDriver(), hm.header_wait());
		// Assert the h1 tag text on homepage
		Assert.assertEquals(hm.main_Head().getText(), heading);
		// Assert the url
		Assert.assertEquals(getDriver().getCurrentUrl(), url);
	}

	@Test(priority = 2, retryAnalyzer = configurations.Rerun_Testcase.class, testName = "TC_02", dataProvider = "newCoin", dataProviderClass = Td_Home.class)
	public void TC02_Verify_that_the_new_Coins_tab_is_clickable(String heading, String url) throws IOException {
		// Navigate to the site url
		sf.get_Url();
		// Click on the New Coins tab
		hm.new_Coins().click();
		// Wait until the element is visible
		sf.wait_until_element_visible(getDriver(), hm.new_crypt());
		// Assert Text
		Assert.assertEquals(hm.new_crypt().getText(),heading);
	}
}