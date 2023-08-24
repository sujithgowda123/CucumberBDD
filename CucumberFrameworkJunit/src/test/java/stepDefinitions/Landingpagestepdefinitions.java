package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.Landingpage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Landingpagestepdefinitions {
	public WebDriver driver;
	public String landingpageProductName;
	TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;
	Landingpage landingpage;

	public Landingpagestepdefinitions(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		 this.landingpage = testcontextsetup.pageobjectmanager.getlandingpage();

	}

	@Given("User is on greencart  landing page")
	public void user_is_on_greencart_landing_page() {
		Assert.assertTrue(landingpage.getTitlelandingpage().contains("GreenKart"));

	}

	@When("^user searched with shortname (.+) and extracted actualname of product$")
	public void user_searched_with_shortname_and_extracted_actualname_of_product(String Shortname) {


		landingpage.landingpage(Shortname);

		testcontextsetup.landingpageProductName = landingpage.getproductname();
		System.out.println(testcontextsetup.landingpageProductName + "is extracted from home page");
	}
	@When("added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String Quantity) {
		
		landingpage.incrementQuantity(Integer.parseInt(Quantity));
		landingpage.AddtoCart();
		

	}


}
