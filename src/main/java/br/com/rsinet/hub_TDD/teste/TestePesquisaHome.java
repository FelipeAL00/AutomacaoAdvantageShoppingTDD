package br.com.rsinet.hub_TDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.SearchPage;

public class TestePesquisaHome {
	private WebDriver driver;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscar");
	}
	
	@Test
	public void deveBuscarUmNotebookPeloNome() throws Exception {
		HomePage.clicar("laptopsImg", driver);
		
		SearchPage.clicar(ExcelUtil.getCellData(1, 0));
		
		
	}
	
	@After
	public void finaliza() {
		
	}
}
