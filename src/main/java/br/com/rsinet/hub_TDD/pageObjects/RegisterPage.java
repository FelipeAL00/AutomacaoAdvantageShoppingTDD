package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.Generator;
import br.com.rsinet.hub_TDD.Util.Printar;

public class RegisterPage {

	private static WebElement element;
	private static Select select;
	private static WebDriverWait wait;
	
	public static void enviarTextoName(String texto, String name, WebDriver driver) {
		
		element = driver.findElement(By.name(name));
		
		element.sendKeys(texto);
	}

	public static void escolhendoOpcao(String text, String xpath, WebDriver driver) {
		element = driver.findElement(By.xpath(xpath));
		select = new Select(element);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
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

	public static void capturar(WebDriver driver, String xpath, String local) throws InterruptedException {
		String printArquivo = "prints\\"+local+"\\captura_" + Generator.dataHoraParaArquivo() + ".png";

		Printar.print(driver, printArquivo);

	}

}
