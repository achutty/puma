package com.puma.UtillLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
/**
 * 
 * @author Asha Mabel James
 *
 */
public abstract class BasePage 
{
	public WebDriver driver;
	
	public void verifyTitle(WebDriver driver,String title)
	{
	
		String eTitle=driver.getTitle();
		Reporter.log(eTitle, true);
		try
		{
			Assert.assertEquals(title, eTitle);
			Reporter.log("Expected title is matching with Actual title", true);
		}
		catch (Exception e) 
		{
			Reporter.log("Expected title is not matching with Actual title", true);
		}
		
	}
	
	public void verifyElement(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("The element is visible", true);
		}
		catch (Exception e) 
		{
			Reporter.log("Element still not visible ", true);
		}
	}
	
	public void verifyElementIsClickable(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log("The element is clickable", true);
			element.click();
		}
		catch (Exception e) 
		{
			Reporter.log("Element is not clickable ", true);
		}
	}

}
