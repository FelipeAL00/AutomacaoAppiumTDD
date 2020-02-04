package br.com.rsinet.HUB_Appium.managers;

import org.openqa.selenium.WebElement;

import br.com.rsinet.HUB_Appium.pageFactory.HomePage;
import br.com.rsinet.HUB_Appium.pageFactory.ProductPage;
import br.com.rsinet.HUB_Appium.pageFactory.RegisterPage;
import br.com.rsinet.HUB_Appium.pageFactory.SearchPage;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {
	private AndroidDriver<WebElement> driver;
	 
	 private ProductPage productPage;
	 	 
	 private HomePage homePage;
	 
	 private RegisterPage registerPage;
	 
	 private SearchPage searchPage;
	 
	 
	 
	 public PageObjectManager(AndroidDriver<WebElement> driver) {
	 
		this.driver = driver;
	 
	 }
	 
	 
	 
	 public HomePage getHomePage(){
	 
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	 
	 }
	 
	 
	 
	 public ProductPage getProductPage() {
	 
		 return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	 
	 }
	 
	 
	 
	 public RegisterPage getRegisterPage() {
	 
		 return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
	 
	 }
	 
	 
	 
	 public SearchPage getSearchPage() {
	 
		 return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
	 
	 }
}
