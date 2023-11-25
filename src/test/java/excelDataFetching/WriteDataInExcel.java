package excelDataFetching;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File file=new File("./src/test/resources/testData/testData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet newSheet = workbook.createSheet("Write Data");
		
		Object data[][]= {
				{"Emp Id","Emp Name","Emp Loc"},
				{1001,"Syed","Salem"},
				{1002,"Naren","CBE"},
				{1003,"Rakesh","Bangalore"}
		};
		
		int row=data.length;
		int col=data[0].length;
		
		for(int r=0;r<row;r++) {
			Row rows = newSheet.createRow(r);
			for(int c=0;c<col;c++) {
				Cell cellData = rows.createCell(c);
				Object value = data[r][c];
				if(value instanceof String)
					cellData.setCellValue((String)value);
				if(value instanceof Integer)
					cellData.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cellData.setCellValue((Boolean)value);
			}
		}
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		
		fos.close();
		System.out.println("Data written work is done");
	}

}
