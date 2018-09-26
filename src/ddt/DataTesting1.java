package ddt;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataTesting1 {

	public static void main(String[] args) throws Exception {
		
		// Using file class to set the location of the sheet
		
		File obj1 = new File("C:\\Users\\de543804\\Desktop\\NewFile1.xls");
		System.out.println("Excel has been loaded successfully");
		
		// Using the workbook pre-defined class to load the excel file 
        
		Workbook wb = Workbook.getWorkbook(obj1);
		System.out.println("Workbook has been loaded successfully");
		
		// Using wb object it has to read the sheet 
		
		String value1 = wb.getSheet("Sheet1").getCell(2,0).getContents();
		System.out.println(value1);
		
		// To get the no. of Rows & Columns
		
		int valueCoulumn = wb.getSheet("Sheet1").getColumns();
		int valueRows = wb.getSheet("Sheet1").getRows();
		
		System.out.println("No. of Columns :" + valueCoulumn);
		System.out.println("No. of Rows :" + valueRows);
			
	}

}