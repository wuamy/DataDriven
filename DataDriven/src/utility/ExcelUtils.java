package utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	//this method is to set file path and to open the excel file
	//pass excel path and sheetname as arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	
	//this method is to read the test data from the excel cell
	//in this we are passing param as row num and column num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}

}
