package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.DriverFactory;



public class SearchPage {
	
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getdriver(), 10);
	
	@FindBy(how = How.ID, using = "menuSearch")
	private  WebElement lupaPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private  WebElement barraPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private  WebElement componentText;

	public  WebElement linkText(WebDriver driver, String linkText) throws Exception {
		return driver.findElement(By.linkText(linkText));
	}
	public void clicarMassaDados(WebDriver driver, String linkText) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(linkText(driver, linkText)));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkText(driver, linkText));
	}
	public String getComponentText() {
		return componentText.getText();
	}
	public void lupaPesquisa() {
		wait.until(ExpectedConditions.visibilityOf(lupaPesquisa));
		lupaPesquisa.click();		
	}
	public void barraPesquisa(String produto) {
		wait.until(ExpectedConditions.visibilityOf(barraPesquisa));		
		barraPesquisa.sendKeys(produto);
	}
	public void barraPesquisa(Keys enter) {
		wait.until(ExpectedConditions.visibilityOf(barraPesquisa));
		barraPesquisa.sendKeys(enter);		
	}

}
