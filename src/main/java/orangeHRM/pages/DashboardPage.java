package orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.base.SeleniumBase;

public class DashboardPage extends SeleniumBase{

	
	public DashboardPage(WebDriver rdriver) {
		super();
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[text()='My Actions']")
	private WebElement textForLoginValidation;
	
	@FindBy(partialLinkText="Leave")
	private WebElement leaveMenu;
	
	
	public Boolean isUserLoggedIn() throws InterruptedException {
		
		return isDisplayed(textForLoginValidation,"Dashboard");
	}
	
	public ApplyLeavePage clickLeaveMenu() {
		
		click(leaveMenu);
		return new ApplyLeavePage(driver);
	}
	
	
}
