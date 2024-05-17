package pages.flightReservation;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractClass {
	
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	
	public AbstractClass(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public abstract boolean isAt();
	

}
