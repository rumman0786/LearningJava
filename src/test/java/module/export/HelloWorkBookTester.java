package module.export;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBookTester {

    private static final Map<String, List<String>> WORK_SHEET_CONTENT = new TreeMap<>();

    static {
        WORK_SHEET_CONTENT.put("One", Arrays.asList("Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text"));
        WORK_SHEET_CONTENT.put("Two", Arrays.asList("Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text"));
        WORK_SHEET_CONTENT.put("Three", Arrays.asList("Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text"));
        WORK_SHEET_CONTENT.put("Four", Arrays.asList("Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text"));
        WORK_SHEET_CONTENT.put("Five", Arrays.asList("Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text", "Dummy Text"));
    }

    @Test
    public void createExcelTest(){
        HelloWorkBook.createWorkBook("/home/rumman/testCreate.xlsx");
    }

    @Test(timeout = 5000L)
    public void openExcelTest(){
        HelloWorkBook.openWorkBook("/home/rumman/testCreate.xlsx");
    }

    @Test
    public void createExcelWithSheetNameTest(){
        HelloWorkBook.createWorkBookWithSheet("/home/rumman/testCreate2.xlsx", "Test Sheet Name");
    }

    @Test
    public void createExcelWithRowCellTest(){
        HelloWorkBook.createWorkBookWithSheetContainingRowCell(
                "/home/rumman/testCreate3.xlsx", "Test Sheet Name", WORK_SHEET_CONTENT);
    }

    @Test(timeout = 5000L)
    public void readExcelWithSheetNameTest(){
        HelloWorkBook.readWorkBookWithSheetContainingRowCell("/home/rumman/testCreate3.xlsx", "Test Sheet Name");
    }

    @Test
    public void createCellTest(){
        HelloWorkBook.createCell("/home/rumman/testCreateCellTypes.xlsx", "Cell Types");
    }

    @Test
    public void createStyleCellTest(){
        HelloWorkBook.createStyleCell("/home/rumman/testCreateCellStyles.xlsx", "Cell Styles");
    }

    @Test
    public void createFontStyleCellTest(){
        HelloWorkBook.createFontStyleCell("/home/rumman/testCreateFontCellStyles.xlsx", "Cell With Font Styles");
    }

    @Test
    public void textDirectionTest(){
        HelloWorkBook.textDirection("/home/rumman/testTextDirection.xlsx", "Cell Text Direction Styles");
    }

    @Test
    public void formulaCellTest(){
        HelloWorkBook.formulaCell("/home/rumman/testformulaCell.xlsx", "Formula Cell");
    }

    @Test
    public void createHyperLinkTest(){
        HelloWorkBook.createHyperLink("/home/rumman/testCreateHyperLink.xlsx", "HyperLink Cell");
    }
}
