package module.export;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBook {

    public static void OpenWorkBook(String filePath) {
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
}
