package inpuFromXL;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class XL {
	public static void main(String[] args) throws IOException {
		FileInputStream fls=new FileInputStream("C:/Users/FINCART/Desktop//KYC TC.xlsx");
		try (Workbook workbook = new XSSFWorkbook(fls)) {
			Sheet sheet=workbook.getSheetAt(0);
			for(Row row:sheet) {
				Cell cl=row.getCell(3);
				System.out.println(cl);
			
			}
		}
		
	}

}
