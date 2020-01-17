package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.DriverFactory;

public class ProductPage {
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getdriver(), 10);
	
	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement btnAddCart;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement btnCheckout;

	@FindBy(how = How.ID, using = "next_btn")
	private WebElement btnNext;

	@FindBy(how = How.NAME, using = "pay_now_btn_MasterCredit")
	private WebElement btnPayNow;

	@FindBy(how = How.XPATH, using = "//*[@id=\"orderPaymentSuccess\"]/h2/span")
	private WebElement messageThankYou;

	@FindBy(how = How.NAME, using = "usernameInOrderPayment")
	private WebElement userName;

	@FindBy(how = How.NAME, using = "passwordInOrderPayment")
	private WebElement password;

	@FindBy(how = How.ID, using = "login_btnundefined")
	private WebElement btnLogin;

	public WebElement getBtnAddCart() {
		return btnAddCart;
	}

	public WebElement getBtnCheckout() {
		return btnCheckout;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getBtnPayNow() {
		return btnPayNow;
	}

	public String getMessageThankYou() {
		wait.until(ExpectedConditions.visibilityOf(messageThankYou));
		return messageThankYou.getText();
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void btnAddCart() {

		wait.until(ExpectedConditions.visibilityOf(btnAddCart));
		btnAddCart.click();
	}

	public void btnCheckout() {
		wait.until(ExpectedConditions.visibilityOf(btnCheckout));
		btnCheckout.click();
	}

	public void userName(String userNameT) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(userNameT);
	}

	public void password(String passwordT) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(passwordT);
	}

	public void btnLogin() {
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		btnLogin.click();
	}

	public void btnNext() {
		wait.until(ExpectedConditions.visibilityOf(btnNext));
		btnNext.click();
	}

	public void btnPayNow() {
		wait.until(ExpectedConditions.visibilityOf(btnPayNow));
		btnPayNow.click();
	}

}
