package br.com.rsinet.HUB_Appium.suiteTeste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.rsinet.HUB_Appium.testes.TesteBuscaPelaLupa;
import br.com.rsinet.HUB_Appium.testes.TesteCadastro;
import br.com.rsinet.HUB_Appium.testes.TestePesquisaHome;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class, 
	TesteBuscaPelaLupa.class,
	TestePesquisaHome.class
})
public class SuiteTeste {

}
