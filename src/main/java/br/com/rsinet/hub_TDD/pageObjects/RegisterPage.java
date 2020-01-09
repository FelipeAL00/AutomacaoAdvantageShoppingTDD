package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_TDD.Util.Generator;
import br.com.rsinet.hub_TDD.Util.Printar;

public class RegisterPage {

	private static WebElement element;
	private static Select select;

	public static void enviarTextoName(String texto, String name, WebDriver driver) {

		element = driver.findElement(By.name(name));
		
		element.sendKeys(texto);
	}

	public static void escolhendoOpcao(String text, String xpath, WebDriver driver) {
		element = driver.findElement(By.xpath(xpath));
		select = new Select(element);

		element.click();
		select.selectByVisibleText(text);
	}

	public static void concordar(String xpath, WebDriver driver) {
		element = driver.findElement(By.xpath(xpath));
		element.click();
	}

	public static void clicar(String id, WebDriver driver) {
		element = driver.findElement(By.id(id));

		element.click();
	}

	public static void capturar(WebDriver driver) {
		String printArquivo = "prints\\captura_" + Generator.dataHoraParaArquivo() + ".png";

		Printar.print(driver, printArquivo);

	}

}
