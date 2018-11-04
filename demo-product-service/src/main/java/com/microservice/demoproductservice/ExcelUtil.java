package com.microservice.demoproductservice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {

	public static InputStream buildExcelDocument(List<ProductEntity> users) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		// change the file name
		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"my-xls-file.xls\"");

		// create excel xls sheet
		HSSFSheet sheet = workbook.createSheet("User Detail");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		// style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		// font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Product Id");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Product Name");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Price");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Color");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Currency");
		header.getCell(4).setCellStyle(style);
		int rowCount = 1;

		for (ProductEntity user : users) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(user.getProductId());
			userRow.createCell(1).setCellValue(user.getProductName());
			userRow.createCell(2).setCellValue(user.getPrice().doubleValue());
			userRow.createCell(3).setCellValue(user.getColor());
			userRow.createCell(4).setCellValue(user.getPriceCurrency());
		}
		conditionalFormatting(sheet, "C", (users.size() + 1), ">100", IndexedColors.RED.index);
		conditionalFormatting(sheet, "C", (users.size() + 1), "<100", IndexedColors.GREEN.index);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		workbook.write(bos);
		byte[] barray = bos.toByteArray();
		InputStream inputStream = new ByteArrayInputStream(barray);
		// workbook.close();
		return inputStream;
	}

	private static void conditionalFormatting(HSSFSheet sheet, String column, int rowCount, String condition,
			short color) {
		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
		for (int i = 2; i <= rowCount; i++) {
			ConditionalFormattingRule rule1 = sheetCF
					.createConditionalFormattingRule("$" + column + "$" + i + condition);
			PatternFormatting fill1 = rule1.createPatternFormatting();
			fill1.setFillBackgroundColor(color);
			fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

			CellRangeAddress[] regions = { CellRangeAddress.valueOf(column + i + ":" + column + i) };

			sheetCF.addConditionalFormatting(regions, rule1);
		}
	}

}
