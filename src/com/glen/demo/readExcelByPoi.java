package com.glen.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

/**
 * 读取EXCEL内容
 * 
 * @author lxr
 *
 */
public class readExcelByPoi {

	private static final String EXTENSION_XLS = "xls";
	private static final String EXTENSION_XLSX = "xlsx";

	private static Workbook workbook = null;

	public readExcelByPoi(String filepath) throws FileNotFoundException, FileFormatException {

		// 检查
		preReadCheck(filepath);
		// 获取workbook对象
		InputStream in = new FileInputStream(filepath);
		try {
			workbook = getWorkbook(in, filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (workbook != null) {
				try {
					in.close();
					
					FileOutputStream out=new FileOutputStream(filepath);
			        workbook.write(out);
			        out.flush();
			        out.close();
			        workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 判断EXCEL版本
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbook(InputStream in, String filename) throws IOException {
		Workbook wb = null;
		if (filename.endsWith(EXTENSION_XLS)) {
			wb = new HSSFWorkbook(in);// Excel 2003
		} else if (filename.endsWith(EXTENSION_XLSX)) {
			wb = new XSSFWorkbook(in);// Excel 2007
		}
		return wb;
	}

	/**
	 * 文件校验是否是excel
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	private void preReadCheck(String filePath) throws FileNotFoundException, FileFormatException {
		// 常规检查
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("传入的文件不存在：" + filePath);
		}

		if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
			throw new FileFormatException("传入的文件不是excel");
		}
	}

	/**
	 * 取单元格的值
	 * 
	 * @param cell
	 *            单元格对象
	 * @param treatAsStr
	 *            为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
	 * @return
	 */
	private String getCellValue(Cell cell, boolean treatAsStr) {
		if (cell == null) {
			return "";
		}

		if (treatAsStr) {
			// 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
			// 加上下面这句，临时把它当做文本来读取
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

		String cellValue = null;
		int cellType = cell.getCellType();
		switch (cellType) {
		case Cell.CELL_TYPE_STRING: // 文本
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC: // 数字、日期
			if (DateUtil.isCellDateFormatted(cell)) {
				cellValue = fmt.format(cell.getDateCellValue()); // 日期型
			} else {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN: // 布尔型
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK: // 空白
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_ERROR: // 错误
			cellValue = "错误";
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = "错误";
			break;
		default:
			cellValue = "错误";
		}
		return cellValue;
	}

	/**
	 * 读取EXCEL
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	/*
	 * public void readExcel(String filePath) throws FileNotFoundException,
	 * FileFormatException { // 检查 preReadCheck(filePath); // 获取workbook对象
	 * Workbook workbook = null; InputStream is = new FileInputStream(filePath);
	 * 
	 * try { workbook = getWorkbook(is, filePath); // workbook =
	 * WorkbookFactory.create(is);
	 * 
	 * // 读文件 一个sheet一个sheet地读取 for (int numSheet = 0; numSheet <
	 * workbook.getNumberOfSheets(); numSheet++) { Sheet sheet =
	 * workbook.getSheetAt(numSheet); if (sheet == null) { continue; }
	 * 
	 * int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量 int rowCount =
	 * sheet.getPhysicalNumberOfRows(); // 获取总行数
	 * 
	 * int firstRowIndex = sheet.getFirstRowNum(); int lastRowIndex =
	 * sheet.getLastRowNum();
	 * 
	 * if (firstRowIndex != lastRowIndex && lastRowIndex != 0) {
	 * 
	 * System.out.println("=======================" + sheet.getSheetName() +
	 * "=========================");
	 * 
	 * // 读取数据行 for (int rowIndex = 0; rowIndex <= lastRowIndex; rowIndex++) {
	 * Row currentRow = sheet.getRow(rowIndex);// 当前行 int firstColumnIndex =
	 * currentRow.getFirstCellNum(); // 首列 int lastColumnIndex =
	 * currentRow.getLastCellNum();// 最后一列 for (int columnIndex =
	 * firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) { Cell
	 * currentCell = currentRow.getCell(columnIndex);// 当前单元格 String
	 * currentCellValue = this.getCellValue(currentCell, true);// 当前单元格的值
	 * System.out.print(currentCellValue + "\t"); } System.out.println(""); }
	 * 
	 * }
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } finally { if (workbook
	 * != null) { try { workbook.close(); } catch (IOException e) {
	 * e.printStackTrace(); } } } }
	 */

	/**
	 * 读取excel表格中某单元格的内容的文本
	 * 
	 * @param numSheet
	 *            Sheet号（从0开始）
	 * @param rowIndex
	 *            行号（从0开始）
	 * @param columnIndex
	 *            列号（从0开始）
	 * @return 单元格的内容的文本
	 */
	public String readExcel(int numSheet, int rowIndex, int columnIndex) {
		Sheet sheet = readExcelByPoi.workbook.getSheetAt(numSheet);
		Cell currentCell = sheet.getRow(rowIndex).getCell(columnIndex);
		// return currentCell.getStringCellValue();
		return this.getCellValue(currentCell, true);
	}

	public void setWtihdrawExcel() {
		Date date = new Date();
		DateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String string1 = dateFormat1.format(date);
		String BatchNo = "C" + string1;
//		System.out.println(BatchNo);
		System.out.println("修改前："+readExcel(0, 1, 1));
		setCell(0, 1, 1, BatchNo);
		
		System.out.println("修改后："+readExcel(0, 1, 1));

		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String string2 = dateFormat2.format(date);
//		System.out.println(string2);  
		System.out.println("修改前："+readExcel(0, 1, 4));
		setCell(0, 1, 4, string2);
		System.out.println("修改后："+readExcel(0, 1, 4));

	}

	public void setCell(int numSheet, int rowIndex, int columnIndex, String value) {
		Sheet sheet = readExcelByPoi.workbook.getSheetAt(numSheet);

		Cell cell = sheet.getRow(rowIndex).getCell(columnIndex);

		cell.setCellValue(value);

	}

	/**
	 * 测试
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		readExcelByPoi e3 = new readExcelByPoi("E:\\eclipse\\test\\personinfo.xlsx");
		// System.out.println(e3.readExcel(0,0,0));

		String filename="";
		File file = new File("C:\\Users\\62605\\Downloads");
		File[] filelist = file.listFiles();
		for (File f : filelist) {
			if (f.isFile() && f.getName().startsWith("退款执行结果导入模板")) {
				System.out.println(filename=f.getName());
				
			}
		}
		
		String filepath="C:\\Users\\62605\\Downloads\\"+filename;
		System.out.println(filepath);
		
		readExcelByPoi test=new readExcelByPoi(filepath);
		test.setWtihdrawExcel();
		
		
		
	}

}