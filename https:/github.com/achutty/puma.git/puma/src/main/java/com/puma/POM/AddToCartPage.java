package com.puma.POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.puma.UtillLib.BasePage;
/**
 * 
 * @author Asha Mabel James
 *
 */
public class AddToCartPage extends BasePage
{
	@FindBy(xpath="//a[contains(.,'IGNITE evoKNIT Lo 2 Men's Running Shoes')]")
	private WebElement productName;
	@FindBy(xpath="//*[@id=\"old-price-71793\"]")
	private WebElement productPrice;
	@FindBy(xpath="//div[@class='product-size-click-btn']")
	private WebElement productSizeBtn;
	@FindBy(xpath="//a[@name='8']/span[contains(.,'8')]")
	private WebElement size;
	@FindBy(xpath="//button[@onclick='productAddToCartForm.submit(this)']")
	private WebElement CartBtn;
	@FindBy(xpath="//h2[@class='product-name']/a")
	private WebElement productNameCart;
	@FindBy(xpath="//td[@class='product-cart-price']/span")
	private WebElement productPriceCart;
	
	
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clkAddToCartBtn()
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		productSizeBtn.click();
		size.click();
		verifyElementIsClickable(driver, CartBtn);
		jse.executeScript("arguments[0].click()",CartBtn);
	}
	public void verifyCartItem()
	{
		verifyElement(driver, productNameCart);
		String expectedName=productName.getText();
		String actualName=productNameCart.getText();
		Assert.assertEquals(actualName, expectedName);
	}
}
