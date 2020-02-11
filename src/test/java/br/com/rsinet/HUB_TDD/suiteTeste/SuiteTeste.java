package br.com.rsinet.HUB_TDD.suiteTeste;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rsinet.HUB_TDD.testes.TesteCadastro;
import br.com.rsinet.HUB_TDD.util.Report;

@RunWith(Suite.class)
@SuiteClasses({TesteCadastro.class })

public class SuiteTeste {

	@AfterClass
	public static void finalizaReport() {
		Report.quitExtent();
	}
}
