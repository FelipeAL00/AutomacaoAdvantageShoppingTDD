package br.com.rsinet.hub_TDD.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class SearchAction {
	private static WebDriverWait wait;
	private static WebElement element;
	private static Actions actions;

	public static void execute(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.lupaPesquisa));
		SearchPage.lupaPesquisa.click();
		actions = new Actions(driver);
		
		String produto = ExcelUtil.getCellData(1, 0);

		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.barraPesquisa));
		SearchPage.barraPesquisa.sendKeys(produto);
		SearchPage.barraPesquisa.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(SearchPage.fecharPesquisa));
		actions.moveToElement(SearchPage.fecharPesquisa).click().perform();

		clicarMassaDados(driver);
	}

	public static void executeHome() throws Exception {

	}

	private static void clicarMassaDados(WebDriver driver) throws Exception {
		element = driver.findElement(By.linkText(ExcelUtil.getCellData(1, 0)));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		actions.click(element).perform();
		
	}
}
