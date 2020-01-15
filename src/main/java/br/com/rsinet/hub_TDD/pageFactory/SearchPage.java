package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.rsinet.hub_TDD.Util.ExcelUtil;

public class SearchPage {
	
	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement lupaPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement barraPesquisa;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	public static WebElement fecharPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public static WebElement componentText;

	public static WebElement linkText(WebDriver driver) throws Exception {
		return driver.findElement(By.linkText(ExcelUtil.getCellData(1, 0)));
	}
	
}
