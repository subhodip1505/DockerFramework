package pages.flightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends AbstractClass{
	public WebDriver driver;

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="street")
	private WebElement streetAddress;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="zip")
	private WebElement zip;
	
	@FindBy(id="register-btn")
	private WebElement regButton;
	
	public void goTo(String url)
	{
		this.driver.get(url);
	}
	
	public void enterUserDetails(String firstNameIp, String lastNameIp)
	{
		this.firstName.sendKeys(firstNameIp);
		this.lastName.sendKeys(lastNameIp);
	}
	
	public void enterUserCredentials(String emailIp, String passwordIp)
	{
		this.email.sendKeys(emailIp);
		this.password.sendKeys(passwordIp);
	}
	
	public void enterAddressDetails(String streetAddressIp, String cityIp, String zipIp)
	{
		this.streetAddress.sendKeys(streetAddressIp);
		this.city.sendKeys(cityIp);
		this.zip.sendKeys(zipIp);
	}
	
	public void clickOnRegisterButton()
	{
		this.regButton.click();
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
		return this.firstName.isDisplayed();
	}
}
