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
	public void finalizeTest()
	{
		new BasePage().closeBrowser();		
	}
	
	@Test
	public void createCustomer() {
		customerListPage.setBootstrapVersionToV4();
		customerListPage.clickAddCustomer();
		customerAddPage.createDefaultCustomer();
		customerAddPage.clickSave();
		assertTrue(customerAddPage.verifySuccessfullMessageIs("Your data has been successfully stored into the database."));
	}
}
