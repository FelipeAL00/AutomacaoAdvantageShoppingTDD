package br.com.rsinet.hub_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private static WebElement element;
	
	public static void clicar(String id, WebDriver driver) {
		element = driver.findElement(By.id(id));

		element.click();
	
	}
	
	public static void clicarXpath(String xpath, WebDriver driver) {
		element =  driver.findElement(By.xpath(xpath));

		element.click();
	}

}
