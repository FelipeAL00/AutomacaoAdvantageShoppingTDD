package br.com.rsinet.hub_TDD.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_TDD.Util.DriverFactory;
import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Printar;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.RegisterPage;

public class TesteCadastroComSucesso {

	private WebDriver driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private JavascriptExecutor js;

	@Before
	public void inicio() throws Exception {
		driver = DriverFactory.initDriver();
		ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroSucesso");
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void DeveCriarUsuario() throws Exception {

		homePage.clickBtnLogar();
		Log.info("clicou no btnLogar");
		js.executeScript("arguments[0].click()", homePage.getBtnCriarConta());
		Log.info("clicou no btnCriarConta");

		registerPage.userName(ExcelUtil.getCellData(1, 0));
		registerPage.userEmail(ExcelUtil.getCellData(1, 1));
		registerPage.password(ExcelUtil.getCellData(1, 2));
		registerPage.passwordConfirm(ExcelUtil.getCellData(1, 3));
		registerPage.firstName(ExcelUtil.getCellData(1, 4));
		registerPage.lastName(ExcelUtil.getCellData(1, 5));
		registerPage.phoneNumber(ExcelUtil.getCellData(1, 6));
		registerPage.country(ExcelUtil.getCellData(1, 7));
		registerPage.city(ExcelUtil.getCellData(1, 8));
		registerPage.address(ExcelUtil.getCellData(1, 9));
		registerPage.stateORProvince(ExcelUtil.getCellData(1, 10));
		registerPage.postalCode(ExcelUtil.getCellData(1, 11));

		registerPage.checkedOk();
		Log.info("concordou com os termos");

		registerPage.btnRegister();
		Log.info("clicou no btnRegister");
		
		Log.info("teste executado");
		
		String userLog = homePage.getUserLog();
		assertEquals(ExcelUtil.getCellData(1, 0), userLog);
		Log.info("teste passou");

		Printar.print(driver, "success");
		Log.info("print feito");
	}

	@After
	public void finaliza() {
		DriverFactory.closeDriver();
	}
}
