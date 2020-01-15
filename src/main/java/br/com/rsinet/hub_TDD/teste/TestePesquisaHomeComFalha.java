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
import br.com.rsinet.hub_TDD.pageActions.SearchAction;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComFalha {
	
	private WebDriver driver;
	
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get(Constantes.URLHOME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeFalha");
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, SearchPage.class);

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteBuscaHomeSucesso" + Generator.dataHoraParaArquivo());
	}
	
	@Test
	public void deveBuscarUmSpeakerPeloNomeQueNaoExiste() throws Exception {
		try {
			SearchAction.executeHome(driver);
			Log.info("teste executado");
		}catch(Exception e) {
			assertEquals("https://www.advantageonlineshopping.com/#/category/Speakers/4", driver.getCurrentUrl());
			Log.info("teste passou");
		}
		Printar.print(driver,"buscaFail");
		Log.info("print feito");
	}
	
	@After
	public void finaliza() {
		Log.endTestCase("SeleniumTesteBuscaHomeFalha"+ Generator.dataHoraParaArquivo());
		driver.close();
	}
}
