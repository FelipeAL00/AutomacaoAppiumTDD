package br.com.rsinet.HUB_Appium.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement acessarMenu;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutLogin")
	private WebElement login;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement criarConta;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement userLogado;
	
	@FindBy(how = How.ID, using = "android:id/button2")
	private WebElement signOut;
	
	
	public String getUserLogado() {
		return userLogado.getText();
	}
	
	public HomePage(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 10);
	}

	public void clickMenu() {
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(acessarMenu));
		acessarMenu.click();
	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login));
		if(userLogado.getText().equals("LOGIN")) {
			login.click();
		}else {
			login.click();
			signOut.click();
			clickMenu();
			login.click();
		}
		
	}
	
	public void clickCriarConta() {
		wait.until(ExpectedConditions.elementToBeClickable(criarConta));
		criarConta.click();
	}
}
