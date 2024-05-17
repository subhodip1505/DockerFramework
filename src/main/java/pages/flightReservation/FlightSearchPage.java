package pages.flightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractClass{

	public FlightSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="passengers")
	private WebElement noOfPassengers;
	
	@FindBy(id="search-flights")
	private WebElement searchFlight;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(noOfPassengers));
		return this.noOfPassengers.isDisplayed();
	}
	
	public void selectNumberOfPassengersToBeSelected(String noOfPeopleSelected)
	{
		Select noPass = new Select(noOfPassengers);
		noPass.selectByValue(noOfPeopleSelected);
	}
	public void searchFlight()
	{
		this.wait.until(ExpectedConditions.elementToBeClickable(searchFlight));
		this.searchFlight.click();
	}

}
