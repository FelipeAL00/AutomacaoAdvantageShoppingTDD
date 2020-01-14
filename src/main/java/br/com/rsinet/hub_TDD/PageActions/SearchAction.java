package br.com.rsinet.hub_TDD.pageActions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class SearchAction {
	private static WebDriverWait wait;
	private static WebElement element;

	public static void execute(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.lupaPesquisa));
		SearchPage.lupaPesquisa.click();

		String produto = ExcelUtil.getCellData(1, 0);

		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.barraPesquisa));
		SearchPage.barraPesquisa.sendKeys(produto);
		SearchPage.barraPesquisa.sendKeys(Keys.ENTER);

		clicarMassaDados(driver);
	}

	public static void executeHome(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(HomePage.componentSpeakers));
		HomePage.componentSpeakers.click();

		clicarMassaDados(driver);
	}

	private static void clicarMassaDados(WebDriver driver) throws Exception {
		try {
			element = driver.findElement(By.linkText(ExcelUtil.getCellData(1, 0)));
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			String esperado = "No results for \"" + ExcelUtil.getCellData(1, 0) + "\"";
			assertEquals(esperado, capturaTextoComparacao());
		}
	}

	private static String capturaTextoComparacao() {
		return SearchPage.componentText.getText();
	}
}
