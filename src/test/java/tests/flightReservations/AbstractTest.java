package tests.flightReservations;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.vendorPortal.DashboardPage;
import pages.vendorPortal.LoginPage;
import test.Listeners.TestListeners;
import test.vendorPortal.utils.Config;
import test.vendorPortal.utils.Constants;

@Listeners({TestListeners.class})
public abstract class AbstractTest {
	
	protected WebDriver driver;
	private static final Logger log=LoggerFactory.getLogger(AbstractTest.class);
	
	@BeforeSuite
	public void setupConfig() throws IOException
	{
		Config.initialize();
	}
	
	@BeforeTest
	public void setDriver(ITestContext ctx) throws MalformedURLException {
		if(Config.get(Constants.GRID_ENABLED).equalsIgnoreCase("true"))
		{
			this.driver = getRemoteDriver();
		}else {
			this.driver = getLocalDriver();
		}
		ctx.setAttribute(Constants.DRIVER, this.driver);
	}
	
	private WebDriver getRemoteDriver() throws MalformedURLException
	{
		Capabilities capabilities = new ChromeOptions();
		if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER)))
		{
			capabilities=new FirefoxOptions();
		}
		//if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);
		log.info("The url formed: {}",url);
		return new RemoteWebDriver(new URL(url),capabilities);
	}
	
	private WebDriver getLocalDriver()
	{
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterTest
	public void closeBrowsers()
	{
		this.driver.quit();
	}

}
