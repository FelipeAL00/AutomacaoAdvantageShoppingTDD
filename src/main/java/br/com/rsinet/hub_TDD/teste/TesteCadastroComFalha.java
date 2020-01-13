package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.PageActions.RegisterAction;
import br.com.rsinet.hub_TDD.Util.Constantes;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.RegisterPage;

public class TesteCadastroComFalha {
	private WebDriver driver;

	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroFalha");
	}

	@Test
	public void DeveErrarSenhaENaoCadastrar() throws Exception {
		
			RegisterAction.execute(driver);
			
			assertFalse(RegisterPage.capturaSenha(driver, "passwordRegisterPage") == RegisterPage.capturaConfirmacaoSenha(driver, "confirm_passwordRegisterPage") && RegisterPage.btnInvisible(driver,"register_btnundefined" ));
			
			RegisterPage.capturar(driver,"//*[@id=\"menuUserLink\"]/span","error");		

	}

	@After
	public void finaliza() {
		driver.close();
	}
}
