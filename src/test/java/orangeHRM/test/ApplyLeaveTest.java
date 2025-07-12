package orangeHRM.test;

import static orangeHRM.extentReport.ExtentTestManager.getTest;
import static orangeHRM.extentReport.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import orangeHRM.base.OrangeHRMBase;
import orangeHRM.pages.ApplyLeavePage;

public class ApplyLeaveTest extends OrangeHRMBase{

	@Test(dependsOnGroups = {"LoginTest.Login"})
	public void ApplyLeave(Method method) throws InterruptedException {
		
		startTest(method.getName(), "Apply leave");
		
		ApplyLeavePage applyLeave = new ApplyLeavePage(driver);
		applyLeave.clickApplyLeaveMenu();
		applyLeave.applyLeave();
		applyLeave.chooseLeaveType();
		applyLeave.chooseLeaveDate();
		applyLeave.clickApply();
		
		getTest().log(Status.PASS,"Leave is applied.");


	}
	
}
