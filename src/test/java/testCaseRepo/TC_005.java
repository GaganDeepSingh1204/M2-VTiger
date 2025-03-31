package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POM_class.ContactsPage;
import POM_class.CreatingNewContactPage;
import POM_class.CreatingNewLeadPage;
import POM_class.HomePage;
import genericUtility.BaseClass;

public class TC_005 extends BaseClass {
	@Test(groups= {"Sanity","Regression"})
	
	public void CON_002() throws EncryptedDocumentException, IOException
	{
		HomePage hp =new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreatingNewContactIcon();
		
		String lName=eUtil.getDataFromExcelFile("Contacts", 5, 1);
		String title=eUtil.getDataFromExcelFile("Contacts", 5, 2);
		String email=eUtil.getDataFromExcelFile("Contacts", 5, 3);
		String mobile=eUtil.getDataFromExcelFile("Contacts", 5, 4);
		CreatingNewContactPage cnlp=new CreatingNewContactPage(driver);

		cnlp.CreateNewContact(lName,title, email, mobile);

	}
}
