package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.manager.FileReaderManager;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Report;
import br.com.rsinet.hub_TDD.manager.WebDriverManager;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.ProductPage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComSucesso {
	private WebDriver driver;
	private ProductPage productPage;
	private HomePage homePage;
	private SearchPage searchPage;
	private ExtentTest test;
	private ExtentReports extent;
	private WebDriverManager managerDriver;

	@Before
	public void inicio() throws Exception {
		managerDriver = new WebDriverManager();
		driver = managerDriver.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeSucesso");
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		productPage = PageFactory.initElements(driver, ProductPage.class);
		extent = Report.setReport();
	}

	@Test
	public void deveBuscarUmSpeakerPeloNomeQueExiste() throws Exception {
		test = Report.createTest("deveBuscarUmSpeakerPeloNomeQueExiste");
		
		homePage.clicarComponentSpeakers();
		Log.info("clicou no componete de speaker");

		searchPage.clicarMassaDados(ExcelUtil.getCellData(1, 0));
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
		
	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test, "TestePesquisaComSucesso_", driver);
		Report.quitExtent(extent);
		managerDriver.closeDriver();
	}
}
