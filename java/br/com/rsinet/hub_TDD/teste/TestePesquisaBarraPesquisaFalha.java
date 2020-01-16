package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.Util.DriverFactory;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageFactory.SearchPage;

public class TestePesquisaBarraPesquisaFalha {
	private WebDriver driver;
	private SearchPage searchPage;
	@Before
	public void inicio() throws Exception {
		driver = DriverFactory.InitDriver();
		ExcelUtil.setExcelFile("MassaDados.xlsx", "BuscaBarraFalha");
		searchPage = PageFactory.initElements(driver, SearchPage.class);
	}

	@Test
	public void deveBuscarUmProdutoInexistente() throws Exception {
		try {
			searchPage.lupaPesquisa();
			Log.info("clicou na lupa de pesquisa");

			String produto = ExcelUtil.getCellData(1, 0);
			Log.info("pegou o produto na massa de dados");

			searchPage.barraPesquisa(produto);
			Log.info("enviou o produto para a barra de pesquisa");
			searchPage.barraPesquisa(Keys.ENTER);
			Log.info("pesquisou");
			searchPage.clicarMassaDados(driver);

			
			Log.info("teste executado");
		} catch (Exception e) {
			String esperado = "No results for \"" + ExcelUtil.getCellData(1, 0) + "\"";
			assertEquals(esperado, searchPage.getComponentText());
			Log.info("Teste passou");
		}
		Printar.print(driver, "buscaFail");
		Log.info("Print tirado");
	}

	@After
	public void finaliza() {
		DriverFactory.closeDriver();
	}
}
