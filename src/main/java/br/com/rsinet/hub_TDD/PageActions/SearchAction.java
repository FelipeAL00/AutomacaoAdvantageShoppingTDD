package br.com.rsinet.hub_TDD.pageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class SearchAction {
	private static WebDriverWait wait;
	public static void execute(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.lupaPesquisa));
		SearchPage.lupaPesquisa.click();
		Log.info("clicou na lupa de pesquisa");
		
		String produto = ExcelUtil.getCellData(1, 0);
		Log.info("pegou o produto na massa de dados");
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchPage.barraPesquisa));
		SearchPage.barraPesquisa.sendKeys(produto);
		Log.info("enviou o produto para a barra de pesquisa");
		SearchPage.barraPesquisa.sendKeys(Keys.ENTER);
		Log.info("pesquisou");
		clicarMassaDados(driver);
		Log.info("conseguiu clicar");
	}

	public static void executeHome(WebDriver driver) throws Exception {
		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(HomePage.componentSpeakers));
		HomePage.componentSpeakers.click();
		Log.info("clicou no componete de speaker");

		clicarMassaDados(driver);
		Log.info("conseguiu clicar");
		
	}

	private static void clicarMassaDados(WebDriver driver) throws Exception {
			wait.until(ExpectedConditions.visibilityOf(SearchPage.linkText(driver)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", SearchPage.linkText(driver));
	}

	public static String capturaTextoComparacao() {
		return SearchPage.componentText.getText();
	}
}
