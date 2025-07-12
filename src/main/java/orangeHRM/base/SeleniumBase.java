package orangeHRM.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static orangeHRM.extentReport.ExtentTestManager.getTest;

import com.aventstack.extentreports.Status;

public class SeleniumBase implements SeleniumAPI{
	
	long timeOuts = 30;
	long maxWaitTime = 10;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public void switchToWindow(int i) {
		
		try {
			Set<String> windowHandles = driver.getWindowHandles();  
			//for(String AllWindows:windowHandles){driver.switchTo().window(AllWindows)}
			
			ArrayList<String> list = new ArrayList<String>(windowHandles);
			driver.switchTo().window(list.get(i));
			getTest().log(Status.PASS, "Switched successfully to expected window");
		}catch (Exception e) {
			System.out.println("Exception would have occured =>"+e.getMessage());
		}
	}


	@Override
	public void selectValue(WebElement ele, String value) {
		try {
			WebElement element = isElementClickable(ele);
			new Select(element).selectByValue(value);
			getTest().log(Status.PASS, "Expected value in dropdown is selected.");
		}catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
	}

	@Override
	public void selectText(WebElement ele, String text) {
		try {
			WebElement element = isElementClickable(ele);
			new Select(element).selectByVisibleText(text);
			getTest().log(Status.PASS, "Input is typed");
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
	}

	@Override
	public void selectIndex(WebElement ele, int position) {
		try {
			WebElement element = isElementClickable(ele);
			new Select(element).selectByIndex(position);
			getTest().log(Status.PASS, "Expected value in dropdown is selected.");
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
	}
	
	@Override
	public void isDropdownSelected(WebElement ele) {
		try {
			ele.isSelected();
			getTest().log(Status.PASS, "Expected value is selected.");
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
	}

	@Override
	public void click(WebElement ele) {
		try {
			WebElement element = isElementClickable(ele);
			element.click();
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
	}

	private WebElement isElementClickable(WebElement ele) {
		WebElement element = wait.withMessage("Element is not visible").until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}

	@Override
	public void type(WebElement ele, String input, String fieldName) {
		
		try {
			WebElement element = isElementClickable(ele);
			element.click();
			element.clear();
			element.sendKeys(input);
			getTest().log(Status.PASS, fieldName+" is entered");
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
	}
	

	@Override
	public void typeEnter(WebElement ele,String input, Keys keys) {
		
		WebElement webElement;
		try {
			webElement = wait.until(ExpectedConditions.elementToBeClickable(ele));
			webElement.sendKeys(input,keys);
			getTest().log(Status.PASS, "Input is typed");
			//entering elements without using sendkeys
			/*// JavaScript Executor to enter text
      JavascriptExecutor j = (JavascriptExecutor)driver;
      j.executeScript ("document.getElementById('gsc-i-id1').value='Selenium'");*/
			
			
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
		
		
	}

	@Override
	public void appendText(WebElement ele, String text) {
		
		try {
			WebElement element = isElementClickable(ele);
			element.sendKeys(text);
			getTest().log(Status.PASS, "Input is typed");
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		
	}

	@Override
	public String getTitle(String expectedTitle) {
	
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			getTest().log(Status.PASS, "Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		}catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		return driver.getTitle();
	}

	@Override
	public String getURL(String expectedURL) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedURL);
			getTest().log(Status.PASS, "Actual URL : " + driver.getCurrentUrl() + " - equals to Expected URL : " + expectedURL);
		}catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}catch (NoSuchElementException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		return driver.getCurrentUrl();
	}

	@Override
	public Boolean isDisplayed(WebElement ele,String elementName) throws InterruptedException {
		
		try {
			wait = new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
			ele = wait.until(ExpectedConditions.visibilityOf(ele));
			Thread.sleep(3000);
			getTest().log(Status.PASS, elementName+" is displayed");
		} catch (InterruptedException e) {
			
			System.out.println("Element might be null =>"+e.getMessage());
			getTest().log(Status.FAIL, e.getMessage());
		}
		return  ele.isDisplayed();
	}

	@Override
	public void acceptAlert() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			getTest().log(Status.PASS, "Page Alert Accepted");
		} catch (Exception e) {
			getTest().log(Status.FAIL, e.getMessage());
		}
	}

	
	
	
	


	

}
