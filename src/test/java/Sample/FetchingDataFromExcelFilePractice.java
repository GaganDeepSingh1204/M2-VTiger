package Sample;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.javaUtility;

public class FetchingDataFromExcelFilePractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {


//		ExcelUtility eUtil=new ExcelUtility();
//		String value = eUtil.getDateFromExcelFile("Animal", 0, 1);
//		String value1 = eUtil.getDateFromExcelFile("Bird", 2, 1);
//		System.out.println(value);
//        System.out.println(value1);
		javaUtility jUtil=new javaUtility();
		int value = jUtil.generateRandomNumber(1000);
		System.out.println(value);
		
		String dateStamp=jUtil.getCalendarDetails("dd-MM-YYYY");
		System.out.println(dateStamp);
		
		String dateTimeStamp=jUtil.getCalendarDetails("dd-MMM-YYYY hh-mm-ss");
		System.out.println(dateTimeStamp);
	}

}
