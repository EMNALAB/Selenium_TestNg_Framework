package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class Homepage extends Webdriver{
	public Homepage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	By logo = By.cssSelector(".tw-flex-row>.darkhide img");
	public WebElement app_Logo(){
		return getDriver().findElement(logo);
	}
	
	By dark = By.cssSelector("button>.fas");
	public WebElement dark_Button(){
		return getDriver().findElement(dark);
	}
	
	By dark_a = By.cssSelector(".darktheme");
	public WebElement dark_Assert(){
		return getDriver().findElement(dark_a);
	}
	
	By light = By.cssSelector("button>.fa-sun");
	public WebElement light_Button(){
		return getDriver().findElement(light);
	}
	
	By lang = By.cssSelector(".tw-w-12");
	public WebElement language(){
		return getDriver().findElement(lang);
	}
	
	By main_heading=By.cssSelector(".tw-pb-0");
	public WebElement main_Head(){
		return getDriver().findElement(main_heading);
	}
	
	By new_coins=By.linkText("New Coins");
	public WebElement new_Coins(){
		return getDriver().findElement(new_coins);
	}
	
	By new_coins_head=By.tagName("h1");
	public WebElement new_Coins_Assert() {
		return getDriver().findElement(new_coins_head);
	}
	
	By gainers_losers=By.linkText("Gainers & Losers");
	public WebElement gainers_Losers(){
		return getDriver().findElement(gainers_losers);
	}
	
	By category=By.linkText("Categories");
	public WebElement categories(){
		return getDriver().findElement(category);
	}
	
	By nft=By.cssSelector(".dark\\3Atw-text-white:nth-child(6)");
	public WebElement nfT(){
		return getDriver().findElement(nft);
	}
	
	By defi=By.linkText("DeFi");
	public WebElement deFI(){
		return getDriver().findElement(defi);
	}
	
	By game=By.linkText("Gaming");
	public WebElement Gaming(){
		return getDriver().findElement(game);
	}
	
	By bnb=By.linkText("BNB");
	public WebElement bNB(){
		return getDriver().findElement(bnb);
	}
	
	By solana=By.linkText("Solana");
	public WebElement Solana(){
		return getDriver().findElement(solana);
	}
	
	By Deutsch=By.cssSelector(".flex-row >div:nth-child(1) > .dropdown-item:nth-child(2)");
	public WebElement DeutschLan(){
		return getDriver().findElement(Deutsch);
	}
	
	By English=By.cssSelector(".flex-row >div:nth-child(1) > .dropdown-item:nth-child(1)");
	public WebElement Englishlan(){
		return getDriver().findElement(English);
	}
	
	By aval=By.linkText("Avalanche");
	public WebElement Aval(){
		return getDriver().findElement(aval);
	}
	
	
	By act_curr=By.cssSelector(".active > .justify-content-md-between");
	public WebElement act_Curr(){
		return getDriver().findElement(act_curr);
	}
	
	By currency_dropdown=By.id("currency-selector");
	public WebElement curr_drop(){
		return getDriver().findElement(currency_dropdown);
	}
	
	By main_head = By.xpath("//h1[contains(text(),'Cryptocurrency Prices by Market Cap')]");
	public By header_wait() {
		return main_head;
	}
	
	By new_crypt = By.xpath("//h1[contains(text(),'New Cryptocurrencies')]");
	public WebElement new_crypt() {
		return getDriver().findElement(new_crypt);
	}
}