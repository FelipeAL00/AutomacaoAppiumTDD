package br.com.rsinet.HUB_Appium.pageFactory;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_Appium.excelConection.ExcelUtils;
import br.com.rsinet.HUB_Appium.managers.FileReaderManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class RegisterPage {

	@SuppressWarnings("rawtypes")
	private TouchAction action;
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarNome;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarEmail;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarSenha;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarConfirmacaoSenha;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement passarPrimeiroNome;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement passarUltimoNome;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarNumeroTelefone;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout")
	private WebElement passarPais;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarEstado;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement passarEndereco;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement passarCidade;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement passarCEP;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/checkBoxRecieveOffers")
	private WebElement checkBoxReceberEmails;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement btnRegistrar;

	@SuppressWarnings("rawtypes")
	public RegisterPage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 10);
		action = new TouchAction(driver);
	}

	public void passarNome(String texto) {
		wait.until(ExpectedConditions.visibilityOf(passarNome));
		passarNome.click();
		passarNome.sendKeys(texto);
	}

	public void passarEmail(String texto) {
		wait.until(ExpectedConditions.visibilityOf(passarEmail));
		passarEmail.click();
		passarEmail.sendKeys(texto);
	}

	public void passarSenha(String texto) {
		wait.until(ExpectedConditions.visibilityOf(passarSenha));
		passarSenha.click();
		passarSenha.sendKeys(texto);
	}

	public void passarConfirmacaoSenha(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarConfirmacaoSenha));
		passarConfirmacaoSenha.click();
		passarConfirmacaoSenha.sendKeys(texto);
	}

	public void passarPrimeiroNome(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarPrimeiroNome));
		passarPrimeiroNome.click();
		passarPrimeiroNome.sendKeys(texto);
	}

	public void passarUltimoNome(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarUltimoNome));
		passarUltimoNome.click();
		passarUltimoNome.sendKeys(texto);
	}

	public void passarNumeroTelefone(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarNumeroTelefone));
		passarNumeroTelefone.click();
		passarNumeroTelefone.sendKeys(texto);

		scroll(1059, 1679, 1047, 420);
	}

	public void passarPais(String texto) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(passarPais));
		passarPais.click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();

	}

	public void passarEstado(String texto) {
		wait.until(ExpectedConditions.visibilityOf(passarEstado));
		passarEstado.click();
		passarEstado.sendKeys(texto);
	}

	public void passarCidade(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarCidade));
		passarCidade.click();
		passarCidade.sendKeys(texto);

	}

	public void passarEndereco(String texto) {

		wait.until(ExpectedConditions.visibilityOf(passarEndereco));
		passarEndereco.click();
		passarEndereco.sendKeys(texto);
	}

	public void passarCEP(String texto) {
		wait.until(ExpectedConditions.visibilityOf(passarCEP));
		passarCEP.click();
		passarCEP.sendKeys(texto);

	}

	public void clicarCheckReceberMensagens() {
		wait.until(ExpectedConditions.visibilityOf(checkBoxReceberEmails));
		checkBoxReceberEmails.click();
	}

	public void clicarBtnRegistrar() {
		wait.until(ExpectedConditions.visibilityOf(btnRegistrar));
		btnRegistrar.click();
	}

	private void scroll(int xPress, int yPress, int xMove, int yMove) {
		action.press(PointOption.point(xPress, yPress)).moveTo(PointOption.point(xMove, yMove)).release().perform();
	}

	public String buscarNomeRandom() throws Exception {
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "Usuarios");
		Random rnd = new Random();
		return ExcelUtils.getCellData(rnd.nextInt(ExcelUtils.getRowNum()), 0);
	}
}
