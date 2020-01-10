package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private static WebElement element;
	private static WebDriverWait wait;
	
	public static void clicar(String id, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		
		element = driver.findElement(By.id(id));

		element.click();
	}
	
	public static void clicarXpath(String xpath, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				
		element =  driver.findElement(By.xpath(xpath));

		element.click();
	}

	public static String capturarQuemTaLogado(WebDriver driver) throws InterruptedException {
		element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));		
		
		if(element.isEnabled())
			return element.getText().toString();
	
		return "";
	}

}
