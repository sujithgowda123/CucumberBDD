package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By Itemname=By.cssSelector("p.product-name");

	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}

	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();

	}

	public boolean verifyPlaceorder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	public String actualProduct()
	{
	return	driver.findElement(Itemname).getText().split("-")[0].trim();
	}

}
