package excelDataFetching;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFullRow {
	static Sheet sheet;
	static String testcasesHeader = "TestCaseID";
	DataFormatter dm=new DataFormatter();

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String excelPath = ("C:\\Users\\venka\\Downloads\\Testdata.xlsx");//file path
		String Sheet = "Create Profile";//sheet name
		String expectedTestCaseId = "CR004"; //testcase id
		
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheet(Sheet);
		FetchDataFullRow l = new FetchDataFullRow();
		LinkedHashMap<String, String> data = l.getdataFromExcel(expectedTestCaseId);
		System.out.println(data);
	}

	public LinkedHashMap<String, String> getdataFromExcel(String testID)
			throws EncryptedDocumentException, IOException {
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		System.out.println(sheet.getPhysicalNumberOfRows());
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i <= lastRow; i++) {

			try {
				String data = sheet.getRow(i).getCell(0).toString();
				if (data.equals(testID)) {
					for (int j = i; j >= 0; j--) {
						String excelData = sheet.getRow(j).getCell(0).getStringCellValue();
						
						if (testcasesHeader.equalsIgnoreCase(excelData)) {
							int cellCount = sheet.getRow(i).getLastCellNum();

							for (int k = 0; k < cellCount; k++) {
								String value1 = dm.formatCellValue(sheet.getRow(i).getCell(k));
								String key1 = dm.formatCellValue(sheet.getRow(j).getCell(k));
								map.put(key1, value1);
							}
							break;
						}
					}
				}

			} catch (Exception e) {
			}

		}
		return map;
	}
}
