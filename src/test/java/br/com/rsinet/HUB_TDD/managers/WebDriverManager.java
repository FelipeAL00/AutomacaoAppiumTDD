package br.com.rsinet.HUB_TDD.managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WebDriverManager {
	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities caps;

	public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		if (driver == null)
			driver = createDriver();
		return (AndroidDriver<MobileElement>) driver;
	}

	private AndroidDriver<MobileElement> createDriver() throws MalformedURLException {
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDeviceName());
		caps.setCapability("udid", FileReaderManager.getInstance().getConfigReader().getDeviceId());
		caps.setCapability("platformName", FileReaderManager.getInstance().getConfigReader().getPlatformName());
		caps.setCapability("platformVersion", FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
		caps.setCapability("appPackage",FileReaderManager.getInstance().getConfigReader().getAppPackage());
		caps.setCapability("appActivity", FileReaderManager.getInstance().getConfigReader().getAppActivity());
		caps.setCapability("unicodeKeyboard", FileReaderManager.getInstance().getConfigReader().getUnicodeKeyboard());
		caps.setCapability("resetKeyboard", FileReaderManager.getInstance().getConfigReader().getResetKeyboard());
		
		URL url = new URL(FileReaderManager.getInstance().getConfigReader().getURL());
		
		driver = new AndroidDriver<MobileElement>(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return (AndroidDriver<MobileElement>) driver;
	}

	public void closeDriver() {
		if (driver == null) {
			throw new NullPointerException("Driver não iniciado");
		}
		
		driver.quit();
	}
}
