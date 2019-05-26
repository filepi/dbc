package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import pages.BasePage;
import pages.CustomerAddPage;
import pages.CustomerListPage;

public class Challenge1 {

	CustomerListPage customerListPage = new CustomerListPage();
	CustomerAddPage customerAddPage = new CustomerAddPage();
	
	@After
	public void closeSession()
	{
		BasePage.closeBrowser();		
	}
	
	@Test
	public void challenge1createCustomer() {
		customerListPage.changeComboboxToV4();
		customerListPage.clickAddCustomer();
		customerAddPage.createDefaultCustomer();
		customerAddPage.save();
		assertTrue(customerAddPage.verifySuccessfullMessageIs("Your data has been successfully stored into the database."));
	}
}
