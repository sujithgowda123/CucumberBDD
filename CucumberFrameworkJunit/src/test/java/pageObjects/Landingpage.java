package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landingpage {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.cssSelector("input[class='search-keyword']");
	By product = (By.cssSelector("h4.product-name"));
	By topdeals = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.xpath("//button[text()='ADD TO CART']");

	public void landingpage(String name) {
		driver.findElement(search).sendKeys(name);

	}

	public String getproductname() {
		return driver.findElement(product).getText().split("-")[0].trim();
	}

	public void selecttopdealspage() {
		driver.findElement(topdeals).click();
	}

	public String getTitlelandingpage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity;
		while (i > 1) {
			driver.findElement(increment).click();
			i--;
		}

	}

	public void AddtoCart() {

		driver.findElement(addToCart).click();
	}

}
