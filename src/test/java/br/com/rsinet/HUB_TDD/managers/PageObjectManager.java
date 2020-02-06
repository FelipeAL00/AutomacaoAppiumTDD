package br.com.rsinet.HUB_TDD.managers;

import br.com.rsinet.HUB_TDD.screenObject.HomeScreen;
import br.com.rsinet.HUB_TDD.screenObject.RegisterScreen;
import br.com.rsinet.HUB_TDD.screenObject.SearchScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {
	private AppiumDriver<MobileElement> driver;

	private HomeScreen homePage;

	private RegisterScreen registerPage;

	private SearchScreen searchPage;

	public PageObjectManager(AppiumDriver<MobileElement> driver) {

		this.driver = driver;

	}

	public HomeScreen getHomePage() {

		return (homePage == null) ? homePage = new HomeScreen(driver) : homePage;

	}

	public RegisterScreen getRegisterPage() {

		return (registerPage == null) ? registerPage = new RegisterScreen(driver) : registerPage;

	}

	public SearchScreen getSearchPage() {

		return (searchPage == null) ? searchPage = new SearchScreen(driver) : searchPage;

	}
}
