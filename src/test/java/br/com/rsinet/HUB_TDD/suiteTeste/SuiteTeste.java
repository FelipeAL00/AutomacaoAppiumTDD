package br.com.rsinet.HUB_TDD.suiteTeste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rsinet.HUB_TDD.testes.TesteBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.testes.TesteCadastro;
import br.com.rsinet.HUB_TDD.testes.TestePesquisaHome;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class, 
	TesteBuscaPelaLupa.class,
	TestePesquisaHome.class
})
public class SuiteTeste {
	
}
