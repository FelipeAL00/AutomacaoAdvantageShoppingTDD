package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public static WebElement username;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public static WebElement userEmail;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public static WebElement password;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public static WebElement passwordConfirm;
		
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public static WebElement firstName;
	
	@FindBy(how = How.NAME, using ="last_nameRegisterPage")
	public static WebElement lastName;
	
	@FindBy(how = How.NAME, using ="phone_numberRegisterPage")
	public static WebElement phoneNumber;
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select")
	public static WebElement countrySelect;
	
	@FindBy(how = How.NAME, using ="cityRegisterPage")
	public static WebElement city;
	
	@FindBy(how = How.NAME, using ="addressRegisterPage")
	public static WebElement address;
	
	@FindBy(how = How.NAME, using ="state_/_province_/_regionRegisterPage")
	public static WebElement stateORProvince;
	
	@FindBy(how = How.NAME, using ="postal_codeRegisterPage")
	public static WebElement postalCode;
	
	@FindBy(how = How.ID, using ="register_btnundefined")
	public static WebElement btnRegister;
	
	@FindBy(how = How.NAME, using ="i_agree")
	public static WebElement checkedOk;
	
	
}
