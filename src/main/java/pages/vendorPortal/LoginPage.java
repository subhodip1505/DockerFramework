package pages.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.flightReservation.AbstractClass;

public class LoginPage extends AbstractClass{
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(id="username")
	private WebElement usernameIp;
	
	@FindBy(id="password")
	private WebElement passwordIp;
	
	@FindBy(id="login")
	private WebElement loginButton;
	

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(loginButton));
		return this.loginButton.isDisplayed();
	}
	
	public void goTo(String url) {
		this.driver.get(url);
	}
	
	public void login(String username, String password)
	{
		this.usernameIp.sendKeys(username);
		this.passwordIp.sendKeys(password);
		this.loginButton.click();
	}
	
	

}
