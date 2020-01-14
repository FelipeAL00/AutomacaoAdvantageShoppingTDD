package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.Generator;
import br.com.rsinet.hub_TDD.Util.Printar;

public class SearchPage {

	private static WebElement element;
	private static WebDriverWait wait;

	public static void clicar(String id, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		element = driver.findElement(By.id(id));

		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	public static void clicarPorMassaDados(String linkTexto, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		element = driver.findElement(By.linkText(linkTexto));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	public static void escrever(String id, WebDriver driver, String texto) {
		wait = new WebDriverWait(driver, 30);
		element = driver.findElement(By.id(id));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		element.sendKeys(texto);
		element.sendKeys(Keys.ENTER);
		
	}
		
	public static void clicarPorXpath(String xpath, WebDriver driver) {
		element = driver.findElement(By.xpath(xpath));
		wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
	}

	public static void printar(String local, WebDriver driver) {
		String printArquivo = "prints\\"+local+"\\captura_" + Generator.dataHoraParaArquivo() + ".png";

		Printar.print(driver, printArquivo);
		
	}




}
