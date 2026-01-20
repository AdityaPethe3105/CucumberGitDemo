package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestContextSetUp;

public class CheckOutPageStepDefinition {
	
	public WebDriver driver;
	TestContextSetUp testContextSetUp;
	public CheckOutPage checkoutPage;
	public String checkOutPageProductName;

	public CheckOutPageStepDefinition(TestContextSetUp testContextSetup)
	{
		this.testContextSetUp=testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}


	@Then("verify user has ability to enter promo code and place the order")
	public void  verify_user_has_ability_enter_promo()
	{
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}

	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutPage.CheckoutItems();
		//Assertion to extract name from screen and compare with name
		checkoutPage.verifyProductName();
		
		Thread.sleep(2000);
		testContextSetUp.checkOutPageProductName = checkoutPage.verifyProductName().split("-")[0].trim();
		System.out.println(checkOutPageProductName);
	}

}
