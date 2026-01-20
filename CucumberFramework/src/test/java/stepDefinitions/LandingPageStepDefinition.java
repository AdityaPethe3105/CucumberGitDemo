package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetUp;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageproductName;
	TestContextSetUp testContextSetUp;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp = testContextSetUp;
		this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	}


	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		
		landingPage.searchItem(shortName);
		
		Thread.sleep(2000);
		testContextSetUp.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageproductName);
	}

	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
}
