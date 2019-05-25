package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Common;

public class BasePage {
	
private static WebDriver _driver;
	
	public static WebDriver getDriver() 
	{
		if (_driver == null) 
		{
			initializeBrowser();
		}
		return _driver;
	}
	
	public static void initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		_driver = new ChromeDriver();
		_driver.get(Common.MAIN_URL);
		_driver.manage().window().maximize();
	}
	
	public static void closeBrowser()
	{
		getDriver().close();
	}
	
	public WebElement getElementById(String id)
	{
		return getDriver().findElement(By.id(id));
	}
	
	public WebElement getElementByXPath(String xpathExpression)
	{
		return getDriver().findElement(By.xpath(xpathExpression));
	}
	
	public void clickLinkByText(String text)
	{
		getDriver().findElement(By.partialLinkText(text)).click();;
	}
	
	public void type(String id, String value)
	{
		getElementById(id).sendKeys(value);
	}
	
	public void selectByValue(WebElement element, String value) {
	    Select selectElement = new Select(element);
	    selectElement.selectByIndex(1);
	    //selectElement.selectByValue(value);
	}
	
	public static void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public static void waitForVisibility(String elementId, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));		
	}
}
