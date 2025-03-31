package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POM_class.CreatingNewLeadPage;
import POM_class.HomePage;
import POM_class.LeadsPage;
import genericUtility.BaseClass;

public class TC_002 extends BaseClass {
@Test(groups= {"Smoke"})
public void LE_002() throws EncryptedDocumentException, IOException {
	HomePage hp =new HomePage(driver);
	hp.clickOnLeadsMenu();
	LeadsPage lep=new LeadsPage(driver);
	lep.clickOnCreatingNewLeadIcon();
	String lName=eUtil.getDataFromExcelFile("Leads", 5, 1);
	String company=eUtil.getDataFromExcelFile("Leads", 5, 2);
	String leadSource=eUtil.getDataFromExcelFile("Leads", 5, 3);
	String noOfEmployees=eUtil.getDataFromExcelFile("Leads", 5, 4);
	String mobile=eUtil.getDataFromExcelFile("Leads", 5, 5);
	CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
	cnlp.createNewLead(lName,company,leadSource,noOfEmployees,mobile);
}

}

