package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public Landingpage landingpage;
	public Offerspage offerspage;
	CheckOutPage checkoutpage;
	WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public Landingpage getlandingpage() {

		landingpage = new Landingpage(driver);
		return landingpage;
	}

	public Offerspage offerspage() {
		offerspage = new Offerspage(driver);
		return offerspage;
	}
	public CheckOutPage checkoutpage()
	{
		checkoutpage=new CheckOutPage(driver);
				return checkoutpage;
	}

}
