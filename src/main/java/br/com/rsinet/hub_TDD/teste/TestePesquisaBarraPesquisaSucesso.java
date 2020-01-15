package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Generator;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageActions.ProductAction;
import br.com.rsinet.hub_TDD.pageActions.SearchAction;
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;
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
		PageFactory.initElements(driver, ProductPage.class);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteBuscaSucesso" + Generator.dataHoraParaArquivo());
	}
	
	@Test
	public void deveBuscarUmProdutoComSucesso() throws Exception {
		SearchAction.execute(driver);
		Log.info("teste de pesquisa executado");
		ProductAction.execute(driver);
		Log.info("teste de pagamento executado");
		assertEquals("https://www.advantageonlineshopping.com/#/orderPayment", driver.getCurrentUrl());		
		Log.info("teste passou");
		Printar.print(driver,"buscaSuccess");
		Log.info("Print feito");
	}
	
	@After
	public void finaliza() {
		Log.endTestCase("SeleniumTesteBuscaSucesso"+ Generator.dataHoraParaArquivo());
		driver.close();
	}
}
