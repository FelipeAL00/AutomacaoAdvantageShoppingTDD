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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Generator;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageActions.ProductAction;
import br.com.rsinet.hub_TDD.pageActions.SearchAction;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComSucesso {
	private WebDriver driver;
	private WebDriverWait wait;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get(Constantes.URLHOME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeSucesso");
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, SearchPage.class);
		PageFactory.initElements(driver, ProductPage.class);		
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteBuscaHomeSucesso" + Generator.dataHoraParaArquivo());
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void deveBuscarUmSpeakerPeloNome() throws Exception {
		SearchAction.executeHome(driver);
		Log.info("teste de pesquisa executado");
		
		ProductAction.execute(driver);
		Log.info("teste de pagamento executado");
		
		assertEquals("Thank you for buying with Advantage", ProductPage.messageThankYou.getText());
		Log.info("teste passou");
		
		wait.until(ExpectedConditions.visibilityOf(ProductPage.messageThankYou));
		Printar.print(driver,"buscaSuccess");
		Log.info("print feito");
	}
	
	@After
	public void finaliza() {
		Log.endTestCase("SeleniumTesteBuscaHomeSucesso"+ Generator.dataHoraParaArquivo());
		driver.close();
	}
}
