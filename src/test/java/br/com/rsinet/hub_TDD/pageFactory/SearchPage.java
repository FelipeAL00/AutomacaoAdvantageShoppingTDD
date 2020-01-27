package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 10);
	}

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement lupaPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement barraPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private WebElement componentText;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/footer/div/h3")
	private WebElement followUS;
	
	@FindBy( how = How.ID, using = "accordionAttrib1")
	private WebElement manufacturer;
	
	@FindBy( how = How.ID, using = "manufacturer_1")
	private WebElement checkManufacturer;
	
	@FindBy( how = How.ID, using = "accordionAttrib2")
	private WebElement weight;
	
	@FindBy( how = How.ID, using = "weight_1")
	private WebElement checkWeight;	
	
	public WebElement linkText(WebDriver driver, String linkText) throws Exception {
		return driver.findElement(By.linkText(linkText));
	}

	public void clicarMassaDados(String linkText) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(linkText(driver, linkText)));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkText(driver, linkText));
		wait.until(ExpectedConditions.urlContains("/product/"));
		wait.until(ExpectedConditions.visibilityOf(followUS));
		executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
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
	
	public void escolherMarca() {
		wait.until(ExpectedConditions.visibilityOf(manufacturer));
		manufacturer.click();
		wait.until(ExpectedConditions.visibilityOf(checkManufacturer));
		checkManufacturer.click();
	}
	
	public void escolherPotencia() {
		wait.until(ExpectedConditions.visibilityOf(weight));
		weight.click();
		wait.until(ExpectedConditions.visibilityOf(checkWeight));
		checkWeight.click();
	}
}
