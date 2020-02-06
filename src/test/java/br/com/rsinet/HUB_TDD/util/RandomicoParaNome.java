package br.com.rsinet.HUB_TDD.util;

import java.util.Random;

import br.com.rsinet.HUB_TDD.excelConection.ExcelUtils;
import br.com.rsinet.HUB_TDD.managers.FileReaderManager;

public class RandomicoParaNome {
	
	public static String buscarNomeRandom() throws Exception {
		ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getPathExcel(), "Usuarios");
		Random rnd = new Random();
		return ExcelUtils.getCellData(rnd.nextInt(ExcelUtils.getRowNum()), 0);
	}
	
}
