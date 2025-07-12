package orangeHRM.base;

import java.io.IOException;
import java.time.Duration;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import orangeHRM.extentReport.ExtentManager;
import orangeHRM.utils.ReadInput;
import orangeHRM.utils.SendMail;


public class OrangeHRMBase extends SeleniumBase{
	
	SeleniumBase sb = new SeleniumBase();
	ReadInput read = new ReadInput();
	public String appURL = read.getAppURL();
	
	public WebDriver getDriver() {

		return driver;
	}

	public void setup(String URL) {
		
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}
	
	
	@Parameters("Browser")
	@BeforeSuite
	public void startApp(Browser browserName) throws InterruptedException {
		
		try {
			switch (browserName) {
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case EDGE:
				driver = new EdgeDriver();
				break;
			default:
				System.err.println("Driver is not defined");
				break;
			}
		} 
		
		catch (NoSuchElementException e) {
			System.err.println("Element not found =>"+e.getMessage());
		}
		catch(WebDriverException e) {
			System.err.println(e.getMessage());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		setup(appURL);
		
	}
	
	@AfterSuite
	public void closeApp() throws AddressException, MessagingException, IOException {
		
		sb.close();
		sb.quit();
		ExtentManager.extentReports.flush();
		SendMail sendMail = new SendMail();
		sendMail.sendMail();
		
	}
	
	
	
}
