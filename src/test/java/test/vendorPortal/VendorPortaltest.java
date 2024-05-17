package test.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.vendorPortal.DashboardPage;
import pages.vendorPortal.LoginPage;
import test.vendorPortal.utils.Config;
import test.vendorPortal.utils.Constants;
import test.vendorPortal.utils.JsonUtils;
import tests.flightReservations.AbstractTest;

public class VendorPortaltest extends AbstractTest{
	
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private VendorPortalTestData testData;
	
	@BeforeTest
	@Parameters("testDataPath")
	public void setPageObjects(String path) {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		this.testData= JsonUtils.getTestdata(System.getProperty("user.dir")+"/test-data/vendor-portal/"+path, VendorPortalTestData.class);
	}
	
	@Test
	public void loginTest()
	{
		loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
		Assert.assertTrue(loginPage.isAt());
		loginPage.login(testData.username(), testData.password());
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void dashboardTest()
	{
		Assert.assertTrue(dashboardPage.isAt());
		Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
		Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
		Assert.assertEquals(dashboardPage.getProfitmargin(), testData.profitMargin());
		Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());
		dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
		int noOfSearchRes = dashboardPage.getSearchResults();
		Assert.assertEquals(noOfSearchRes, testData.searchResultsCount());
		dashboardPage.logout();
	}
	
}
