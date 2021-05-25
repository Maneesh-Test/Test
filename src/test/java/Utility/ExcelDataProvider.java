package Utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {

     public XSSFWorkbook wb;

     public ExcelDataProvider(){

         File src = new File("C:/Users/admin/IdeaProjects/Test/src/test/java/TestData/TestData.xlsx");

         try {
             FileInputStream fis = new FileInputStream(src);
             wb = new XSSFWorkbook(fis);
         } catch (IOException e) {
             Reporter.log("Unable to Open the Excel file",true);
         }

     }

    public String getStringData(int sheetIndex,int rowNum,int cellNum){

        return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(cellNum).getStringCellValue();
    }

    public String getStringData(String sheetName,int rowNum,int cellNum){

         return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
     }

     public double getNumericData(String sheetName, int rowNum, int cellNum){
        return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
     }

}
