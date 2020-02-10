package br.com.rsinet.HUB_TDD.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataHoraDiaGenerator {
	 public static String dataHoraParaArquivo() {
	        Timestamp ts = new Timestamp(System.currentTimeMillis());
	        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
	 }
}
