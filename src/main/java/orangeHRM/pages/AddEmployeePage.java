package orangeHRM.pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.base.SeleniumBase;

public class AddEmployeePage extends SeleniumBase{

	public WebDriver driver;

	public AddEmployeePage(WebDriver rdriver) {
		//super();
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText="PIM")
	private WebElement PIMMenu;

	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addBtn;

	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstNameField;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastNameField;

	@FindBy(xpath="(//label[contains(text(),'Employee Id')]//following::input)[1]")
	private WebElement employeeIDField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	

	public String generateRandomString(int n) {

		int leftLimit = 97;
		int rightLimit = 122;

		Random random = new Random();
		StringBuilder buffer = new StringBuilder(n);
		for(int i=0;i<n;i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat()*(rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}

		String generatedString = buffer.toString();
		return generatedString;
	}
	
	public void clickPIMMenu() {
		
		click(PIMMenu);
	}
	
	public void clickAddBtn() {
		
		click(addBtn);
	}

	public void enterFirstName() {

		type(firstNameField,"FirstName "+generateRandomString(7),"First Name");
	}

	public void enterLastName() {

		type(lastNameField,"LastName "+generateRandomString(7),"Last Name");
	}

	public void enterEmployeeID() {
		
		type(employeeIDField,generateRandomString(5),"Employee ID");
	}
	
	public void clickSave() throws InterruptedException {
		
		click(submitBtn);
		Thread.sleep(1000);
	}
}
