package br.com.rsinet.HUB_TDD.suiteTeste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.aventstack.extentreports.ExtentReports;

import br.com.rsinet.HUB_TDD.testes.TesteBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.testes.TesteCadastro;
import br.com.rsinet.HUB_TDD.testes.TestePesquisaHome;
import br.com.rsinet.HUB_TDD.util.Report;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteBuscaPelaLupa.class, TestePesquisaHome.class })

public class SuiteTeste {
	private static ExtentReports extent;

	@BeforeClass
	public static void inicializaReport() {
		extent = Report.setReport();
	}

	@AfterClass
	public static void finalizaReport() {
		Report.quitExtent(extent);
	}
}
