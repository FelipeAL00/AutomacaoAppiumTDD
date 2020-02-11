package br.com.rsinet.HUB_TDD.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.excelConection.ExcelUtils;
import br.com.rsinet.HUB_TDD.managers.FileReaderManager;
import br.com.rsinet.HUB_TDD.managers.PageObjectManager;
import br.com.rsinet.HUB_TDD.managers.WebDriverManager;
import br.com.rsinet.HUB_TDD.screenObject.HomeScreen;
import br.com.rsinet.HUB_TDD.screenObject.RegisterScreen;
import br.com.rsinet.HUB_TDD.util.DataHoraDiaGenerator;
import br.com.rsinet.HUB_TDD.util.RandomicoParaNome;
import br.com.rsinet.HUB_TDD.util.Report;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TesteCadastro {
	private AppiumDriver<MobileElement> driver;
	private HomeScreen homePage;
	private RegisterScreen registerPage;
	private WebDriverManager manager;
	private PageObjectManager pageObject;
	private ExtentTest test;
	private ExtentReports extent;
	@Before
	public void antes() throws Exception {
		manager = new WebDriverManager();
		driver = manager.getDriver();
		pageObject = new PageObjectManager(driver);
		homePage = pageObject.getHomePage();
		registerPage = pageObject.getRegisterPage();
		extent = Report.getReport();
	}
	
	@Test
	public void deveCadastrarUmUsuarioComSucesso() throws Exception {
		test = Report.createTest("TesteCadastrodeUsuarioComSucesso");
		homePage.clickMenu();
		homePage.clickLogin();
		homePage.clickCriarConta();
		String name = RandomicoParaNome.buscarNomeRandom() + "F";
		
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
		test = Report.createTest("TesteCadastrodeUsuarioComFalha");
		homePage.clickMenu();
		homePage.clickLogin();
		homePage.clickCriarConta();

		registerPage.passarNome(RandomicoParaNome.buscarNomeRandom());
		
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
		
		assertTrue(registerPage.confirmandoSeAsSenhasEstaoErradas("Passwords do not match"));
	}

	@After
	public void fecha() throws IOException {
		Report.statusReported(test,  "testeCadastro_" + DataHoraDiaGenerator.dataHoraParaArquivo(), driver);
		manager.closeDriver();
		System.out.println(extent.getStats());
	}
}
