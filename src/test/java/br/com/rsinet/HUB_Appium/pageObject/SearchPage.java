package br.com.rsinet.HUB_Appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_Appium.util.AcoesTouchActions;
import io.appium.java_client.android.AndroidDriver;

public class SearchPage {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	private WebElement element;
	private AcoesTouchActions acoes;

	public SearchPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
		acoes = new AcoesTouchActions(driver);
	}

	public void clicandoNoFiltro() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/imageViewFilter"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clicandoNoProduto(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}

	public void clicandoNoPreco() {
		element = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void clicandoParaDiminuirPreco(int xPress, int yPress, int xMove, int yMove) {
		acoes.scroll(xPress, yPress, xMove, yMove);
	}
	
	public void clicandoEmAplicarFiltro() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();		
	}

}
