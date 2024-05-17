package pages.flightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmation extends AbstractClass{
	
	public WebDriver driver;

	public RegistrationConfirmation(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id="go-to-flights-search")
	private WebElement goToFlightSearchButton;
	
	@FindBy(xpath="//p[@class='mt-3']/b")
	private WebElement nameInText;
	
	public void goToFlightSearch()
	{
		this.goToFlightSearchButton.click();
	}
	
	public String getFirstName()
	{
		return this.nameInText.getText();
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(goToFlightSearchButton));
		return this.goToFlightSearchButton.isDisplayed();
	}

}
