package br.com.rsinet.HUB_TDD.screenObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.util.AcoesTouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomeScreen {

	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	private MobileElement element;
	private MobileElement element2;
	private MobileElement element3;
	private AcoesTouchActions acoes;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
		acoes = new AcoesTouchActions(this.driver);
	}

	public String getUserLogado() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		return element.getText();
	}

	public void clickMenu() {
		try {
			wait.pollingEvery(Duration.ofSeconds(10));
			element = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (StaleElementReferenceException e) {
			acoes.scrollName("TABLETS");
			element = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
	}

	public void clickLogin() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/linearLayoutLogin"));
		element2 = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element2.getText().equals("LOGIN")) {
			element.click();
		} else {
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
		acoes.scrollNameClick(texto);
	}

	public void pesquisarProdutoLupa(String texto) {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);

		element2 = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewSearch"));
		element2.click();

	}
}
