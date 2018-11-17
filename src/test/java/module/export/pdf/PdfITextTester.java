package module.export.pdf;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author rumman
 * @since 11/13/18
 */
public class PdfITextTester {

    @Test
    public void createPDFTest() {
        String filePath = "/home/rumman/pdf/testCreate.pdf";
        PdfITextGenerator.createParagraphPDF(filePath);

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createBlankPDFTest() {
        String paragraphContent = "Hello World! Hello People! Hello Sky! Hello Sun! Hello Moon! Hello Stars!";
        String filePath = "/home/rumman/pdf/testCustomPageDocument.pdf";

        PdfITextGenerator.createParagraphPDFCustomParams(filePath, paragraphContent,
                216f, 720f, 36f, 72f, 108f, 180f);

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createMaxPDFTest() {
        String paragraphContent = "Hello World! Hello People! Hello Sky! Hello Sun! Hello Moon! Hello Stars!";

        String filePath = "/home/rumman/pdf/testMaxPDFDocument.pdf";
        PdfITextGenerator.createMaxPDF(filePath, paragraphContent, 14400f, 14400f);

        Assert.assertTrue(new File(filePath).exists());
    }
}

