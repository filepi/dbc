package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomerListPage extends BasePage{

	WebDriver driver 					= BasePage.getDriver();
	private String addCustomer 			= "Add Customer";
	private String searchIconClass  	= "search-button";
	private String searchInputClass  	= "search-input";
	private String checkboxSelectClass  = "select-row";
	private String deleteRowClass  		= "delete-selected-button";
	private String deleteConfirmClass	= "delete-multiple-confirmation-button";
	
	public void changeComboboxToV4()
	{
		selectByIndex(getElementById("switch-version-select"));
	}
	
	public void clickAddCustomer()
	{
		clickLinkByText(addCustomer);
	}
	
	public void clickSearchButton() {
		waitForVisibilityByClassName(searchIconClass, 3);
		driver.findElement(By.className(searchIconClass)).click();
	}
	
	public void typeSearchButton(String text) {
		waitForVisibilityByClassName(searchInputClass, 3);
		WebElement searchButton = getElementByClassName(searchInputClass);
		searchButton.sendKeys(text);
		searchButton.sendKeys(Keys.ENTER);
	}

	public void selectItem() {
		sleep(2);
		waitForVisibilityByClassName(checkboxSelectClass, 3);
		WebElement element = getElementByClassName(checkboxSelectClass);
		Actions act = new Actions(driver);
		act.moveToElement(element).click();
		element.click();
	}

	public void deleteRow() {
		getElementByClassName(deleteRowClass).click();
	}
	
	public void deleteConfirmation() {
		getElementByClassName(deleteConfirmClass).click();;
	}
	
	public boolean verifyConfirmationDeleteMessageIs(String message) {
		return getElementsByTagName("p").get(2).getText().equals(message);
	}
	
	public boolean verifyDeleteMessageIs(String message) {
		sleep(2);
		return getElementsByTagName("p").get(3).getText().equals(message);
	}

}
