package br.com.rsinet.hub_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.Util.DriverFactory;

public class RegisterPage {
	
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getdriver(), 10);
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement username;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement userEmail;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement password;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement passwordConfirm;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement firstName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement lastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select")
	private WebElement countrySelect;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement city;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement address;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement stateORProvince;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement postalCode;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement checkedOk;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement btnRegister;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getPasswordConfirm() {
		return passwordConfirm;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getCountrySelect() {
		return countrySelect;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getStateORProvince() {
		return stateORProvince;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getBtnRegister() {
		return btnRegister;
	}

	public WebElement getCheckedOk() {
		return checkedOk;
	}

	public void userName(String userNameT) {
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(userNameT);

	}

	public void checkedOk() {
		wait.until(ExpectedConditions.visibilityOf(checkedOk));
		checkedOk.click();
	}

	public void btnRegister() {
		wait.until(ExpectedConditions.visibilityOf(btnRegister));
		btnRegister.click();
	}

	public void userEmail(String userEmailT) {
		wait.until(ExpectedConditions.visibilityOf(userEmail));
		userEmail.sendKeys(userEmailT);
	}

	public void password(String passwordT) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(passwordT);
	}

	public void passwordConfirm(String passwordConfirmT) {
		wait.until(ExpectedConditions.visibilityOf(passwordConfirm));
		passwordConfirm.sendKeys(passwordConfirmT);
	}

	public void firstName(String firstNameT) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(firstNameT);
	}

	public void lastName(String lastNameT) {
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lastNameT);
	}

	public void phoneNumber(String phoneNumberT) {
		wait.until(ExpectedConditions.visibilityOf(phoneNumber));
		phoneNumber.sendKeys(phoneNumberT);		
	}

	public void country(String country) {
		wait.until(ExpectedConditions.visibilityOf(countrySelect));
		countrySelect.sendKeys(country);		
	}

	public void address(String addressT) {
		wait.until(ExpectedConditions.visibilityOf(address));
		address.sendKeys(addressT);		
	}

	public void city(String cityT) {
		wait.until(ExpectedConditions.visibilityOf(city));
		city.sendKeys(cityT);	
	}

	public void stateORProvince(String stateORProvinceT) {
		wait.until(ExpectedConditions.visibilityOf(stateORProvince));
		stateORProvince.sendKeys(stateORProvinceT);		
	}

	public void postalCode(String postalCodeT) {
		wait.until(ExpectedConditions.visibilityOf(postalCode));
		postalCode.sendKeys(postalCodeT);		
	}

}
