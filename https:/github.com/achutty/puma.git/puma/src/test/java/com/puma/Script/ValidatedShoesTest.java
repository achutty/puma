package com.puma.Script;

import org.testng.annotations.Test;

import com.puma.POM.AddToCartPage;
import com.puma.POM.HomePage;
import com.puma.UtillLib.BaseTest;
/**
 * 
 * @author Asha Mabel James
 *
 */
public class ValidatedShoesTest extends BaseTest {
	@Test
	public void validateShoes()
	{
		/*Navigate to "https://in.puma.com"*/		
		HomePage hp = new HomePage(driver);
		/*Assert the page title*/
		hp.verfiyTitle();
		/*Click on Men/Shoes/Running*/
		hp.naviGateToProduct("men", "Shoes", "Running");
		/*Click on the second shoe from listing page*/
		hp.scrollToElementAndClick();
		/*Add the shoe to cart from product detail page (for any size or quantity)*/
		AddToCartPage addCart = new AddToCartPage(driver);
		addCart.clkAddToCartBtn();
		
		/*Assert that the cart has the correct shoe selected in previous step (Based on name of product/quantity/price)*/ 
		addCart.verifyCartItem();
	}

}
