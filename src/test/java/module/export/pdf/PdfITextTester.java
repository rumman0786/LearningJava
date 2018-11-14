package module.export.pdf;

import org.junit.Test;

/**
 * @author rumman
 * @since 11/13/18
 */
public class PdfITextTester {

    @Test
    public void createPDFTest() {
        PdfITextGenerator.createParagraphPDF("/home/rumman/pdf/testCreate.pdf");
    }

    @Test
    public void createBlankPDFTest() {
        String paragraphContent = "Hello World! Hello People! Hello Sky! Hello Sun! Hello Moon! Hello Stars!";
        PdfITextGenerator.createParagraphPDFCustomParams("/home/rumman/pdf/testCustomPageDocument.pdf", paragraphContent,
                216f, 720f, 36f, 72f, 108f, 180f);
    }

    @Test
    public void createMaxPDFTest() {
        String paragraphContent = "Hello World! Hello People! Hello Sky! Hello Sun! Hello Moon! Hello Stars!";
        PdfITextGenerator.createMaxPDF("/home/rumman/pdf/testMaxPDFDocument.pdf", paragraphContent, 14400f, 14400f);
    }
}

