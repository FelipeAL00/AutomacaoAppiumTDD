package br.com.rsinet.HUB_Appium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_Appium.util.AcoesTouchActions;
import io.appium.java_client.android.AndroidDriver;

public class RegisterPage {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	private AcoesTouchActions acoes;
	
	private WebElement element;

	public RegisterPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
		acoes = new AcoesTouchActions(this.driver);
	}

	public void passarNome(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarEmail(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarSenha(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarConfirmacaoSenha(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarPrimeiroNome(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarUltimoNome(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarNumeroTelefone(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);

		acoes.scroll(1059, 1679, 1047, 420);
	}

	public void passarPais(String texto) throws InterruptedException {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/linearLayoutCountry"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}

	public void passarEstado(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarCidade(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);

	}

	public void passarEndereco(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void passarCEP(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(texto);
	}

	public void clicarCheckReceberMensagens() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/checkBoxRecieveOffers"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clicarBtnRegistrar() {
		element = driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();;
	}

	public boolean confirmandoSeAsSenhasEstaoErradas(String texto) {
		element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"));
		acoes.scroll(1056,326,1062,1494);
		if(element.getText().equals(texto))
			return true;
		return false;
	}

}
