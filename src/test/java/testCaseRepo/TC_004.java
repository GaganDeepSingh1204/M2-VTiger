package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POM_class.ContactsPage;
import POM_class.CreatingNewContactPage;
import POM_class.CreatingNewLeadPage;
import POM_class.HomePage;
import genericUtility.BaseClass;

public class TC_004 extends BaseClass {
	
	@Test(groups= {"Regression"})
	public void CON_001() throws EncryptedDocumentException, IOException
	{
		HomePage hp =new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreatingNewContactIcon();
		String fName=eUtil.getDataFromExcelFile("Contacts", 2, 1);
		String lName=eUtil.getDataFromExcelFile("Contacts", 2, 2);
		String title=eUtil.getDataFromExcelFile("Contacts", 2, 3);
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.CreateNewContact(fName,lName,title);
	}
}
