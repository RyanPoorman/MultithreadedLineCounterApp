package com.poorman.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ResultToExcel {

	private static final String[] headers = { "File Name", "File Extension", "Line Count", "Parent Directory" };

	public static void outputToExcel(Vector<FileStatistics> data) {
		Workbook spreadsheet = new HSSFWorkbook();
		Sheet sheet = spreadsheet.createSheet("Line Count Results");

		createHeaders(sheet);

		populateRows(data, sheet);

		output(sheet, spreadsheet);
	}

	private static void output(Sheet sheet, Workbook spreadsheet) {
		try {
			FileOutputStream outputStream = new FileOutputStream("testtesttest.xls");
			spreadsheet.write(outputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void populateRows(Vector<FileStatistics> data, Sheet sheet) {
		Row row;
		int rownum = 1;
		for (int i = 0; i < data.size(); i++, rownum++) {

			if (data.elementAt(i) == null)
				continue;

			row = sheet.createRow(rownum);

			populateCells(data.elementAt(i), row);
		}
	}

	private static void createHeaders(Sheet sheet) {
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
		}
	}

	private static void populateCells(FileStatistics file, Row row) {

		Cell cellA = row.createCell(0);
		cellA.setCellValue(file.getFileName());

		Cell cellB = row.createCell(1);
		cellB.setCellValue(file.getFileExtension());

		Cell cellC = row.createCell(2);
		cellC.setCellValue(file.getLineCount());

		Cell cellD = row.createCell(3);
		cellD.setCellValue(file.getParentDirectory());
	}

}
