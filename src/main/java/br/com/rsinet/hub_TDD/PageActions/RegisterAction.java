package br.com.rsinet.hub_TDD.pageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;
import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;
import br.com.rsinet.hub_TDD.pageFactory.RegisterPage;

public class RegisterAction {

	private static JavascriptExecutor js;
	private static WebDriverWait wait;
	public static void execute(WebDriver driver) throws Exception {
		WebElement[] elementName = { RegisterPage.username, RegisterPage.userEmail, RegisterPage.password,
				RegisterPage.passwordConfirm, RegisterPage.firstName, RegisterPage.lastName, RegisterPage.phoneNumber,
				RegisterPage.countrySelect, RegisterPage.city, RegisterPage.address, RegisterPage.stateORProvince,
				RegisterPage.postalCode};
		wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(HomePage.btnLogar));
		HomePage.btnLogar.click();
		Log.info("clicou no btnLogar");
		wait.until(ExpectedConditions.visibilityOf(HomePage.btnCriarConta));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", HomePage.btnCriarConta);
		Log.info("clicou no btnCriarConta");
		
		for (int n = 0; n < elementName.length; n++) {
				wait.until(ExpectedConditions.visibilityOf(elementName[n]));
				elementName[n].sendKeys(ExcelUtil.getCellData(1, n));
				Log.info("escreveu o element na posição " + n);
		}
		RegisterPage.checkedOk.click();
		Log.info("concordou com os termos");
		
		RegisterPage.btnRegister.click();
		Log.info("clicou no btnRegister");
	}

	public static String capturaSenha() {
		Log.info("entrou no metodo de captura de senha");
		return RegisterPage.password.getText();
	}

	public static String capturaConfirmacaoSenha() {
		Log.info("entrou no metodo de captura de confirmação da senha");
		return RegisterPage.passwordConfirm.getText();
	}

	public static boolean btnInvisible() {
		if(RegisterPage.btnRegister.isEnabled()) {
			Log.info("o botão está ativo, usuario pode ser cadastrado");
			return true;
		}
		Log.info("o botão está inativo, usuario não pode ser cadastrado");
		return false;
	}

}
