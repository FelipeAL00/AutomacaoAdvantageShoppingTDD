package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Report;
import br.com.rsinet.hub_TDD.manager.FileReaderManager;
import br.com.rsinet.hub_TDD.manager.WebDriverManager;
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaBarraPesquisaSucesso {

	private WebDriver driver;
	private SearchPage searchPage;
	private ProductPage productPage;
	private ExtentTest test;
	private ExtentReports extent;
	private WebDriverManager managerDriver;

	@Before
	public void inicio() throws Exception {
		managerDriver = new WebDriverManager();
		driver = managerDriver.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraSucesso");
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		extent = Report.setReport();
	}

	@Test
	public void deveBuscarUmProdutoExistente() throws Exception {
		test = Report.createTest("deveBuscarUmProdutoExistente");
		
		searchPage.lupaPesquisa();
		Log.info("clicou na lupa de pesquisa");

		String produto = ExcelUtil.getCellData(1, 0);
		Log.info("pegou o produto na massa de dados");

		searchPage.barraPesquisa(produto);
		Log.info("enviou o produto para a barra de pesquisa");
		searchPage.barraPesquisa(Keys.ENTER);
		Log.info("pesquisou");
		searchPage.clicarMassaDados(ExcelUtil.getCellData(1, 0));

		Log.info("teste de pesquisa executado");

		productPage.btnAddCart();
		
		productPage.btnCheckout();
		
		productPage.userName(ExcelUtil.getCellData(1, 1));
		productPage.password(ExcelUtil.getCellData(1, 2));
		productPage.btnLogin();
		
		productPage.btnNext();
		

		productPage.btnPayNow();	
		Log.info("teste de pagamento executado");
		
		assertEquals("Thank you for buying with Advantage", productPage.getMessageThankYou());
		Log.info("teste passou");
	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test, "TestePesquisaBarraComSucesso_", driver);
		Report.quitExtent(extent);
		managerDriver.closeDriver();
	}
}
