package com.puma.POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.puma.UtillLib.BasePage;
/**
 * 
 * @author Asha MAbel James
 *
 */
public class HomePage extends BasePage {

	@FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']/li[2]")
	WebElement secondShoe;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void naviGateToProduct(String menutype , String type , String options) 
	{
		Actions act = new Actions(driver);
		String Xpath = "//a[text()='"+type+"' and contains(@href,'"+menutype+"')]/../../following-sibling::li/a[text()='"+options+"']";

		act.moveToElement(driver.findElement(By.linkText(menutype.toUpperCase()))).perform();
		WebElement element=driver.findElement(By.xpath(Xpath));
		verifyElement(driver, element);
		element.click();
	}
	public void scrollToElementAndClick()
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		 Point y = secondShoe.getLocation();
		 j.executeScript("window.scrollTo(0,"+y+")");
		 verifyElementIsClickable(driver, secondShoe);
		 ArrayList<String> lstWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(lstWindows.get(1));
	}
	
	public void verfiyTitle()
	{
		verifyTitle(driver, "Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com");
	}
	
	public String productText()
	{
		return secondShoe.getText();
	}


}
