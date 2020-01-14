package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageActions.SearchAction;

public class TestePesquisaHomeComSucesso {
	private WebDriver driver;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get(Constantes.URLHOME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHomeSucesso");
	}
	
	@Test
	public void deveBuscarUmSpeakerPeloNome() throws Exception {
		SearchAction.executeHome();
		
		assertEquals("https://www.advantageonlineshopping.com/#/product/20", driver.getCurrentUrl());
		
		Thread.sleep(1000);
		Printar.print(driver,"buscaSuccess");
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
}
