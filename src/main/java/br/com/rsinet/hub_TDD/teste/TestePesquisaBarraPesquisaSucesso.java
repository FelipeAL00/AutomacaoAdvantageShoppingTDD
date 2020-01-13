package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.PageActions.SearchAction;
import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.SearchPage;

public class TestePesquisaBarraPesquisaSucesso {
	
	private WebDriver driver;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get(Constantes.URLHOME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraSucesso");		
	}
	
	@Test
	public void deveBuscarUmProdutoComSucesso() throws Exception {
		SearchAction.execute(driver);
		
		assertEquals("https://www.advantageonlineshopping.com/#/product/29?viewAll=HP%20USB%203%20Button%20Optical%20Mouse", driver.getCurrentUrl());
	
		Thread.sleep(1000);
		SearchPage.printar("buscaSuccess", driver);
	}
	
	@After
	public void finaliza() {
//		driver.close();
	}
}
