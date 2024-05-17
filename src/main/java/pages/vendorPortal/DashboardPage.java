package pages.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.flightReservation.AbstractClass;
import pages.flightReservation.FlightConfirmationPage;

public class DashboardPage extends AbstractClass{

	private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="monthly-earning")
	private WebElement monthlyEarning;
	
	@FindBy(id="annual-earning")
	private WebElement annualEarning;
	
	@FindBy(id="profit-margin")
	private WebElement profitMargin;
	
	@FindBy(id="available-inventory")
	private WebElement availableInventory;
	
	@FindBy(css="input[type='search']")
	private WebElement searchInput;
	
	@FindBy(id="dataTable_info")
	private WebElement searchResultsCountElement;
	
	@FindBy(css=".img-profile")
	private WebElement userProfilePictureElement;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLinkUserProfDrpDwn;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logoutButton;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(monthlyEarning));
		return this.monthlyEarning.isDisplayed();
	}
	
	public String getMonthlyEarning()
	{
		return this.monthlyEarning.getText();
	}
	
	public String getAnnualEarning()
	{
		return this.annualEarning.getText();
	}
	
	public String getProfitmargin()
	{
		return this.profitMargin.getText();
	}
	
	public String getAvailableInventory()
	{
		return this.availableInventory.getText();
	}
	
	public void searchOrderHistoryBy(String keyword)
	{
		this.searchInput.sendKeys(keyword);
	}
	
	public int getSearchResults()
	{
		String resulttext = this.searchResultsCountElement.getText();
		String[] arr = resulttext.split(" ");
		int count = Integer.parseInt(arr[5]);
		log.info("Result count: {}", count);
		return count;
	}
	
	public void logout()
	{
		this.userProfilePictureElement.click();
		this.wait.until(ExpectedConditions.visibilityOf(logoutLinkUserProfDrpDwn));
		this.logoutLinkUserProfDrpDwn.click();
		this.wait.until(ExpectedConditions.visibilityOf(logoutButton));
		this.logoutButton.click();
	}

}
