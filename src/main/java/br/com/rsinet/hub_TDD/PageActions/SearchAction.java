package br.com.rsinet.hub_TDD.PageActions;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.SearchPage;

public class SearchAction {
	public static void execute(WebDriver driver) throws Exception {
		driver.manage().window().maximize();
		SearchPage.clicar("menuSearch", driver);

		SearchPage.escrever("autoComplete", driver, ExcelUtil.getCellData(1, 0));

		SearchPage.clicarPorMassaDados(ExcelUtil.getCellData(1, 0), driver);

	}

	public static void executeHome(WebDriver driver) throws Exception {
		HomePage.clicar("speakersImg", driver);
		
		SearchPage.clicarPorMassaDados(ExcelUtil.getCellData(1, 0), driver);
				
	}
}
