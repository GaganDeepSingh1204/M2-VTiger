package Sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class WritingDataToExcelFilePratice {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\gd377\\Downloads\\Animal.xlsx");
	Workbook wb =WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Animal");
	Row r = sh.getRow(3);
	Cell c=r.getCell(3);
	c.setCellValue("hello");
	Row row = sh.createRow(3);
	Cell c1 =row.createCell(3);
	c1.setCellValue("lotus");
	FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\gd377\\\\Downloads\\\\Animal.xlsx");
	wb.write(fos);
	ExcelUtility eUtil = new ExcelUtility();
//	E.Util.writeDataToExcelFile
	
}
}
