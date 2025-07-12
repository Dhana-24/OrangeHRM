package orangeHRM.test;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import orangeHRM.base.OrangeHRMBase;
import orangeHRM.pages.DashboardPage;
import orangeHRM.pages.LoginPage;
import orangeHRM.utils.ReadExcel;

import static orangeHRM.extentReport.ExtentTestManager.startTest;
import static orangeHRM.extentReport.ExtentTestManager.getTest;

public class LoginTest extends OrangeHRMBase {
	
	public String fileName ="LoginCredentials";
	
	
	
	@DataProvider(name="data")
	public String[][] dataProvider() {
		
		fileName = "LoginCredentials";
		String[][] excelData =ReadExcel.getExcelData(fileName);
		return excelData;
		
	}
	
	@Test(dataProvider="data",groups ={"LoginTest.Login"})
	public void Login(String[] data,Method method) throws InterruptedException {
		
		startTest(method.getName(), "Login with username and password.");
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(data[0]);
		login.enterPassword(data[1]);
		login.clickLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		Boolean actualResult = dashboard.isUserLoggedIn();
		System.out.println("Is dashboard displayed? "+actualResult);
		
		Assert.assertTrue(actualResult, "User logged in successfully");
		
		getTest().log(Status.PASS,"Login is successful.");
		

		
	}
	
	
	
}
