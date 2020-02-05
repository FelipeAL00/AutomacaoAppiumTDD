package br.com.rsinet.HUB_Appium.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	
	private WebElement element;
	private WebElement element2;
	private WebElement element3;
	
	
	public HomePage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
	}
	
	public String getUserLogado() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		return element.getText();
	}

	public void clickMenu() {
		wait.pollingEvery(Duration.ofSeconds(10));
		element = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void clickLogin() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/linearLayoutLogin"));
		element2 = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if(element2.getText().equals("LOGIN")) {
			element.click();
		}else {
			element3 = driver.findElement(By.id("android:id/button2"));
			element.click();
			element3.click();
			clickMenu();
			element.click();
		}
		
	}
	
	public void clickCriarConta() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewSingUpToday"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void clickProdutosHome(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}
}
