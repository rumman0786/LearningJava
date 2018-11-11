package module.export;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.apache.poi.common.usermodel.HyperlinkType.*;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBook {

    public static void openWorkBook(String filePath) {

        File file = new File(filePath);
        try (FileInputStream fIP = new FileInputStream(file)) {
            //Get the workbook instance for XLSX file
            XSSFWorkbook workbook = new XSSFWorkbook(fIP);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.isFile() && file.exists()) {
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

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFSheet sheet = workbook.createSheet(sheetName);
            XSSFRow row = null;
            int rowCount = 0;

            for (String key : workSheetContent.keySet()) {

                row = sheet.createRow(rowCount);
                int cellCount = 0;

                for (String cellContent : workSheetContent.get(key)) {
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

    public static void createStyleCell(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet(sheetName);

            int rowIndex = 1;
            short height = 800;

            XSSFRow row = spreadsheet.createRow(rowIndex);
            row.setHeight(height);

            XSSFCell cell = row.createCell(1);
            cell.setCellValue("test of merging");

            spreadsheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 1, 4));

            rowIndex = 5;
            row = spreadsheet.createRow(rowIndex);
            cell = row.createCell(0);
            row.setHeight(height);

            // Top Left alignment
            XSSFCellStyle style1 = workbook.createCellStyle();
            spreadsheet.setColumnWidth(0, 8000);
            style1.setAlignment(HorizontalAlignment.LEFT);
            style1.setVerticalAlignment(VerticalAlignment.TOP);
            cell.setCellValue("Top Left");
            cell.setCellStyle(style1);

            rowIndex = 6;
            row = spreadsheet.createRow(rowIndex);
            cell = row.createCell(1);
            row.setHeight(height);

            // Center Align Cell Contents
            XSSFCellStyle style2 = workbook.createCellStyle();
            style2.setAlignment(HorizontalAlignment.CENTER);
            style2.setVerticalAlignment(VerticalAlignment.CENTER);
            cell.setCellValue("Center Aligned");
            cell.setCellStyle(style2);

            row = spreadsheet.createRow(7);
            cell = row.createCell(2);
            row.setHeight(height);

            // Bottom Right alignment
            XSSFCellStyle style3 = workbook.createCellStyle();
            style3.setAlignment(HorizontalAlignment.RIGHT);
            style3.setVerticalAlignment(VerticalAlignment.BOTTOM);
            cell.setCellValue("Bottom Right");
            cell.setCellStyle(style3);

            rowIndex = 8;
            row = spreadsheet.createRow(rowIndex);
            cell = row.createCell(3);

            // Justified Alignment
            XSSFCellStyle style4 = workbook.createCellStyle();
            style4.setAlignment(HorizontalAlignment.JUSTIFY);
            style4.setVerticalAlignment(VerticalAlignment.JUSTIFY);
            cell.setCellValue("Contents are Justified in Alignment");
            cell.setCellStyle(style4);

            rowIndex = 10;
            row = spreadsheet.createRow(rowIndex);
            row.setHeight(height);
            cell = row.createCell(1);
            cell.setCellValue("BORDER");

            XSSFCellStyle style5 = workbook.createCellStyle();
            style5.setBorderBottom(BorderStyle.THICK);
            style5.setBottomBorderColor(IndexedColors.BLUE.getIndex());
            style5.setBorderLeft(BorderStyle.DOUBLE);
            style5.setLeftBorderColor(IndexedColors.GREEN.getIndex());
            style5.setBorderRight(BorderStyle.HAIR);
            style5.setRightBorderColor(IndexedColors.RED.getIndex());
            style5.setBorderTop(BorderStyle.SLANTED_DASH_DOT);
            style5.setTopBorderColor(IndexedColors.CORAL.getIndex());
            cell.setCellStyle(style5);

            rowIndex = 11;
            row = spreadsheet.createRow(rowIndex);
            cell = row.createCell(1);

            XSSFCellStyle style6 = workbook.createCellStyle();
            style6.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.LEMON_CHIFFON.getIndex2());
            style6.setFillPattern(FillPatternType.LESS_DOTS);
            style6.setAlignment(HorizontalAlignment.FILL);
            spreadsheet.setColumnWidth(1, 8000);
            cell.setCellValue("FILL BACKGROUNG/FILL PATTERN");
            cell.setCellStyle(style6);

            rowIndex = 12;
            row = spreadsheet.createRow(rowIndex);
            cell = row.createCell(1);

            XSSFCellStyle style7 = workbook.createCellStyle();
            style7.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex2());
            style7.setFillPattern(FillPatternType.LESS_DOTS);
            style7.setAlignment(HorizontalAlignment.FILL);
            cell.setCellValue("FILL FOREGROUND/FILL PATTERN");
            cell.setCellStyle(style7);

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }

    public static void createFontStyleCell(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);

            XSSFFont font = workbook.createFont();
            font.setFontName("IMPACT");
            font.setFontHeightInPoints((short) 14);
            font.setItalic(true);
            font.setColor(IndexedColors.BLACK.getIndex());

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);

            XSSFRow row = sheet.createRow(1);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue("Font Style");
            cell.setCellStyle(style);

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }

    public static void textDirection(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);
            XSSFRow row = sheet.createRow(1);

            makeTextRotatingCell(workbook, row, 0, 1, "0D angle");
            makeTextRotatingCell(workbook, row, 30, 3, "30D angle");
            makeTextRotatingCell(workbook, row, 60, 6, "60D angle");
            makeTextRotatingCell(workbook, row, 90, 9, "90D angle");
            makeTextRotatingCell(workbook, row, 120, 12, "120D angle");
            makeTextRotatingCell(workbook, row, 180, 15, "1800D angle");
            makeTextRotatingCell(workbook, row, 270, 18, "270D angle");
            makeTextRotatingCell(workbook, row, 360, 21, "360D angle");

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }

    private static void makeTextRotatingCell(XSSFWorkbook workbook,
                                             XSSFRow row,
                                             int rotationAngle,
                                             int cellIndex,
                                             String cellValue) {

        XSSFCellStyle style = workbook.createCellStyle();
        style.setRotation((short) rotationAngle);
        XSSFCell cell = row.createCell(cellIndex);
        cell.setCellValue(cellValue);
        cell.setCellStyle(style);
    }

    public static void formulaCell(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet(sheetName);
            XSSFRow row = spreadsheet.createRow(1);

            XSSFCell cell = row.createCell(0);
            cell.setCellValue("A = ");

            cell = row.createCell(1);
            cell.setCellValue(2);

            row = spreadsheet.createRow(2);
            cell = row.createCell(0);
            cell.setCellValue("B = ");
            cell = row.createCell(1);
            cell.setCellValue(4);

            createFormulaCell(spreadsheet, 3, "Total = ", "SUM(B2:B3)", "SUM(B2:B3)");
            createFormulaCell(spreadsheet, 4, "POWER = ", "POWER(B2,B3)", "POWER(B2,B3)");
            createFormulaCell(spreadsheet, 5, "MAX = ", "MAX(B2,B3)", "MAX(B2,B3)");
            createFormulaCell(spreadsheet, 6, "FACT = ", "FACT(B3)", "FACT(B3)");
            createFormulaCell(spreadsheet, 6, "SQRT = ", "SQRT(B3)", "SQRT(B3)");

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }

    private static void createFormulaCell(XSSFSheet sheet,
                                          int rowIndex,
                                          String... cellValue) {

        XSSFRow row = sheet.createRow(rowIndex);

        int cellIndex = 0;
        XSSFCell cell = row.createCell(cellIndex);
        cell.setCellValue(cellValue[0]);

        cellIndex += 1;
        cell = row.createCell(cellIndex);
        cell.setCellType(CellType.FORMULA);
        cell.setCellFormula(cellValue[1]);

        cellIndex += 1;
        cell = row.createCell(cellIndex);
        cell.setCellValue(cellValue[2]);
    }

    public static void createHyperLink(String filePath, String sheetName) {

        try (FileOutputStream out = new FileOutputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet(sheetName);
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont hlinkfont = workbook.createFont();
            hlinkfont.setUnderline(XSSFFont.U_SINGLE);
            hlinkfont.setColor(IndexedColors.BLUE.getIndex());
            cellStyle.setFont(hlinkfont);

            CreationHelper createHelper = workbook.getCreationHelper();

            createLinkCell(createHelper, spreadsheet, 0, 1,
                    "URL Link", "http://www.tutorialspoint.com/", URL, cellStyle);
            createLinkCell(createHelper, spreadsheet, 1, 1,
                    "File Link", "/home/rumman/testformulaCell.xlsx", FILE, cellStyle);
            createLinkCell(createHelper, spreadsheet, 2, 1,
                    "Email Link", "mailto:contact@tutorialspoint.com?subject=Hyperlink", EMAIL, cellStyle);

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} file was created successfully with sheet name {%s}", filePath, sheetName));
    }

    private static void createLinkCell(CreationHelper createHelper,
                                       XSSFSheet spreadsheet,
                                       int rowIndex,
                                       int cellIndex,
                                       String cellValue,
                                       String cellAddress,
                                       HyperlinkType hyperlinkType,
                                       XSSFCellStyle hlinkstyle) {

        XSSFCell cell = spreadsheet.createRow(rowIndex).createCell(cellIndex);
        cell.setCellValue(cellValue);
        cell.setCellStyle(hlinkstyle);

        XSSFHyperlink link = (XSSFHyperlink) createHelper.createHyperlink(hyperlinkType);
        link.setAddress(cellAddress);
        cell.setHyperlink(link);
    }
}
