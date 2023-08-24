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
import pageObjects.CheckOutPage;
import pageObjects.Landingpage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPagestepdefinitions {
	public WebDriver driver;
	public String landingpageProductName;
	TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;
	public CheckOutPage checkoutpage;
	public String productincheckoutpage;

	public CheckoutPagestepdefinitions(TestContextSetup testcontextsetup) {
		this.testcontextsetup = testcontextsetup;
		this.checkoutpage = testcontextsetup.pageobjectmanager.checkoutpage();


	}


	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) {
		checkoutpage.CheckoutItems();
		productincheckoutpage = checkoutpage.actualProduct();
		Assert.assertEquals(productincheckoutpage, name);

	}

	@Then("verify user has ability to apply promocode and place the order")
	public void verify_user_has_ability_to_apply_promocode_and_place_the_order() {
		Assert.assertFalse(checkoutpage.verifyPromoBtn());
		Assert.assertTrue(checkoutpage.verifyPlaceorder());

	}

}
