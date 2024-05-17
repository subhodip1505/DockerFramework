package pages.flightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightConfirmationPage extends AbstractClass{
	
	private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);

	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[contains(text(),'Flight Confirmation #')]")
	private WebElement flightConfirmationText;
	
	@FindBy(xpath="//div[contains(text(),'Total Price')]/following-sibling::div/p")
	private WebElement flightPrice;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationText));
		return this.flightConfirmationText.isDisplayed();
	}
	
	public String getPrice()
	{
		String confText = this.flightConfirmationText.getText();
		String price = this.flightPrice.getText();
		log.info("Flight Status : {}",confText);
		log.info("Flight Price : {}",price);
		return price;
	}

}
