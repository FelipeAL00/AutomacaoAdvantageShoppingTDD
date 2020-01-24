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

import br.com.rsinet.hub_TDD.Util.DriverFactory;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Report;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaHomeComFalha {

	private WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;
	private ExtentTest test;
	private ExtentReports extent;
	

	@Before
	public void inicio() throws Exception {
		driver = DriverFactory.initDriver();
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeFalha");
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		extent = Report.setReport();
	}

	@Test
	public void deveBuscarUmSpeakerPeloNomeQueNaoExiste() throws Exception {
		test = Report.createTest("deveBuscarUmSpeakerPeloNomeQueNaoExiste");
		try {
			homePage.clicarComponentSpeakers();
			Log.info("clicou no componete de speaker");

			searchPage.clicarMassaDados(driver, ExcelUtil.getCellData(1, 0));
			Log.info("conseguiu clicar");

			Log.info("teste executado");
		} catch (Exception e) {
			assertEquals("https://www.advantageonlineshopping.com/#/category/Speakers/4", driver.getCurrentUrl());
			Log.info("teste passou");
		}

	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test, "TestePesquisaComFalha_", driver);
		Report.quitExtent(extent);
		DriverFactory.closeDriver();
	}
}
