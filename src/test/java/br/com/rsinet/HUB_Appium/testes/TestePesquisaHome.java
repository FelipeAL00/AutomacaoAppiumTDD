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

public class TestePesquisaHome {
	
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
	public void deveProcurarUmProdutoPelaHome() throws Exception {
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "buscarHomeSucesso");
		homePage.clickProdutosHome(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoProduto(ExcelUtils.getCellData(2, 0));
		assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(2, 0)));
	}
	
	@Test
	public void naoDeveEncontrarProdutoComValorBaixo() throws Exception {
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "buscarHomeFalha");
		homePage.clickProdutosHome(ExcelUtils.getCellData(1, 0));
		searchPage.clicandoNoFiltro();
		searchPage.clicandoParaDiminuirPreco(1031, 441, 43, 435);
		searchPage.clicandoEmAplicarFiltro();
		
		assertTrue(driver.getPageSource().contains("- No results -"));
	}
	
	@After
	public void finaliza() {
		manager.closeDriver();
	}
	
}
