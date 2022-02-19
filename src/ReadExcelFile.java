/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package com.Excel;

import java.io.*;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author JAFOJIAL
 */

public class ReadExcelFile {
    
    public ReadExcelFile(){
        
    }
    
    public DefaultTableModel Read(String chemin) throws IOException, InvalidFormatException{
        
        DefaultTableModel table = new DefaultTableModel(100000,3);
            
        
        try {
            try (FileInputStream file = new FileInputStream(new File(chemin))) {
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                rowIterator.next();
                int i = 0;
                while(rowIterator.hasNext())
                {
                    Row row = rowIterator.next();
                    int col = row.getLastCellNum();
                    //For each row, iterate through each columns
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int j = 0;
                    while(cellIterator.hasNext())
                    {
                        Cell cell = cellIterator.next();
                        //table.setValueAt(, i, j);
                        
                        if(j>2){
                            System.out.println("File format incorrect");
                        }else{
                            switch(cell.getCellType()) 
                            {
                                case Cell.CELL_TYPE_BOOLEAN:
                                    table.setValueAt(cell.getBooleanCellValue(), i, j);
                                    //table.setValueAt(cell.getBooleanCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                    System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    table.setValueAt(cell.getNumericCellValue(), i, j);
                                    //table.setValueAt(cell.getNumericCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                    System.out.println("numeric===>>>"+cell.getNumericCellValue() + "\t");
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    table.setValueAt(cell.getStringCellValue(), i, j);
                                    //table.setValueAt(cell.getStringCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                    System.out.println("String===>>>"+cell.getStringCellValue() + "\t");
                                    break;
                            }
                        }
                        
                        j++;
                    }
                    System.out.println("");
                    i++;
                }
            }
        } catch (IOException e) {
        }
        return table;
    }
    
    /*
     * 
     //Create Workbook from Existing File
        InputStream fileIn = null;
        try {
            fileIn = new FileInputStream(chemin);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Workbook wb = WorkbookFactory.create(fileIn);
        //Sheet sheet = wb.getSheetAt(tabNumber);
        XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(0);
 
        //Define Data & Row Array and adjust from Zero Base Numer
        table = new DefaultTableModel();
        Row[] row = new Row[sheet.getLastRowNum()];
        Cell[][] cell = new Cell[row.length][];
 
        //Transfer Cell Data to Local Variable
        for(int i = 0; i < row.length; i++)
        {
            row[i] = sheet.getRow(i);
 
            //Note that cell number is not Zero Based
            cell[i] = new Cell[row[i].getLastCellNum()];
            //data[i] = new double[row[i].getLastCellNum()];
 
            for(int j = 0; j < cell[i].length; j++)
            {
                cell[i][j] = row[i].getCell(j);
                //data[i][j] = cell[i][j].getNumericCellValue();
                switch(cell[i][j].getCellType()) 
                        {
                            case Cell.CELL_TYPE_BOOLEAN:
                                table.setValueAt(cell[i][j].getBooleanCellValue(), i, j);
                                //table.setValueAt(cell.getBooleanCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                System.out.println("boolean===>>>"+cell[i][j].getBooleanCellValue() + "\t");
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                table.setValueAt(cell[i][j].getNumericCellValue(), i, j);
                                //table.setValueAt(cell.getNumericCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                System.out.println("numeric===>>>"+cell[i][j].getNumericCellValue() + "\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                table.setValueAt(cell[i][j].getStringCellValue(), i, j);
                                //table.setValueAt(cell.getStringCellValue(), Integer.parseInt(row.toString()), Integer.parseInt(cell.toString()));
                                System.out.println("String===>>>"+cell[i][j].getStringCellValue() + "\t");
                                break;
                        }
            }
 
        }
 
        fileIn.close();
        
     * 
     */
    
    
}

