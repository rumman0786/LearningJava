package module.export;

import org.junit.Test;

/**
 * @author rumman
 * @since 10/22/18
 */
public class HelloWorkBookTester {

    @Test
    public void createExcelTest(){
        HelloWorkBook.OpenWorkBook("/home/rumman/test.xlsx");
    }
}
