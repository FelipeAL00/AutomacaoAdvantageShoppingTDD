package br.com.rsinet.hub_TDD.PageActions;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.pageObjects.HomePage;
import br.com.rsinet.hub_TDD.pageObjects.RegisterPage;

public class RegisterAction {

	public static void execute(WebDriver driver) throws Exception {
		String[] elementName = { "usernameRegisterPage", "emailRegisterPage", "passwordRegisterPage",
				"confirm_passwordRegisterPage", "first_nameRegisterPage", "last_nameRegisterPage",
				"phone_numberRegisterPage",
				"/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select",
				"cityRegisterPage", "addressRegisterPage", "state_/_province_/_regionRegisterPage",
				"postal_codeRegisterPage" };

		HomePage.clicar("menuUser", driver);
		HomePage.clicarXpath("/html/body/login-modal/div/div/div[3]/a[2]", driver);
		for (int n = 0; n < elementName.length; n++) {

			if (n != 7) {
				RegisterPage.enviarTextoName(ExcelUtil.getCellData(1, n), elementName[n], driver);

			} else {
				RegisterPage.escolhendoOpcao(ExcelUtil.getCellData(1, n), elementName[n], driver);
			}
		}
		RegisterPage.concordar("//*[@id=\"formCover\"]/sec-view/div/input", driver);

		RegisterPage.clicar("register_btnundefined", driver);

	}

}
