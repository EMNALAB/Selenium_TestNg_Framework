package test_Data;

import org.testng.annotations.DataProvider;

public class Td_Home {
	@DataProvider(name = "home")
	public Object[][] home() {
		Object[][] obj = new Object[][] { { "Cryptocurrency Prices by Market Cap", "https://www.coingecko.com/" } };
		return obj;
	}

	@DataProvider(name = "newCoin")
	public Object[][] new_Coin() {
		Object[][] obj = new Object[][] {
				{ "New Cryptocurrencies", "https://www.coingecko.com/en/new-cryptocurrencies" } };

		return obj;
	}

}