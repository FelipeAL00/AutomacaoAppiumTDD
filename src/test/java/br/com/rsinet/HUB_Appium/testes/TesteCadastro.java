package br.com.rsinet.HUB_Appium.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.com.rsinet.HUB_Appium.excelConection.ExcelUtils;
import br.com.rsinet.HUB_Appium.managers.FileReaderManager;
import br.com.rsinet.HUB_Appium.managers.PageObjectManager;
import br.com.rsinet.HUB_Appium.managers.WebDriverManager;
import br.com.rsinet.HUB_Appium.pageFactory.HomePage;
import br.com.rsinet.HUB_Appium.pageFactory.RegisterPage;
import io.appium.java_client.android.AndroidDriver;

public class TesteCadastro {
	private AndroidDriver<WebElement> driver;
	private HomePage homePage;
	private RegisterPage registerPage;
	private WebDriverManager manager;
	private PageObjectManager pageObject;

	@Before
	public void antes() throws Exception {
		manager = new WebDriverManager();
		driver = manager.getDriver();
		pageObject = new PageObjectManager(driver);
		homePage = pageObject.getHomePage();
		registerPage = pageObject.getRegisterPage();
	}

	@Test
	public void deveCadastrarUmUsuarioComSucesso() throws Exception {

		homePage.clickMenu();
		homePage.clickLogin();
		homePage.clickCriarConta();
		String name = registerPage.buscarNomeRandom();
		
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "CadastroSucesso");
		registerPage.passarNome(name);
		registerPage.passarEmail(ExcelUtils.getCellData(1, 0));
		registerPage.passarSenha(ExcelUtils.getCellData(1, 1));
		registerPage.passarConfirmacaoSenha(ExcelUtils.getCellData(1, 2));
		registerPage.passarPrimeiroNome(ExcelUtils.getCellData(1, 3));
		registerPage.passarUltimoNome(ExcelUtils.getCellData(1, 4));
		registerPage.passarNumeroTelefone(ExcelUtils.getCellData(1, 5));
		registerPage.passarPais(ExcelUtils.getCellData(1, 6));
		registerPage.passarEstado(ExcelUtils.getCellData(1, 7));
		registerPage.passarEndereco(ExcelUtils.getCellData(1, 8));
		registerPage.passarCidade(ExcelUtils.getCellData(1, 9));
		registerPage.passarCEP(ExcelUtils.getCellData(1, 10));

		registerPage.clicarCheckReceberMensagens();
		registerPage.clicarBtnRegistrar();
	
		homePage.clickMenu();
		assertEquals(name, homePage.getUserLogado());
	}
	
	@Test
	public void naoDeveCadastrarUsuario() throws Exception {
		homePage.clickMenu();
		homePage.clickLogin();
		homePage.clickCriarConta();

		registerPage.passarNome(registerPage.buscarNomeRandom());
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "CadastroFalha");
		registerPage.passarEmail(ExcelUtils.getCellData(1, 0));
		registerPage.passarSenha(ExcelUtils.getCellData(1, 1));
		registerPage.passarConfirmacaoSenha(ExcelUtils.getCellData(1, 2));
		registerPage.passarPrimeiroNome(ExcelUtils.getCellData(1, 3));
		registerPage.passarUltimoNome(ExcelUtils.getCellData(1, 4));
		registerPage.passarNumeroTelefone(ExcelUtils.getCellData(1, 5));
		registerPage.passarPais(ExcelUtils.getCellData(1, 6));
		registerPage.passarEstado(ExcelUtils.getCellData(1, 7));
		registerPage.passarEndereco(ExcelUtils.getCellData(1, 8));
		registerPage.passarCidade(ExcelUtils.getCellData(1, 9));
		registerPage.passarCEP(ExcelUtils.getCellData(1, 10));

		registerPage.clicarCheckReceberMensagens();
		registerPage.clicarBtnRegistrar();
		
	}

	@After
	public void fecha() {
		driver.quit();
	}
}
