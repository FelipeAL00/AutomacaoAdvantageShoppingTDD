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
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
		
		element = driver.findElement(By.name(name));
		
		element.sendKeys(texto);
	}

	public static void escolhendoOpcao(String text, String xpath, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		element = driver.findElement(By.xpath(xpath));
		select = new Select(element);

		element.click();
		select.selectByVisibleText(text);
	}

	public static void concordar(String xpath, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		element = driver.findElement(By.xpath(xpath));
		element.click();
	}

	public static void clicar(String id, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		
		element = driver.findElement(By.id(id));

		element.click();
	}

	public static void capturar(WebDriver driver, String xpath) throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		String printArquivo = "prints\\captura_" + Generator.dataHoraParaArquivo() + ".png";

		Printar.print(driver, printArquivo);

	}

}
