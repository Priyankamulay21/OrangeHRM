package orangehrm.pomClasses;

import java.time.Duration;
import org.testng.annotations.Test;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class orangeHrm_PIMMOdule {
	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmployee;
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firsName;
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;
	@FindBy(xpath="//label[text()='Employee Id']/following::input[1]")private WebElement id;
	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement save;
	@FindBy(xpath="//h6[text()='Attachments']")private WebElement attchments;
	@FindBy(xpath = "(//button[@type='submit'])[2]")private WebElement save1;
	@FindBy(xpath="//button[text()=' Search ']")private WebElement search;
	@FindBy(xpath="//a[text()='Employee List']")private WebElement employeeList;
	@FindBy(xpath="//p[text()='manda user']")private WebElement Manda;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logout;
	
	private String employeeID;

	public orangeHrm_PIMMOdule(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddEmployee(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));

		w.until(ExpectedConditions.visibilityOf(addEmployee)).click();
	}

	public void createFirstEmployee(WebDriver driver,String fn,  String ln) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		w.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fn);
		
		
		employeeID = id.getAttribute("value");
		
		System.out.println(employeeID);
		
		
		w.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(ln);
		w.until(ExpectedConditions.visibilityOf(save)).click();

	}

	public void saveANewCreatedEmployee(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		//Actions a=new Actions(driver);
		//a.scrollToElement(attchments).build().perform();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",attchments);

		w.until(ExpectedConditions.visibilityOf(save1)).click();
	}
	
	public void searchEmployeeThroughID(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		
		id.sendKeys(employeeID);
		w.until(ExpectedConditions.elementToBeClickable(search)).click();
		
	}
	
	public void clickOnEmployeeList(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		w.until(ExpectedConditions.elementToBeClickable(employeeList)).click();
	}
	
	public void logoutOrangeHRM(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		w.until(ExpectedConditions.elementToBeClickable(Manda)).click();
		w.until(ExpectedConditions.elementToBeClickable(logout)).click();
		
	}
	
	
	

}
