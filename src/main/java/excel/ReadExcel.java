package excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	 
	public static void main(String[] args) 
	{
	try 
	{
		File inputFile=new File("E://pp.xlsx");
	        // Get the workbook instance for XLSX file
		    XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

	        // Get first sheet from the workbook
	        XSSFSheet sheet = wb.getSheetAt(0);

	        Row row;
	        Cell cell;
	        

	        // Iterate through each rows from first sheet
	        Iterator<Row> rowIterator = sheet.iterator();

	        while (rowIterator.hasNext()) 
	        {
	                row = rowIterator.next();

	                // For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                
	                while (cellIterator.hasNext()) 
	                {
	                cell = cellIterator.next();

	                switch (cell.getCellType()) 
	                {

	                case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue()+"\t\t");
	                        break;

	                case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(Math.round(cell.getNumericCellValue())+"\t\t");
	                        break;

	                case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue()+"\t\t");
	                        break;

	                case Cell.CELL_TYPE_BLANK:
	                        System.out.print(" ");
	                        break;

	                default:
	                        System.out.println(cell);

	                }
	                }System.out.println();
	        }
	}
	catch (Exception e) 
	{
	        System.err.println("Exception :" + e.getMessage());
	}
	}

}
