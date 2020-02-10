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

public class TesteBuscaPelaLupa {
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

	@Test
	public void deveEncontrarUmProdutoPelaBusca() throws Exception {
		test = Report.createTest("TestePesquisaLupaSucesso");
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "BuscaLupaSucesso");
		homePage.pesquisarProdutoLupa(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoProduto(ExcelUtils.getCellData(1, 0));
		assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 0).toUpperCase()));
	}

	@Test
	public void naoDeveEncontrarUmProdutoPelaBusca() throws Exception {
		test = Report.createTest("TestePesquisaLupaFalha");
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "BuscaLupaFalha");
		homePage.pesquisarProdutoLupa(ExcelUtils.getCellData(1, 0));
		assertTrue(driver.getPageSource().contains("- No results for \""+ ExcelUtils.getCellData(1, 0)+"\" -"));
	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test,  "testePesquisaLupa_" + DataHoraDiaGenerator.dataHoraParaArquivo(), driver);
		manager.closeDriver();
	}
}
