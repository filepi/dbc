package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerAddPage extends BasePage{

	private String _customerNameId 		= "field-customerName";
	private String _lastNameId 			= "field-contactLastName";
	private String _contactFirstNameId 	= "field-contactFirstName";
	private String _phoneId 			= "field-phone";
	private String _addressLine1Id 		= "field-addressLine1";
	private String _addressLine2Id 		= "field-addressLine2";
	private String _cityId 				= "field-city";
	private String _stateId 			= "field-state";
	private String _postalCodeId 		= "field-postalCode";
	private String _countryId 			= "field-country";
	private String _employeerXPath 		= "/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/div/div/input";
	private String _creditLimitId 		= "field-creditLimit";
	private String _btnSaveId 			= "form-button-save";
	private String goBackToList			= "Go back to list";
	
	WebDriver driver = getDriver();

	public void set_customerName(String value) {
		type(_customerNameId, value);
	}

	public void set_contactLastName(String value) {
		type(_lastNameId, value);
	}

	public void set_contactFirstName(String value) {
		type(_contactFirstNameId, value);
	}

	public void set_phone(String value) {
		type(_phoneId, value);
	}

	public void set_addressLine1(String value) {
		type(_addressLine1Id, value);
	}

	public void set_addressLine2(String value) {
		type(_addressLine2Id, value);
	}

	public void set_city(String value) {
		type(_cityId, value);
	}

	public void set_state(String value) {
		type(_stateId, value);
	}

	public void set_postalCode(String value) {
		type(_postalCodeId, value);
	}

	public void set_country(String value) {
		type(_countryId, value);
		getElementById(_countryId).sendKeys(Keys.TAB);
	}

	public void set_employeer(String value) {
		WebElement employeeDropDown = getElementByXPath(_employeerXPath);
		employeeDropDown.sendKeys("Fixter");
		employeeDropDown.sendKeys(Keys.ENTER);
	}

	public void set_creditLimit(String value) {
		type(_creditLimitId, value);
	}

	public void save() {
		getElementById(_btnSaveId).click();
	}

	public void clickGoBackToList()
	{
		clickLinkByText(goBackToList);
	}

	public void createDefaultCustomer() {
		set_customerName("Teste Sicredi");
		set_contactLastName("Teste");
		set_contactFirstName("Felipe Barbosa");
		set_phone("51 9999-9999");
		set_addressLine1("Av Assis Brasil, 3970");
		set_addressLine2("Torre D");
		set_city("Porto Alegre");
		set_state("RS");
		scrollDown();
		set_postalCode("91000-000");
		set_country("Brasil");
		set_employeer("Fixter");
		set_creditLimit("200");
	}

	public boolean verifySuccessfullMessageIs(String message) {
		waitForVisibilityById("report-success", 2);
		String confirmationMessage = getElementById("report-success").getText();
		return confirmationMessage.contains(message);
	}

}
