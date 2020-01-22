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
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComSucesso {
	private WebDriver driver;
	private ProductPage productPage;
	private HomePage homePage;
	private SearchPage searchPage;

	@Before
	public void inicio() throws Exception {
		driver = DriverFactory.initDriver();
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeSucesso");
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
	}

	@Test
	public void deveBuscarUmSpeakerPeloNomeQueExiste() throws Exception {
		homePage.clicarComponentSpeakers();
		Log.info("clicou no componete de speaker");

		searchPage.clicarMassaDados(driver, ExcelUtil.getCellData(1, 0));
		Log.info("conseguiu clicar");
		
		Log.info("teste de pesquisa executado");

		productPage.btnAddCart();

		productPage.btnCheckout();

		productPage.userName(ExcelUtil.getCellData(1, 1));
		productPage.password(ExcelUtil.getCellData(1, 2));
		productPage.btnLogin();

		productPage.btnNext();

		productPage.btnPayNow();

		assertEquals("Thank you for buying with Advantage", productPage.getMessageThankYou());
		Log.info("teste passou");

		Printar.print(driver, "buscaSuccess");
		Log.info("print feito");
	}

	@After
	public void finaliza() {
		DriverFactory.closeDriver();
	}
}
