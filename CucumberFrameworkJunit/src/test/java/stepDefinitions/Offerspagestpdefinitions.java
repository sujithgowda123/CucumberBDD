package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.Landingpage;
import pageObjects.Offerspage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Offerspagestpdefinitions {

	String offerPageproductname;
	TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;

	public Offerspagestpdefinitions(TestContextSetup testcontextsetup)

	{
		this.testcontextsetup = testcontextsetup;
	}

	@Then("^User searched for (.+) product in offers page$")
	public void user_searched_for_product_in_offers_page(String Shortname) throws InterruptedException {
		switchtoofferspage();
		Offerspage offerspage = testcontextsetup.pageobjectmanager.offerspage();
		Thread.sleep(3000);
		offerspage.productpage(Shortname);
		offerPageproductname = offerspage.getproductname();

	}

	public void switchtoofferspage() {
		// if (testcontextsetup.driver.getCurrentUrl()
		// .equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		// {
		Landingpage landingpage = testcontextsetup.pageobjectmanager.getlandingpage();
		landingpage.selecttopdealspage();
		testcontextsetup.genericutils.switchWindowToChild();
		
		// testcontextsetup.driver.findElement(By.linkText("Top Deals")).click();

	}

	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageproductname, testcontextsetup.landingpageProductName);

	}

}
