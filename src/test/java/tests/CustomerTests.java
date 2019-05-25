package tests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pageObject.BasePage;
import pageObject.CustomerAddPage;
import pageObject.CustomerListPage;

public class CustomerTests {
	
	@BeforeClass
	public static void init()
	{
		BasePage.initializeBrowser();
	}
	
	@Test
	public void createCustomer()
	{		
		CustomerListPage customerListPage = new CustomerListPage();
		CustomerAddPage customerAddPage = new CustomerAddPage();
		customerListPage.changeComboboxToV4();
		customerListPage.clickAddCustomer();
		customerAddPage.set_customerName("Teste Sicredi");
		customerAddPage.set_contactLastName("Teste");
		customerAddPage.set_contactFirstName("Felipe Barbosa");
		customerAddPage.set_phone("51 9999-9999");
		customerAddPage.set_addressLine1("Av Assis Brasil, 3970");
		customerAddPage.set_addressLine2("Torre D");
		customerAddPage.set_city("Porto Alegre");
		customerAddPage.set_state("RS");
		BasePage.scrollDown();
		customerAddPage.set_postalCode("91000-000");
		customerAddPage.set_country("Brasil");
		customerAddPage.set_employeer("Fixter");
		customerAddPage.set_creditLimit("200");
		customerAddPage.save();
		BasePage.waitForVisibility("report-success", 2);
		String confirmationMessage = customerAddPage.getElementById("report-success").getText();
		assertTrue(confirmationMessage.contains("Your data has been successfully stored into the database."));
	}
	
	@AfterClass
	public static void close() 
	{
		BasePage.closeBrowser();
	}
}
