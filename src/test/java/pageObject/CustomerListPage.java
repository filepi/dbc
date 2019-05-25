package pageObject;

import org.openqa.selenium.WebDriver;

public class CustomerListPage extends BasePage{

	WebDriver driver = BasePage.getDriver();
	private String addCustomer = "Add Customer";
	
	public void changeComboboxToV4()
	{
		selectByValue(getElementById("switch-version-select"), "Bootstrap V4 Theme");
	}
	
	public void clickAddCustomer()
	{
		clickLinkByText(addCustomer);
	}

}
