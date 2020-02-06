package br.com.rsinet.HUB_TDD.testes;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.HUB_TDD.excelConection.ExcelUtils;
import br.com.rsinet.HUB_TDD.managers.FileReaderManager;
import br.com.rsinet.HUB_TDD.managers.PageObjectManager;
import br.com.rsinet.HUB_TDD.managers.WebDriverManager;
import br.com.rsinet.HUB_TDD.screenObject.HomeScreen;
import br.com.rsinet.HUB_TDD.screenObject.SearchScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TesteBuscaPelaLupa {
	private WebDriverManager manager;
	private AppiumDriver<MobileElement> driver;
	private PageObjectManager pageObject;
	private HomeScreen homePage;
	private SearchScreen searchPage;

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
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "BuscaLupaSucesso");
		homePage.pesquisarProdutoLupa(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoProduto(ExcelUtils.getCellData(1, 0));
		assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 0).toUpperCase()));
	}

	@Test
	public void naoDeveEncontrarUmProdutoPelaBusca() throws Exception {
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "BuscaLupaFalha");
		homePage.pesquisarProdutoLupa(ExcelUtils.getCellData(1, 0));
		assertTrue(driver.getPageSource().contains("- No results for \""+ ExcelUtils.getCellData(1, 0)+"\" -"));
	}

	@After
	public void finaliza() {
		manager.closeDriver();
	}
}
