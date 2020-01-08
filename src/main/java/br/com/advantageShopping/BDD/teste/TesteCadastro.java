package br.com.advantageShopping.BDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.advantageShopping.BDD.Util.ExcelUtil;
import br.com.advantageShopping.BDD.criacoes.CriarElementsDriverSelectActions;
import br.com.advantageShopping.BDD.pageObjects.HomePage;
import br.com.advantageShopping.BDD.pageObjects.RegisterPage;

public class TesteCadastro {
	
	@Before
	public void inicio() throws Exception {
		CriarElementsDriverSelectActions.criandoDriver("https://www.advantageonlineshopping.com/");
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastro");
	}
	
	@Test
	public void DeveCriarUsuario() throws Exception {
		Thread.sleep(4000);
		HomePage.clicar("menuUser");
		Thread.sleep(4000);
		HomePage.clicarXpath("/html/body/login-modal/div/div/div[3]/a[2]");

		String[] elementName = { "usernameRegisterPage", "emailRegisterPage", "passwordRegisterPage",
				"confirm_passwordRegisterPage", "first_nameRegisterPage", "last_nameRegisterPage",
				"phone_numberRegisterPage",
				"/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select",
				"cityRegisterPage", "addressRegisterPage", "state_/_province_/_regionRegisterPage",
				"postal_codeRegisterPage" };

		for (int i = 0; i < ExcelUtil.getRowNum(); i++) {
			for (int n = 0; n < elementName.length; n++) {

				if (n != 7) {
					RegisterPage.enviarTextoName(ExcelUtil.getCellData(i + 1, n), elementName[n]);

				} else {
					Thread.sleep(15000);
					RegisterPage.escolhendoOpcao(ExcelUtil.getCellData(i + 1, n), elementName[n]);

					Thread.sleep(5000);
				}
			}
			RegisterPage.concordar("//*[@id=\"formCover\"]/sec-view/div/input");
			
			RegisterPage.clicar("register_btnundefined");
			
			CriarElementsDriverSelectActions.limpar();
			
			Thread.sleep(2000);
		}

	}
	
	@After
	public void finaliza() {
		RegisterPage.capturar();
		
		CriarElementsDriverSelectActions.close();
	}
}
