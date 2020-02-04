package br.com.rsinet.HUB_Appium.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String CAMINHOCONFIG = "config//configuration.properties";
	private BufferedReader reader;

	public ConfigFileReader() {
		try {
			reader = new BufferedReader(new FileReader(CAMINHOCONFIG));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("felipe");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties não existe no caminho " + CAMINHOCONFIG);
		}

	}

	public String getDeviceName() {
		String deviceName = properties.getProperty("deviceName");
		if (deviceName != null)
			return deviceName;

		throw new RuntimeException("deviceName não está especificado em Configuration.properties");

	}
	
	public String getDeviceId() {
		String deviceId = properties.getProperty("udid");
		if (deviceId != null)
			return deviceId;

		throw new RuntimeException(" deviceId não está especificado em Configuration.properties");

	}

	public String getPlatformName() {
		String platformName = properties.getProperty("platformName");
		if (platformName != null)
			return platformName;
		
		throw new RuntimeException("platformName não está especificado em Configuration.properties");
		
	}
	
	public String getPlatformVersion() {
		String platformVersion = properties.getProperty("platformVersion");
		if (platformVersion != null)
			return platformVersion;
		
		throw new RuntimeException("platformVersion não está especificado em Configuration.properties");
		
	}

	public String getAppPackage() {
		String appPackage = properties.getProperty("appPackage");
		if (appPackage != null)
			return appPackage;
		
		throw new RuntimeException("appPackage não está especificado em Configuration.properties");
		
	}
	
	public String getAppActivity() {
		String appActivity = properties.getProperty("appActivity");
		if (appActivity != null)
			return appActivity;
		
		throw new RuntimeException("appActivity não está especificado em Configuration.properties");
		
	}

	public String getURL() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		
		throw new RuntimeException("url não está especificado em Configuration.properties");
	}

	public Boolean getUnicodeKeyboard() {
		String keyBoard = properties.getProperty("UnicodeKeyboard");
		if (keyBoard != null)
			return Boolean.valueOf(keyBoard);
		return true;
	}
	
	public Boolean getResetKeyboard() {
		String keyBoard = properties.getProperty("ResetKeyboard");
		if (keyBoard != null)
			return Boolean.valueOf(keyBoard);
		return true;
	}

	public String getPathExcel() {
		String path = properties.getProperty("PathCaminhoExcel");
		if(path != null)
			return path;
		
		throw new RuntimeException("Path não está especificado em configuration.properties");
	}
		
}
