package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private static WebElement element;
	private static WebDriverWait wait;
	private static Actions actions;

	public static void clicar(String id, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		element = driver.findElement(By.id(id));

		wait.until(ExpectedConditions.visibilityOf(element));

		element.click();
	}

	public static void clicarPorMassaDados(String linkTexto, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		element = driver.findElement(By.partialLinkText(linkTexto));
		actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(element));

		actions.moveToElement(element).click().perform();
	}

}
