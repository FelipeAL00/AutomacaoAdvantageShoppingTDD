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
import br.com.rsinet.hub_TDD.pageActions.HomeActions;
import br.com.rsinet.hub_TDD.pageActions.RegisterAction;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.RegisterPage;

public class TesteCadastroComSucesso {

	private WebDriver driver;
	
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroSucesso");
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, RegisterPage.class);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteCadastroComSucesso" + Generator.dataHoraParaArquivo());		
	}

	@Test
	public void DeveCriarUsuario() throws Exception {
		RegisterAction.execute(driver);
		Log.info("teste executado");
		
		String resultadoObtido =HomeActions.capturarQuemTaLogado();
		
		assertEquals(ExcelUtil.getCellData(1, 0), resultadoObtido);
		Log.info("teste passou");
		
		Printar.print(driver, "success");
		Log.info("print feito");
	}

	@After
	public void finaliza() {
		Log.endTestCase("SeleniumTesteCadastroComSucesso"+ Generator.dataHoraParaArquivo());
		driver.close();
	}
}
