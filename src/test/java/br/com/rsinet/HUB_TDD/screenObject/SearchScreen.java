package br.com.rsinet.HUB_TDD.screenObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.util.AcoesTouchActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchScreen {
	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	private MobileElement element;
	private AcoesTouchActions acoes;

	public SearchScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
		acoes = new AcoesTouchActions(this.driver);
	}

	public void clicandoNoFiltro() {
		wait.pollingEvery(Duration.ofSeconds(5));
		element = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewFilter"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
	}

	public void clicandoNoProduto(String texto) {
		acoes.scrollNameClick(texto);
	}

	public void clicandoNoComponenteFiltro(String texto) {
		try {
			element =((AndroidDriver<MobileElement>) driver)
					.findElementByAndroidUIAutomator("new UiSelector().text(\"" + texto + "\")");

			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();

		} catch (NoSuchElementException e) {
			((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"CANCEL\")")
			.click();
			clicandoNoFiltro();
			element = ((AndroidDriver<MobileElement>) driver)
					.findElementByAndroidUIAutomator("new UiSelector().text(\"" + texto + "\")");

			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.click();
		}
	}

	public void clicandoParaDiminuirPreco(int xPress, int yPress, int xMove, int yMove) {
		acoes.scroll(xPress, yPress, xMove, yMove);
	}

	public void clicandoEmAplicarFiltro() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public boolean capturarMessage(String texto) {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow"));
		wait.until(ExpectedConditions.textToBePresentInElement(element, "- No results for \"" + texto + "\" -" ));
		if(driver.getPageSource().contains("- No results for \"" + texto + "\" -")) {
			return true;
		}
		return false;
	}

}
