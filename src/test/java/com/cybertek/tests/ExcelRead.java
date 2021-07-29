package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    /*
    in this method we will learn how to read from exel file step by step
     */
    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";

        //to be able to read from excel file, we need to load it into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > Sheet > row > cell

        //1-create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2- We need to get the specific sheet from currently opened workbook.
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3- Select row and  cell
        //print out steven's cell
        //Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        //print out "singer" from the sheet
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        //Return te count of used cells only
        //if there are cell not used, they will not be counted
        //It will not count empty rows or cells
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //Returns the number from the top cell to bottom cell
        //It does not care if there are empty cells or not
        //Starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();

        //Todo: 1- Create a logic to print out neena's name dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {

                System.out.println("Current cell = " + sheet.getRow(rowNum).getCell(0));
            }
        }

            //todo: Create a Logic to print out Steven King's JOB_ID
            //Check for a name Stevem's name if it's Steven --> Print out job_id

            for (int rowNu = 0; rowNu < usedRows; rowNu++) {
                if (sheet.getRow(rowNu).getCell(0).toString().equals("Steven")){
                    System.out.println("Steven's JOB_ID = " + sheet.getRow(rowNu).getCell(2));
                }
            }



    }
}
