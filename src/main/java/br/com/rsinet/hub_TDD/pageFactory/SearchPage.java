package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {
	
	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement lupaPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement barraPesquisa;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	public static WebElement fecharPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public static WebElement componentText;

}
