package br.com.rsinet.HUB_Appium.util;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AcoesTouchActions {
	@SuppressWarnings("rawtypes")
	private TouchAction action;
	
	@SuppressWarnings("rawtypes")
	public AcoesTouchActions(AndroidDriver<WebElement> driver) {
		action = new TouchAction(driver);
	}

	public void scroll(int xPress, int yPress, int xMove, int yMove) {
		action.press(PointOption.point(xPress, yPress)).moveTo(PointOption.point(xMove, yMove)).release().perform();
	}

	
}
