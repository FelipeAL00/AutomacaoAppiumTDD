package br.com.rsinet.HUB_TDD.testes;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.excelConection.ExcelUtils;
import br.com.rsinet.HUB_TDD.managers.FileReaderManager;
import br.com.rsinet.HUB_TDD.managers.PageObjectManager;
import br.com.rsinet.HUB_TDD.managers.WebDriverManager;
import br.com.rsinet.HUB_TDD.screenObject.HomeScreen;
import br.com.rsinet.HUB_TDD.screenObject.SearchScreen;
import br.com.rsinet.HUB_TDD.util.DataHoraDiaGenerator;
import br.com.rsinet.HUB_TDD.util.Report;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestePesquisaHome {
	
	private WebDriverManager manager;
	private AppiumDriver<MobileElement> driver;
	private PageObjectManager pageObject;
	private HomeScreen homePage;
	private SearchScreen searchPage;
	private ExtentTest test;
	@Before
	public void inicio() throws MalformedURLException {
		manager = new WebDriverManager();
		driver = manager.getDriver();
		pageObject = new PageObjectManager(driver);
		homePage = pageObject.getHomePage();
		searchPage = pageObject.getSearchPage();
	}
	

	public void deveProcurarUmProdutoPelaHome() throws Exception {
		test = Report.createTest("TestePesquisaHomeSucesso");
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "buscarHomeSucesso");
		homePage.clickProdutosHome(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoProduto(ExcelUtils.getCellData(1, 1));
		assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 1).toUpperCase()));
	}
	
	@Test
	public void naoDeveEncontrarProdutoComValorBaixo() throws Exception {
		test = Report.createTest("TestePesquisaHomeFalha");
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "buscarHomeFalha");
		homePage.clickProdutosHome(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoFiltro();
		searchPage.clicandoNoPreco();
		searchPage.clicandoParaDiminuirPreco(1031, 441, 43, 435);
		searchPage.clicandoEmAplicarFiltro();
		
		assertTrue(driver.getPageSource().contains("- No results -"));
	}
	
	@After
	public void finaliza() throws IOException {
		Report.statusReported(test,  "testePesquisaHome_" + DataHoraDiaGenerator.dataHoraParaArquivo(), driver);
		manager.closeDriver();
	}
	
}
