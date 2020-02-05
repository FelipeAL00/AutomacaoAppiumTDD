package br.com.rsinet.HUB_Appium.testes;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.com.rsinet.HUB_Appium.excelConection.ExcelUtils;
import br.com.rsinet.HUB_Appium.managers.FileReaderManager;
import br.com.rsinet.HUB_Appium.managers.PageObjectManager;
import br.com.rsinet.HUB_Appium.managers.WebDriverManager;
import br.com.rsinet.HUB_Appium.pageObject.HomePage;
import br.com.rsinet.HUB_Appium.pageObject.SearchPage;
import io.appium.java_client.android.AndroidDriver;

public class TesteBuscaPelaLupa {
	private WebDriverManager manager;
	private AndroidDriver<WebElement> driver;
	private PageObjectManager pageObject;
	private HomePage homePage;
	private SearchPage searchPage;

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
