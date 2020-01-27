package br.com.rsinet.hub_TDD.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.Util.Report;
import br.com.rsinet.hub_TDD.manager.FileReaderManager;
import br.com.rsinet.hub_TDD.manager.WebDriverManager;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.RegisterPage;

public class TesteCadastroComSucesso {

	private WebDriver driver;
	private RegisterPage registerPage;
	private HomePage homePage;
	private JavascriptExecutor js;
	private ExtentTest test;
	private ExtentReports extent;
	private WebDriverManager managerDriver;

	@Before
	public void inicio() throws Exception {
		managerDriver = new WebDriverManager();
		driver = managerDriver.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());ExcelUtil.setExcelFile("MassaDados.xlsx", "cadastroSucesso");
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		js = (JavascriptExecutor) driver;
		extent = Report.setReport();
	}

	@Test
	public void DeveCriarUsuario() throws Exception {

		test = Report.createTest("DeveCriarUsuario");
		
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

	}

	@After
	public void finaliza() throws IOException {
		Report.statusReported(test, "TesteCadastroComSucesso_", driver);
		Report.quitExtent(extent);
		managerDriver.closeDriver();
	}
}
