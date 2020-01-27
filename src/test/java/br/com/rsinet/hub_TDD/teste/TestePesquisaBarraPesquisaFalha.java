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
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaBarraPesquisaFalha {
	private WebDriver driver;
	private SearchPage searchPage;
	private ExtentTest test;
	private ExtentReports extent;
	private WebDriverManager managerDriver;
	@Before
	public void inicio() throws Exception {
		managerDriver = new WebDriverManager();
		driver = managerDriver.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraFalha");
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		extent = Report.setReport();
	}

	@Test
	public void deveBuscarUmProdutoInexistente() throws Exception {
		test = Report.createTest("deveBuscarUmProdutoInexistente");
		
		try {
			searchPage.lupaPesquisa();
			Log.info("clicou na lupa de pesquisa");

			String produto = ExcelUtil.getCellData(1, 0);
			Log.info("pegou o produto na massa de dados");

			searchPage.barraPesquisa(produto);
			Log.info("enviou o produto para a barra de pesquisa");
			searchPage.barraPesquisa(Keys.ENTER);
			Log.info("pesquisou");
			searchPage.clicarMassaDados(ExcelUtil.getCellData(1, 0));

			
			Log.info("teste executado");
		} catch (Exception e) {
			String esperado = "No results for \"" + ExcelUtil.getCellData(1, 0) + "\"";
			assertEquals(esperado, searchPage.getComponentText());
			Log.info("Teste passou");
		}
	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test, "TestePesquisaBarraComFalha_", driver);
		Report.quitExtent(extent);
		managerDriver.closeDriver();
	}
}
