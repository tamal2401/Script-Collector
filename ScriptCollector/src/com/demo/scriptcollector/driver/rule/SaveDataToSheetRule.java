package com.demo.scriptcollector.driver.rule;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.strategy.StrategyRule;
import com.demo.scriptcollector.utils.EnumUtils;

/**
 * @author TAPU
 *
 */
public class SaveDataToSheetRule implements StrategyRule{

	@Override
	public void logic(DomainModel domainModel) {

		String sHeader = domainModel.getStoryHeader();
		String sNum = domainModel.getStoryNumber();
		String body = domainModel.getBody();
		String sPoint = domainModel.getStoryPoint();
		String desc = domainModel.getDescription();
		String assignee = domainModel.getAssignee();

		try {
			String filepath = EnumUtils.excelpath;
			File file = new File(filepath);
			FileInputStream input = new FileInputStream(file);
			BufferedInputStream buffer = new BufferedInputStream(input);
			Workbook workbook = WorkbookFactory.create(buffer);
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			if(null!=sheet){
				for(int rowIndex=1;rowIndex<=rowCount+1;rowIndex++) {
					Row row = sheet.getRow(rowIndex);
					if(null!=row) {
						Cell cell = row.getCell(0);
						DataFormatter df = new DataFormatter();
						if(sNum.equalsIgnoreCase(df.formatCellValue(cell))) {
							setDataRow(sNum,sHeader,body,sPoint,desc,assignee,input,row);
							break;
						}else {
							Row newRow = sheet.createRow(rowIndex);
							setDataRow(sNum,sHeader,body,sPoint,desc,assignee,input,row);
							break;
						}
					}
				}
			}
			FileOutputStream op = new FileOutputStream(file);
			workbook.write(op);
			workbook.close();
			op.close();
		}catch(Exception e) {
			System.out.println("Error while saving the data in sheet.");
		}
	}

	private void setDataRow(String sNum, String sHeader, String body, String sPoint, String desc, String assignee,
			FileInputStream input, Row row) throws IOException {

		row.createCell(0).setCellValue(sNum);
		row.createCell(1).setCellValue(sHeader);
		row.createCell(2).setCellValue(body);
		row.createCell(3).setCellValue(sPoint);
		row.createCell(4).setCellValue(desc);
		row.createCell(5).setCellValue(assignee);
		input.close();
	}

}
