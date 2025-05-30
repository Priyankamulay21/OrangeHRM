package orangeHrm_testNgClass;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangehrm.baseClass.baseClass;
import orangehrm.pomClasses.orangeHrm_PIMMOdule;
import orangehrm.pomClasses.orangehrm_login;

public class NewTest extends baseClass {

	orangehrm_login ol;
	orangeHrm_PIMMOdule op;

	@BeforeMethod
	public void createSetUp() throws IOException {

		launchThebrowser();
		ol = new orangehrm_login(driver);
		op = new orangeHrm_PIMMOdule(driver);
		ol.loginUsingValidCredentials(driver, "Admin", "admin123");
		ol.clickOnPIMModule(driver);
		

	}

	@Test
	public void createFirstEmployee() throws InterruptedException {
		
		op.clickOnAddEmployee(driver);
		op.createFirstEmployee(driver,"a01015" ,"aa01015");
		
		op.saveANewCreatedEmployee(driver);
		op.clickOnEmployeeList(driver);
		Thread.sleep(2000);
		op.searchEmployeeThroughID(driver);
		op.logoutOrangeHRM(driver);
		
		
	}
	
	
	
	@Test(enabled = true)
	public void createSecondEmployee() {
		
		
		op.clickOnAddEmployee(driver);
		op.createFirstEmployee(driver,"a01016" ,"aa01016");
		op.saveANewCreatedEmployee(driver);
		op.clickOnEmployeeList(driver);
		op.searchEmployeeThroughID(driver);
		op.logoutOrangeHRM(driver);
		
		

	}
	
	
	
	@Test(enabled = true)
	public void createThirdEmployee() {
		
		op.clickOnAddEmployee(driver);
		op.createFirstEmployee(driver,"a01017" ,"aa01017");
		op.saveANewCreatedEmployee(driver);
		op.clickOnEmployeeList(driver);
		op.searchEmployeeThroughID(driver);
		op.logoutOrangeHRM(driver);
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
