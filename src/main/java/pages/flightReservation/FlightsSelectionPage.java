package pages.flightReservation;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsSelectionPage extends AbstractClass{

	public FlightsSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="departure-flight")
	private List<WebElement> departureFlightOptions;
	
	@FindBy(name="arrival-flight")
	private List<WebElement> arrivalFlightOptions;
	
	@FindBy(id="confirm-flights")
	private WebElement confirmFlightsButton;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(confirmFlightsButton));
		return this.confirmFlightsButton.isDisplayed();
	}
	
	public void selectFlights()
	{
		int random = ThreadLocalRandom.current().nextInt(0, departureFlightOptions.size());
		this.departureFlightOptions.get(random).click();
		this.arrivalFlightOptions.get(random).click();
	}
	
	public void confirmFlight()
	{
		this.confirmFlightsButton.click();
	}

}
