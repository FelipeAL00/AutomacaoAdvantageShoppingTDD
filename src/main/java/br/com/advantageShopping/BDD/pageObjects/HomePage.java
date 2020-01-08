package br.com.advantageShopping.BDD.pageObjects;

import org.openqa.selenium.WebElement;

import br.com.advantageShopping.BDD.criacoes.CriarElementsDriverSelectActions;

public class HomePage {
	
	private static WebElement element;
	
	public static void clicar(String id) throws InterruptedException {
		element = CriarElementsDriverSelectActions.criandoElementId(id);

		element.click();
	
	}
	
	public static void clicarXpath(String xpath) throws InterruptedException {
		element = CriarElementsDriverSelectActions.criandoElementXpath(xpath);

		element.click();
	}

}
