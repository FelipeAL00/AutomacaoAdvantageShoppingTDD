package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.Util.DriverFactory;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComFalha {
	
	private WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;
	@Before
	public void inicio() throws Exception {
		driver = DriverFactory.InitDriver();
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeFalha");
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchPage = PageFactory.initElements(driver, SearchPage.class);
	}
	
	@Test
	public void deveBuscarUmSpeakerPeloNomeQueNaoExiste() throws Exception {
		try {
			homePage.clicarComponentSpeakers();
			Log.info("clicou no componete de speaker");

			searchPage.clicarMassaDados(driver);
			Log.info("conseguiu clicar");

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
		DriverFactory.closeDriver();
	}
}
