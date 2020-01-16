package br.com.rsinet.hub_TDD.Util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver InitDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constantes.URLHOME);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SeleniumTesteCadastroComSucesso" + Generator.dataHoraParaArquivo());		
		
		return driver;
	}

	public static WebDriver getdriver() {
		return driver;
	}
	
	public static void closeDriver() {
		if(driver != null) {
			Log.endTestCase("SeleniumTesteCadastroComSucesso"+ Generator.dataHoraParaArquivo());
			driver.close();
		}
	}
	
	
}
