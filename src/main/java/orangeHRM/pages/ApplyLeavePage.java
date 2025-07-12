package orangeHRM.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import orangeHRM.base.SeleniumBase;

public class ApplyLeavePage extends SeleniumBase{
	

	public ApplyLeavePage(WebDriver rdriver) {
		//super();
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText="Leave")
	private WebElement leaveMenu;
	
	@FindBy(partialLinkText="Apply")
	private WebElement applyLeaveBtn;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private WebElement leaveTypeDrpDwn;
	
	@FindBy(xpath="//div//span[contains(text(),'CAN - FMLA')]")
	private WebElement leaveType;
	
	@FindBy(xpath="//input[@placeholder='yyyy-dd-mm']")
	private WebElement leaveDateField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement applyBtn;
	
	
	public void clickApplyLeaveMenu() {
		click(leaveMenu);
	}
	
	public void applyLeave() {
		
		click(applyLeaveBtn);
	}

	public void chooseLeaveType() {
		
		click(leaveTypeDrpDwn);
		click(leaveType);
	}
	
	public void chooseLeaveDate() {
		
		LocalDate date = LocalDate.now();
		LocalDate newDate = date.plusDays(30);
		
		String leaveDate = newDate.format(DateTimeFormatter.ofPattern("yyyy-dd-MM")) ;
		type(leaveDateField,leaveDate,"Leave Date");
	}
	
	public void clickApply() throws InterruptedException {
		
		click(applyBtn);
		Thread.sleep(1000);
	}
}
