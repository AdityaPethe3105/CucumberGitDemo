package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;

public class OfferPageStepDefinition {

	public String offerPageproductName;
	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp = testContextSetUp;
	}


	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

		switchToOffersPage();
		
		OffersPage offersPage = testContextSetUp.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);

		Thread.sleep(2000);
		offerPageproductName = offersPage.getProductName();
		System.out.println(offerPageproductName);
	}
	
	public void switchToOffersPage() {
		
		//if(testContextSetUp.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		
		LandingPage landingPage = testContextSetUp.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetUp.genericUtils.switchWindowToChild();
	}

	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetUp.landingPageproductName, offerPageproductName);
		//testContextSetUp.driver.quit();
	}

}
