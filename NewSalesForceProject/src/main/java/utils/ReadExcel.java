package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("Data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int rowCount = ws.getLastRowNum();
		short columnCount = ws.getRow(0).getLastCellNum();
		String [] [] data=new String [rowCount] [columnCount];
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row = ws.getRow(i);
	    for (int j = 0; j < columnCount; j++) {
		    XSSFCell cell = row.getCell(j);
		    data[i-1][j] = cell.getStringCellValue();
		    System.out.println(cell.getStringCellValue());
		    
	    }
			}
		wb.close();
		return data;

	}
 
}


//for (int i = 1; i <=rowCount; i++) {  error is in this line 
// i<=rowCount  --> it gets the the totale row lwngth