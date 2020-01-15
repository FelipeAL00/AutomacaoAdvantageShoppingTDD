package br.com.rsinet.hub_TDD.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;

public class ProductAction {
	private static WebDriverWait wait;
	public static void execute(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains("product"));
		wait.until(ExpectedConditions.visibilityOf(ProductPage.btnAddCart));
		ProductPage.btnAddCart.click();
		wait.until(ExpectedConditions.visibilityOf(ProductPage.btnCheckout));
		ProductPage.btnCheckout.click();
		
		wait.until(ExpectedConditions.visibilityOf(ProductPage.userName));
		ProductPage.userName.sendKeys(ExcelUtil.getCellData(1, 1));
		wait.until(ExpectedConditions.visibilityOf(ProductPage.password));
		ProductPage.password.sendKeys(ExcelUtil.getCellData(1, 2));
		wait.until(ExpectedConditions.elementToBeClickable(ProductPage.btnLogin));
		ProductPage.btnLogin.click();
		wait.until(ExpectedConditions.visibilityOf(ProductPage.btnNext));
		ProductPage.btnNext.click();
		

		ProductPage.btnPayNow.click();	
		wait.until(ExpectedConditions.visibilityOf(ProductPage.messageThankYou));
	}
}
