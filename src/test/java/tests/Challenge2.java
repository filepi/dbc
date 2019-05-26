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
		new Challenge1().createCustomer();		
	}
	
	@After
	public void finalizeTest()
	{
		new BasePage().closeBrowser();		
	}
	
	@Test
	public void createAndDeleteCustomer() {
		customerAddPage.clickGoBackToList();
		customerListPage.clickSearchButton();
		customerListPage.typeSearchButton("Teste");
		customerListPage.selectItem();
		customerListPage.clickDeleteButton();
		assertTrue(customerListPage.verifyConfirmationDeleteMessageIs("Are you sure that you want to delete this 1 item?"));		
		customerListPage.confirmDelete();
		assertTrue(customerListPage.verifyDeleteMessageIs("Your data has been successfully deleted from the database."));
	}

}
