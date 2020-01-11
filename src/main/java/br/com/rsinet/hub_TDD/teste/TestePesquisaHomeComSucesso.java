package br.com.rsinet.hub_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.SearchPage;

public class TestePesquisaHomeComSucesso {
	private WebDriver driver;
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "buscarHome");
	}
	
	@Test
	public void deveBuscarUmSpeakerPeloNome() throws Exception {
		HomePage.clicar("speakersImg", driver);
		System.out.println(ExcelUtil.getCellData(1, 0));
		SearchPage.clicarPorMassaDados(ExcelUtil.getCellData(1, 0),driver);
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
}
