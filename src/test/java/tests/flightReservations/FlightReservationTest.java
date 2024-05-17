package tests.flightReservations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.flightReservation.FlightConfirmationPage;
import pages.flightReservation.FlightSearchPage;
import pages.flightReservation.FlightsSelectionPage;
import pages.flightReservation.RegistrationConfirmation;
import pages.flightReservation.RegistrationPage;
import test.vendorPortal.utils.Config;
import test.vendorPortal.utils.Constants;
import test.vendorPortal.utils.JsonUtils;

public class FlightReservationTest extends AbstractTest{
	
	private FlightReservationTestData testData;
	
	@BeforeTest
	@Parameters("testDataPath")
	public void setParameters(String path)
	{
		this.testData = JsonUtils.getTestdata(System.getProperty("user.dir")+"/test-data/flight-reservation/"+path, FlightReservationTestData.class);
	}
	
	@Test
	public void userRegistration()
	{
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
		Assert.assertTrue(registrationPage.isAt());
		registrationPage.enterUserDetails(testData.firstname(), testData.lastname());
		registrationPage.enterUserCredentials(testData.email(), testData.password());
		registrationPage.enterAddressDetails(testData.street(), testData.city(), testData.zip());
		registrationPage.clickOnRegisterButton();
	}
	
	@Test(dependsOnMethods = "userRegistration")
	public void userRegistrationConfirmation()
	{
		RegistrationConfirmation registrationConfirmation = new RegistrationConfirmation(driver);
		Assert.assertTrue(registrationConfirmation.isAt());
		Assert.assertEquals(registrationConfirmation.getFirstName(), testData.firstname());
		registrationConfirmation.goToFlightSearch();
	}
	
	@Test(dependsOnMethods = "userRegistrationConfirmation")
	public void flightSearch()
	{
		FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
		Assert.assertTrue(flightSearchPage.isAt());
		flightSearchPage.selectNumberOfPassengersToBeSelected(testData.passengerCount());
		flightSearchPage.searchFlight();
	}
	
	@Test(dependsOnMethods = "flightSearch")
	public void flightSelection()
	{
		FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage(driver);
		Assert.assertTrue(flightsSelectionPage.isAt());
		flightsSelectionPage.selectFlights();
		flightsSelectionPage.confirmFlight();
	}
	
	@Test(dependsOnMethods = "flightSelection")
	public void flightConfirmation()
	{
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		Assert.assertTrue(flightConfirmationPage.isAt());
		String price = flightConfirmationPage.getPrice();
		Assert.assertEquals(price, testData.expectedPrice());
	}
	

}
