package br.com.advantageShopping.BDD.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.advantageShopping.BDD.Util.Generator;
import br.com.advantageShopping.BDD.Util.Printar;
import br.com.advantageShopping.BDD.criacoes.CriarElementsDriverSelectActions;

public class RegisterPage {

	private static WebElement element;
	private static Select select;

	public static void enviarTextoName(String texto, String name) {

		element = CriarElementsDriverSelectActions.criandoElementName(name);

		element.sendKeys(texto);
	}

	public static void escolhendoOpcao(String text, String xpath) {
		element = CriarElementsDriverSelectActions.criandoElementXpath(xpath);
		select = new Select(element);

		element.click();
		select.selectByVisibleText(text);
	}

	public static void concordar(String xpath) {
		element = CriarElementsDriverSelectActions.criandoElementXpath(xpath);
		element.click();
	}

	public static void clicar(String id) {
		element = CriarElementsDriverSelectActions.criandoElementId(id);

		element.click();
	}

	public static void capturar() {
		String printArquivo = "prints" + Generator.dataHoraParaArquivo() + ".png";

		Printar.print(CriarElementsDriverSelectActions.getdriver(), printArquivo);

	}

}
