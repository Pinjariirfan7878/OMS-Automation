package com.oms.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibClass {
	

	public String readPropertyData(String path,String key) throws Exception
	{
		FileInputStream fil=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fil);
		return prop.getProperty(key,"Incorrect Key");
	}
	
	
	public String readExcelData(String sheet,int row,int cell) throws Exception
	{
		FileInputStream fis=new FileInputStream(IAutoconstant.EXCEL_URL);
		Workbook wb =WorkbookFactory.create(fis);
		String value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}
	
//	public String readExcel_multipleData(String sheet,int start,int end) throws Exception 
//	{
//		String value;
//		for(int i=start;i<=end;i++)
//		{
//		FileInputStream fis=new FileInputStream(IAutoconstant.EXCEL_PATH);
//		Workbook wb =WorkbookFactory.create(fis);
//		value=wb.getSheet(sheet).getRow(i).getCell(i).toString();
//		return value;
//		}
//		
//	}
	
	public void WriteExcelData(String sheet,int row,int cell,String value) throws Exception, Exception
	{
		String path=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(path+"");
		Workbook wb =WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("");
		wb.write(fos);	
	}
	public String readExcelData(int row,int cell,String sheet) throws Exception
	{
		String path=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(path+IAutoconstant.EXCEL_URL);
		Workbook wb =WorkbookFactory.create(fis);
		String value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}
	
	public String readData_TestData(String sheet,int row,int cell) throws Exception
	{
		FileInputStream fis=new FileInputStream(IAutoconstant.EXCEL_TestData);
		Workbook wb =WorkbookFactory.create(fis);
		String value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return value;
	}

	
}
