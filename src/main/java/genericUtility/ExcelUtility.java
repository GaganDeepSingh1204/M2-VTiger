package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility{
	/**
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws IOException i
	 * @throws EncryptedDocumentException 
	 */
	public String getDataFromExcelFile(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(iPathUtility.excelPath);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowIndex);
		Cell c=r.getCell(cellIndex);
		DataFormatter df =new DataFormatter();
		String value =df.formatCellValue(c);
		return value;

	}


}