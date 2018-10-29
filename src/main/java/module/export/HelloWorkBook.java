package module.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBook {

    public static void openWorkBook(String filePath) {
        File file = new File(filePath);
        FileInputStream fIP = null;
        try {
            fIP = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Get the workbook instance for XLSX file
        try {
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
        XSSFWorkbook workbook = new XSSFWorkbook();

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully", filePath));
    }

    public static void createWorkBookWithSheet(String filePath, String sheetName) {
        XSSFWorkbook workbook = new XSSFWorkbook();

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath));

            workbook.createSheet(sheetName);

            workbook.write(out);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully with sheet {%s}", filePath, sheetName));
    }

    public static void createWorkBookWithSheetContainingRowCell(String filePath,
                                                                String sheetName,
                                                                Map<String, List<String>> workSheetContent) {

        XSSFWorkbook workbook = new XSSFWorkbook();

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath));

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

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} written successfully with sheet {%s}", filePath, sheetName));
    }
}
