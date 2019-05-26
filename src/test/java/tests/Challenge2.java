package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tests.Challenge1;
import pages.BasePage;
import pages.CustomerAddPage;
import pages.CustomerListPage;

public class Challenge2 {

	CustomerAddPage customerAddPage = new CustomerAddPage();
	CustomerListPage customerListPage = new CustomerListPage();

	@Before
	public void preCondition() 
	{
		new Challenge1().challenge1createCustomer();		
	}
	
	@After
	public void closeSession()
	{
		BasePage.closeBrowser();		
	}
	
	@Test
	public void challenge2createAndDeleteCustomer() {
		customerAddPage.clickGoBackToList();
		customerListPage.clickSearchButton();
		customerListPage.typeSearchButton("Teste");
		customerListPage.selectItem();
		customerListPage.deleteRow();
		assertTrue(customerListPage.verifyConfirmationDeleteMessageIs("Are you sure that you want to delete this 1 item?"));		
		customerListPage.deleteConfirmation();
		assertTrue(customerListPage.verifyDeleteMessageIs("Your data has been successfully deleted from the database."));
	}

}
