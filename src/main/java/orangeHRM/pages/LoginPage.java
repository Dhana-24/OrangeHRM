package orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import orangeHRM.base.SeleniumBase;

public class LoginPage extends SeleniumBase{

	public LoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;

	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;

	public LoginPage enterUserName(String userName) {

		type(userNameField,userName,"User Name");
		return this;
	}

	public LoginPage enterPassword(String password) {

		type(passwordField,password,"Password");
		return this;
	}

	public DashboardPage clickLogin() {

		click(loginButton);
		return new DashboardPage(driver);
	}



}
