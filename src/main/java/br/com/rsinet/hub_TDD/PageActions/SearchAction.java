package br.com.rsinet.hub_TDD.PageActions;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.SearchPage;

public class SearchAction {
	
	
	public static void execute(WebDriver driver) throws Exception {
		SearchPage.clicar("menuSearch", driver);

		String produto =  ExcelUtil.getCellData(1, 0);
		SearchPage.escrever("autoComplete", driver, produto);
		
		SearchPage.clicarPorMassaDados(produto, driver);
		
	}

	public static void executeHome(WebDriver driver) throws Exception {
		
		HomePage.clicar("speakersImg", driver);
		
		SearchPage.clicarPorMassaDados(ExcelUtil.getCellData(1, 0), driver);
				
	}
}
