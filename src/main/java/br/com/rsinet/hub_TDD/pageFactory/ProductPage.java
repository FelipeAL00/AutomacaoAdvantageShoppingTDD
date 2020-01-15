package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage {
	@FindBy(how = How.NAME, using = "save_to_cart")
	public static WebElement btnAddCart;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	public static WebElement btnCheckout;
	
	@FindBy(how = How.ID, using = "next_btn")
	public static WebElement btnNext;
	
	@FindBy(how = How.NAME, using = "masterCredit")
	public static WebElement checkedMasterCredit;

	@FindBy(how = How.ID, using = "creditCard")
	public static WebElement numberCard;
	
	@FindBy(how = How.NAME, using = "cvv_number")
	public static WebElement numberCVV;
	
	@FindBy(how = How.NAME, using = "mmListbox")
	public static WebElement month;
		
	@FindBy(how = How.NAME, using = "yyyyListbox")
	public static WebElement year;
	
	@FindBy(how = How.NAME, using = "cardholder_name")
	public static WebElement name;
	
	@FindBy(how = How.NAME, using = "pay_now_btn_MasterCredit")
	public static WebElement btnPayNow;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"orderPaymentSuccess\"]/h2/span")
	public static WebElement messageThankYou;
	
	@FindBy(how = How.NAME, using = "usernameInOrderPayment")
	public static WebElement userName;
	
	@FindBy(how = How.NAME, using = "passwordInOrderPayment")
	public static WebElement password;
	
	@FindBy(how = How.ID, using = "login_btnundefined")
	public static WebElement btnLogin;
		
}
