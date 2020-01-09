package br.com.rsinet.hub_TDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.RegisterPage;

public class TesteCadastro {

	private WebDriver driver;

	@Before
	public void inicio() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastro");
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
			Thread.sleep(4000);
			HomePage.clicar("menuUser",driver);
			Thread.sleep(4000);
			HomePage.clicarXpath("/html/body/login-modal/div/div/div[3]/a[2]",driver);
			for (int n = 0; n < elementName.length; n++) {

				if (n != 7) {
					RegisterPage.enviarTextoName(ExcelUtil.getCellData(i + 1, n), elementName[n],driver);

				} else {
					Thread.sleep(15000);
					RegisterPage.escolhendoOpcao(ExcelUtil.getCellData(i + 1, n), elementName[n],driver);

					Thread.sleep(5000);
				}
			}
			RegisterPage.concordar("//*[@id=\"formCover\"]/sec-view/div/input",driver);

			RegisterPage.clicar("register_btnundefined",driver);

			Thread.sleep(4000);

			String url = driver.getCurrentUrl();

			if (url.equals("https://www.advantageonlineshopping.com/#/")) {
				ExcelUtil.setCellData("Aprovado", i + 1, 12, "MassaDados.xlsx");
				RegisterPage.capturar(driver);
			}else {
				ExcelUtil.setCellData("Reprovado", i + 1, 12, "MassaDados.xlsx");
			}

			driver.navigate().refresh();
		}

	}

	@After
	public void finaliza() {
		driver.close();
	}
}
