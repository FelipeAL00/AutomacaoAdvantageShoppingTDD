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
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaBarraPesquisaFalha {
	private WebDriver driver;

	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraFalha");
		PageFactory.initElements(driver, SearchPage.class);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteBuscaFalha" + Generator.dataHoraParaArquivo());
	}

	@Test
	public void deveBuscarUmProdutoComFalha() throws Exception {
		try {
			SearchAction.execute(driver);
			Log.info("teste executado");
		} catch (Exception e) {
			String esperado = "No results for \"" + ExcelUtil.getCellData(1, 0) + "\"";
			assertEquals(esperado, SearchAction.capturaTextoComparacao());
			Log.info("Teste passou");
		}
		Printar.print(driver, "buscaFail");
		Log.info("Print tirado");
	}

	@After
	public void finaliza() {
		Log.endTestCase("SeleniumTesteBuscaFalha"+ Generator.dataHoraParaArquivo());
		driver.close();
	}
}
