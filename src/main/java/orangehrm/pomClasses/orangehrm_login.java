package orangehrm.pomClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Reporter;

public class orangehrm_login {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginButton;
	
	//click on PIM module
	
	@FindBy(xpath="//span[text()='PIM']")private WebElement pim;

	public orangehrm_login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginUsingValidCredentials(WebDriver driver, String un, String pwd) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		w.until(ExpectedConditions.elementToBeClickable(userName)).sendKeys(un);
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pwd);
		
		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

	}
	
	public void clickOnPIMModule(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		w.until(ExpectedConditions.elementToBeClickable(pim)).click();
		
	}

}
