package module.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBook {

    public static void openWorkBook(String filePath) {

        File file = new File(filePath);
        try(FileInputStream fIP = new FileInputStream(file)) {
            //Get the workbook instance for XLSX file
            XSSFWorkbook workbook = new XSSFWorkbook(fIP);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(file.isFile() && file.exists()) {
            System.out.println("openworkbook.xlsx file open successfully.");
        } else {
            System.out.println("Error to open openworkbook.xlsx file.");
        }
    }

    public static void createWorkBook(String filePath) {
        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully", filePath));
    }

    public static void createWorkBookWithSheet(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            workbook.createSheet(sheetName);
            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully with sheet {%s}", filePath, sheetName));
    }

    public static void createWorkBookWithSheetContainingRowCell(String filePath,
                                                                String sheetName,
                                                                Map<String, List<String>> workSheetContent) {

        XSSFWorkbook workbook = new XSSFWorkbook();

        try(FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFSheet sheet = workbook.createSheet(sheetName);
            XSSFRow row = null;
            int rowCount = 0;

            for (String key: workSheetContent.keySet()) {

                row = sheet.createRow(rowCount);
                int cellCount = 0;

                for (String cellContent: workSheetContent.get(key)) {
                    Cell cell = row.createCell(cellCount);
                    cell.setCellValue(cellContent);

                    cellCount++;
                }

                rowCount++;
            }

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully with sheet {%s}", filePath, sheetName));
    }

    public static void readWorkBookWithSheetContainingRowCell(String filePath, String sheetName) {

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheet(sheetName);

            for (Row row : spreadsheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " \t\t ");
                            break;

                        case STRING:
                            System.out.print(cell.getStringCellValue() + " \t\t ");
                            break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was read successfully with sheet name {%s}", filePath, sheetName));
    }

    public static void createCell(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet spreadsheet = workbook.createSheet(sheetName);
            int rowCount = 0;
            XSSFRow row = spreadsheet.createRow(rowCount++);

            XSSFCell xssfHeaderCell1 = row.createCell(0);
            xssfHeaderCell1.setCellType(CellType.STRING);
            xssfHeaderCell1.setCellValue("Type of Cell");

            XSSFCell xssfHeaderCell2 = row.createCell(1);
            xssfHeaderCell2.setCellType(CellType.STRING);
            xssfHeaderCell2.setCellValue("Cell value");

            row = spreadsheet.createRow(rowCount++);
            XSSFCell xssfRow1Cell0 = row.createCell(0);
            xssfRow1Cell0.setCellType(CellType.STRING);
            xssfRow1Cell0.setCellValue("BLANK");

            XSSFCell xssfRow1Cell2 = row.createCell(1);
            xssfRow1Cell2.setCellType(CellType.BLANK);

            row = spreadsheet.createRow(rowCount++);
            XSSFCell xssfRow2Cell0 = row.createCell(0);
            xssfRow2Cell0.setCellType(CellType.STRING);
            xssfRow2Cell0.setCellValue("NUMERIC");

            XSSFCell xssfRow2Cell2 = row.createCell(1);
            xssfRow2Cell2.setCellType(CellType.NUMERIC);
            xssfRow2Cell2.setCellValue(1000);

            row = spreadsheet.createRow(rowCount++);
            XSSFCell xssfRow3Cell0 = row.createCell(0);
            xssfRow3Cell0.setCellType(CellType.STRING);
            xssfRow3Cell0.setCellValue("FORMULA");

            XSSFCell xssfRow3Cell2 = row.createCell(1);
            xssfRow3Cell2.setCellType(CellType.FORMULA);
            xssfRow3Cell2.setCellValue("x < x + y; [y>=1]");

            row = spreadsheet.createRow(rowCount++);
            XSSFCell xssfRow4Cell0 = row.createCell(0);
            xssfRow4Cell0.setCellType(CellType.STRING);
            xssfRow4Cell0.setCellValue("BOOLEAN");

            XSSFCell xssfRow4Cell2 = row.createCell(1);
            xssfRow4Cell2.setCellType(CellType.BOOLEAN);
            xssfRow4Cell2.setCellValue(true);

            row = spreadsheet.createRow(rowCount++);
            XSSFCell xssfRow5Cell0 = row.createCell(0);
            xssfRow5Cell0.setCellType(CellType.STRING);
            xssfRow5Cell0.setCellValue("ERROR");

            XSSFCell xssfRow5Cell2 = row.createCell(1);
            xssfRow5Cell2.setCellType(CellType.ERROR);
            xssfRow5Cell2.setCellValue("#$%^&*((((%%%");

            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }
}
