package br.com.advantageShopping.BDD.criacoes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CriarElementsDriverSelectActions {
	
	private static WebDriver driver;
	private static WebElement element;
	private static Select select;
	private static Actions actions;
	
	public static void criandoDriver(String caminho) {
		driver = new ChromeDriver();		
		driver.get(caminho);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	
	}
	
	public static WebElement criandoElementId(String id) {
		element = driver.findElement(By.id(id));
		
		return element;
	}
	
	public static WebElement criandoElementName(String name) {
		element = driver.findElement(By.name(name));
		
		return element;
	}
	
	public static WebElement criandoElementXpath(String xpath) {
		element = driver.findElement(By.xpath(xpath));
	
		return element;
	}
	
	public static Select criandoSelect(WebElement element) {
		select = new Select(element);
	
		return select;
	}
	
	public static Actions criandoactions(){
		actions =  new Actions(driver);
		return actions;
	}
	
	public static void close() {
		driver.close();
	}
	
	public static String getlink() {
		return driver.getCurrentUrl().toString();
	}

	public static WebDriver getdriver() {
		
		return driver;
	}
	
	public static void limpar() {
		driver.navigate().refresh();
	}
}
