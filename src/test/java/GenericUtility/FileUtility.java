package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This  class consists of generic methods releted files
 * @author Tushar
 */

public class FileUtility 
{
	
	/**
	 * 
	 * This method read value from properties file and return it 
	 * to caller
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	
	
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis =  new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}
	
	public String  readDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
       FileInputStream fis = new FileInputStream("./src/test/resources/Product.xlsx");
       Workbook wb = WorkbookFactory.create(fis);	
       String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
       return value;
		
	}

}
