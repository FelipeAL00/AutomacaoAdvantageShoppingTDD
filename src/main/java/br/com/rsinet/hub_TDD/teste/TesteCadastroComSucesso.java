package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.PageActions.RegisterAction;
import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.RegisterPage;

public class TesteCadastroComSucesso {

	private WebDriver driver;
	
	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroSucesso");
	}

	@Test
	public void DeveCriarUsuario() throws Exception {
		RegisterAction.execute(driver);
		String resultadoObtido = HomePage.capturarQuemTaLogado(driver);
		
		assertEquals(ExcelUtil.getCellData(1, 0), resultadoObtido);
		
		RegisterPage.capturar(driver, "//*[@id=\"menuUserLink\"]/span", "success");
		
	}

	@After
	public void finaliza() {
		driver.close();
	}
}
