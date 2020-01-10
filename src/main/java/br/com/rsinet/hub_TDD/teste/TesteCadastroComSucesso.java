package br.com.rsinet.hub_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		driver.get("https://www.advantageonlineshopping.com/");
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroSucesso");
	}

	@Test
	public void DeveCriarUsuario() throws Exception {
		String[] elementName = { "usernameRegisterPage", "emailRegisterPage", "passwordRegisterPage",
				"confirm_passwordRegisterPage", "first_nameRegisterPage", "last_nameRegisterPage",
				"phone_numberRegisterPage",
				"/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select",
				"cityRegisterPage", "addressRegisterPage", "state_/_province_/_regionRegisterPage",
				"postal_codeRegisterPage" };

		for (int i = 0; i < ExcelUtil.getRowNum(); i++) {
			HomePage.clicar("menuUser",driver);
			HomePage.clicarXpath("/html/body/login-modal/div/div/div[3]/a[2]",driver);
			for (int n = 0; n < elementName.length; n++) {
				
				if (n != 7) {
					RegisterPage.enviarTextoName(ExcelUtil.getCellData(i + 1, n), elementName[n],driver);

				} else {
					RegisterPage.escolhendoOpcao(ExcelUtil.getCellData(i + 1, n), elementName[n],driver);
				}
			}
			RegisterPage.concordar("//*[@id=\"formCover\"]/sec-view/div/input",driver);

			RegisterPage.clicar("register_btnundefined",driver);

			String resultadoObtido = HomePage.capturarQuemTaLogado(driver);
			
			driver.navigate().refresh();
			assertEquals(ExcelUtil.getCellData(i+1, 0), resultadoObtido);
			
			RegisterPage.capturar(driver,"//*[@id=\"menuUserLink\"]/span");
		}

	}

	@After
	public void finaliza() {
		driver.close();
	}
}
