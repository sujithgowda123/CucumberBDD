package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offerspage {

	WebDriver driver;

	public Offerspage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By offerPageproduct = By.cssSelector("tr td:nth-child(1)");

	public void productpage(String name) {
		driver.findElement(search).sendKeys(name);

	}

	public String getproductname() {
		return driver.findElement(offerPageproduct).getText().trim();
	}

}
