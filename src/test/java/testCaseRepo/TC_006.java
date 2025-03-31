package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POM_class.ContactsPage;
import POM_class.CreatingNewContactPage;
import POM_class.HomePage;
import genericUtility.BaseClass;

public class TC_006 extends BaseClass{

	@Test(groups= {"Smoke","Sanity"})
	public void CON_003() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.clickOnContactsMenu(); 

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreatingNewContactIcon();

		String lName = eUtil.getDataFromExcelFile("Contacts", 8, 1);
		String email = eUtil.getDataFromExcelFile("Contacts", 8, 2);
		String mobile = eUtil.getDataFromExcelFile("Contacts", 8, 3);
		String mailingCity = eUtil.getDataFromExcelFile("Contacts", 8, 4);
		String mailingState = eUtil.getDataFromExcelFile("Contacts", 8, 5);
		String mailingCountry = eUtil.getDataFromExcelFile("Contacts", 8, 6);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.CreateNewContact(lName, email, mobile, mailingCity, mailingState, mailingCountry);
	}
}

