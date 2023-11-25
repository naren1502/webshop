package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData implements FrameworkConstants {

	public static String fromProperty(String key) {
		FileInputStream fis = null;
		Properties properties = new Properties();
		;
		try {
			fis = new FileInputStream(new File(PROPERTIES_PATH));
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key).toString();
	}

	public static String readExcelData(String sheetName, int row, int column) {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = null;
		Workbook workbook = null;

		try {
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public static String[][] readDataExcel(String sheetName) {
		File file = new File(EXCEL_PATH);
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows() - 1;
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] info = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				info[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return info;
	}

}
