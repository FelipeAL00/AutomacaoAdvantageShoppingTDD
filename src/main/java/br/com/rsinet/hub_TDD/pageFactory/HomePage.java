package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	@FindBy(how = How.ID, using = "menuUser" )
	public static WebElement btnLogar;
	
	@FindBy(how = How.ID, using = "menuUserLink" )
	public static WebElement UserLog;
	
	@FindBy(how = How.ID, using = "speakersImg" )
	public static WebElement componentSpeakers;
	
	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	public static WebElement btnCriarConta;	
	
}
