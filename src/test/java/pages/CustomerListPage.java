package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomerListPage extends BasePage{

	WebDriver driver 					=  getDriver();
	private String _addCustomer 		= "Add Customer";
	private String _searchIconClass  	= "search-button";
	private String _searchInputClass  	= "search-input";
	private String _checkboxSelectClass = "select-row";
	private String _deleteRowClass  	= "delete-selected-button";
	private String _deleteConfirmClass	= "delete-multiple-confirmation-button";
	
	public void setBootstrapVersionToV4()
	{
		selectByIndex(getElementById("switch-version-select"));
	}
	
	public void clickAddCustomer()
	{
		clickLinkByText(_addCustomer);
	}
	
	public void clickSearchButton() {
		waitForVisibilityByClassName(_searchIconClass, 3);
		driver.findElement(By.className(_searchIconClass)).click();
	}
	
	public void typeSearchButton(String text) {
		waitForVisibilityByClassName(_searchInputClass, 3);
		WebElement searchButton = getElementByClassName(_searchInputClass);
		searchButton.sendKeys(text);
		searchButton.sendKeys(Keys.ENTER);
	}

	public void selectItem() {
		sleep(2);
		waitForVisibilityByClassName(_checkboxSelectClass, 3);
		WebElement element = getElementByClassName(_checkboxSelectClass);
		Actions act = new Actions(driver);
		act.moveToElement(element).click();
		element.click();
	}

	public void clickDeleteButton() {
		getElementByClassName(_deleteRowClass).click();
	}
	
	public void confirmDelete() {
		getElementByClassName(_deleteConfirmClass).click();;
	}
	
	public boolean verifyConfirmationDeleteMessageIs(String message) {
		return getElementsByTagName("p").get(2).getText().equals(message);
	}
	
	public boolean verifyDeleteMessageIs(String message) {
		sleep(2);
		return getElementsByTagName("p").get(3).getText().equals(message);
	}

}
