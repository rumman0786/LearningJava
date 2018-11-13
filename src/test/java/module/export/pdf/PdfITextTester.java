package module.export.pdf;

import org.junit.Test;

/**
 * @author rumman
 * @since 11/13/18
 */
public class PdfITextTester {

    @Test
    public void createBlankPDFTest() {
        PdfITextGenerator.createParagraphPDF("/home/rumman/pdf/testCreate.pdf");
    }
}

