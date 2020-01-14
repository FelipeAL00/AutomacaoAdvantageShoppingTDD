package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageActions.SearchAction;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaBarraPesquisaSucesso {
	
	private WebDriver driver;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraSucesso");	
		PageFactory.initElements(driver, SearchPage.class);
	}
	
	@Test
	public void deveBuscarUmProdutoComSucesso() throws Exception {
		SearchAction.execute(driver);
		
		assertEquals("https://www.advantageonlineshopping.com/#/product/29?viewAll=HP%20USB%203%20Button%20Optical%20Mouse", driver.getCurrentUrl());		

		Printar.print(driver,"buscaSuccess");
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
}
