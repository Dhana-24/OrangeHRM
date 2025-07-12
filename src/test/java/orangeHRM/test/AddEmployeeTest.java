package orangeHRM.test;

import static orangeHRM.extentReport.ExtentTestManager.startTest;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import orangeHRM.base.OrangeHRMBase;
import orangeHRM.pages.AddEmployeePage;

import static orangeHRM.extentReport.ExtentTestManager.getTest;

public class AddEmployeeTest extends OrangeHRMBase{
	
	@Test(dependsOnGroups = {"LoginTest.Login"})
	public void AddEmployee(Method method) throws InterruptedException {
		
		startTest(method.getName(), "Add employee name");
		
		AddEmployeePage addEmployee = new  AddEmployeePage(driver);
		addEmployee.clickPIMMenu();
		addEmployee.clickAddBtn();
		addEmployee.enterFirstName();
		addEmployee.enterLastName();
		addEmployee.enterEmployeeID();
		addEmployee.clickSave();
		
		getTest().log(Status.PASS,"Employee is added.");


	}

}
