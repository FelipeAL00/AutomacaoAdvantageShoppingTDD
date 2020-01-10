package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private static WebElement element;
	private static WebDriverWait wait;
	private static JavascriptExecutor js;
	public static void clicar(String id, WebDriver driver) {	
		element = driver.findElement(By.id(id));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
		element.click();
	}
	
	public static void clicarXpath(String xpath, WebDriver driver) {
		
		element =  driver.findElement(By.xpath(xpath));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", element);
		
		
	}

	public static String capturarQuemTaLogado(WebDriver driver) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span")));	
		element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		
		if(element.isEnabled())
			return element.getText().toString();
	
		return "";
	}
	
}
