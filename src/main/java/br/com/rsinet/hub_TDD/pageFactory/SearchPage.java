package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {
	
	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement lupaPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement barraPesquisa;
	
	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[4]/a/div/div[1]/div/div/div/img")
	public static WebElement fecharPesquisa;

}
