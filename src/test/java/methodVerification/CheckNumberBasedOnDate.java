package methodVerification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckNumberBasedOnDate {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\venka\\Desktop\\testdata.xlsx"));
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getPhysicalNumberOfRows();
		LocalDate currentDate = LocalDate.now();
		int startRow = 1;
		int n=3;
		int daysSinceStart = (int) currentDate.toEpochDay() - startRow;
		System.out.println("Epochday : "+daysSinceStart);
		int rowNumber = ((startRow + daysSinceStart) % totalRows) - n;
		System.out.println("rownumber before process :"+rowNumber);
		if (totalRows >= 10) {
			if (rowNumber < 0)
				rowNumber = totalRows + rowNumber;
			else if (rowNumber == 0)
				rowNumber = Math.abs(totalRows - 10);

		} else {
			if (rowNumber < 0) 
				rowNumber = totalRows + rowNumber;
		}
		System.out.println("rownumber After process :"+rowNumber);
		
		String data = sheet.getRow(rowNumber).getCell(0).toString();
		
		System.out.println("Cell data based on row number :"+data);
	}
}
