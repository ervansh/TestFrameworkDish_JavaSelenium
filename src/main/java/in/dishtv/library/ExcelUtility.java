package in.dishtv.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static FileInputStream fis;
	public static Workbook wb;
	public String workbookpath;
	public ExcelUtility(String workbookpath) {
		this.workbookpath=workbookpath;
		try {
			fis = new FileInputStream(workbookpath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public String getCellData(String sheetName, int rowNum, int colNum) {
		try {
			if (sheetName == null) {
				return "Enter Valid sheet name...";
			}
			Sheet sheet = wb.getSheet(sheetName);
			if (sheet == null)
				return "Sheet is empty...";
			Row row = sheet.getRow(rowNum);
			if (row == null)
				return "";
			Cell cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat datefarmate = new SimpleDateFormat("dd/MM/yyyy");
					return datefarmate.format(cell.getDateCellValue());
				} else
					return String.valueOf((int)cell.getNumericCellValue());
			} else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			      return ""; 
			  else 
				  return String.valueOf(cell.getBooleanCellValue());
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
			return "In sheet "+sheetName+" row "+rowNum+" and column "+colNum +" does not exist in the workbook.";
		}
	}

	public int getRowNum(String sheetName) {
		int row = 0;
		try {
			if (wb != null) {
				Sheet sheet = wb.getSheet(sheetName);
				if (sheet != null) {
					row = sheet.getLastRowNum();
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int getCellNum(String sheetName, int rowNum) {
		int cell = 0;
		try {
			if (wb != null) {
				Sheet sheet = wb.getSheet(sheetName);
				if (sheet != null) {
					Row row = sheet.getRow(rowNum);
					if (row != null) {
						cell = row.getLastCellNum();
					} else {
						throw new NullPointerException("Rows in workbook are not provided.");
					}
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
		return cell;
	}

	public void getRowData(String sheetName, int rowNum) {
		try {
			Sheet sheet = wb.getSheet(sheetName);
			sheet.getRow(rowNum);

		} catch (EncryptedDocumentException e) {
			e.getMessage();
		}
	}
}
