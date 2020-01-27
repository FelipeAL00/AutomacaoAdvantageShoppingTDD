package br.com.rsinet.hub_TDD.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollDownEUp {
	
	private WebDriver driver;
	private JavascriptExecutor js;

	public ScrollDownEUp(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}
	
	public void scrollDown() {
		js.executeScript("scrollBy(0,200)", "");
	}
	
	public void scrollUp() {
		js.executeScript("scrollBy(0,-500)", "");
	}
	
	
}
