package module.export.pdf;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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

    @Test
    public void createLetterPDFTest() {
        String filePath = "/home/rumman/pdf/testLetterPDFDocument.pdf";
        PdfITextGenerator.createLetterPDF(filePath, getContent());

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createLetterLandscapePDFTest() {
        String filePath = "/home/rumman/pdf/testLetterLandscape.pdf";
        PdfITextGenerator.createLetterLandscapePDF(filePath, getContent());

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createLetterLandscapeAltPDFTest() {
        String filePath = "/home/rumman/pdf/testLetterLandscapeAlt.pdf";
        PdfITextGenerator.createLetterLandscapeAltPDF(filePath, 792f, 612f, getContent());

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createSideMarginedPDFTest() {
        String filePath = "/home/rumman/pdf/testSideMarginedDocument.pdf";
        PdfITextGenerator.createSideMarginedPDF(filePath, getContent());

        Assert.assertTrue(new File(filePath).exists());
    }

    @Test
    public void createTopBottomMarginedPDFTest() {
        String filePath = "/home/rumman/pdf/testTopBottomMarginedDocument.pdf";
        PdfITextGenerator.createTopBottomMarginedPDF(filePath, getContent());

        Assert.assertTrue(new File(filePath).exists());
    }

    private String getContent() {
        String filePath = "./src/main/resources/dummyContent.txt";
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            stream.forEach(stringBuilder::append);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

