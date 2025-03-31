package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import POM_class.CreatingNewLeadPage;
import POM_class.HomePage;
import POM_class.LeadsPage;
import genericUtility.BaseClass;

public class TC_003 extends BaseClass{
	@Test(groups= {"Sanity"})
	public void LE_003() throws EncryptedDocumentException, IOException {
		HomePage hp =new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep=new LeadsPage(driver);
		lep.clickOnCreatingNewLeadIcon();
		String lName=eUtil.getDataFromExcelFile("Leads", 8, 1);
		String company=eUtil.getDataFromExcelFile("Leads", 8, 2);
		String noOfEmployees=eUtil.getDataFromExcelFile("Leads", 8, 3);
		String mobile=eUtil.getDataFromExcelFile("Leads", 8, 4);
		String email=eUtil.getDataFromExcelFile("Leads", 8, 5);
		String city=eUtil.getDataFromExcelFile("Leads", 8, 6);
		String country=eUtil.getDataFromExcelFile("Leads", 8, 7);
		String state=eUtil.getDataFromExcelFile("Leads", 8, 8);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName,company,noOfEmployees,mobile,email,city,country, state);
	}
}
