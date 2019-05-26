package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
private static  WebDriver _driver;
public final String MAIN_URL = "https://www.grocerycrud.com/demo/bootstrap_theme";
	
	public WebDriver getDriver() 
	{
		if (_driver == null) 
		{
			initializeBrowser();
		}
		return _driver;
	}
	
	public void initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		_driver = new ChromeDriver();
		_driver.get(MAIN_URL);
		_driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		getDriver().close();
	}
	
	public WebElement getElementById(String id)
	{
		return getDriver().findElement(By.id(id));
	}

	public WebElement getElementByCSS(String cssSelector)
	{
		return getDriver().findElement(By.cssSelector(cssSelector));
	}
	
	public List<WebElement> getElementsByTagName(String tagName)
	{
		return getDriver().findElements(By.tagName(tagName));
	}
	
	public WebElement getElementByXPath(String xpathExpression)
	{
		return getDriver().findElement(By.xpath(xpathExpression));
	}
	
	public WebElement getElementByClassName(String className)
	{
		return getDriver().findElement(By.className(className));
	}
	
	public void clickLinkByText(String text)
	{
		getDriver().findElement(By.partialLinkText(text)).click();;
	}
	
	public void type(String id, String value)
	{
		getElementById(id).sendKeys(value);
	}
	
	public void selectByIndex(WebElement element) {
	    Select selectElement = new Select(element);
	    selectElement.selectByIndex(1);
	}
	
	public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public void waitForVisibilityById(String elementId, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));		
	}
	
	public void waitForVisibilityByClassName(String className, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}
	
	public void sleep(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println("Error during sleep execution");
			e.printStackTrace();
		}
	}
}
