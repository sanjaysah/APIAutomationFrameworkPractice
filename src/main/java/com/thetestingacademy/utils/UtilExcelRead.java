package com.thetestingacademy.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class UtilExcelRead {
    static Workbook book;
    static Sheet sheet;
    public static final String SHEET_NAME_PATH = System.getProperty("user.dir")+"/src/test/java/org/DataProviders/TestData.xlsx";
    @DataProvider
    public static Object[][] getTestData(String sheetname){
        //System.out.println(System.getProperty("user.dir"));
        FileInputStream file;
        try{
            file = new FileInputStream(SHEET_NAME_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetname);

        }catch(Exception e){
            e.getStackTrace();
        }

        int row = sheet.getLastRowNum();
        int col = sheet.getRow(0).getLastCellNum();
        System.out.println("Row: "+row+" - Col: "+col);
        Object[][] data = new Object[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getData(){
        return getTestData("TestData");
    }
}
