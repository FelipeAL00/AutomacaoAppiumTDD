package br.com.rsinet.HUB_TDD.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AcoesTouchActions {
	@SuppressWarnings("rawtypes")
	private TouchAction action;
	private AndroidDriver<MobileElement> driver;

	@SuppressWarnings("rawtypes")
	public AcoesTouchActions(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		action = new TouchAction(this.driver);
	}

	public void scroll(int xPress, int yPress, int xMove, int yMove) {
		action.press(PointOption.point(xPress, yPress)).moveTo(PointOption.point(xMove, yMove)).release().perform();
	}

	public void scrollNameClick(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))")
				.click();
	}

	public void scrollName(String texto) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ texto + "\").instance(0))");
	}

}
