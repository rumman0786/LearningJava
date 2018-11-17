package module.export.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author rumman
 * @since 10/22/18
 */
public class PdfITextGenerator {


    public static void createParagraphPDF(String filePath) {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            document.add(new Paragraph("Hello World!"));
            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void createParagraphPDFCustomParams(String filePath, String paragraphContent,
                                                      float upperRightX, float upperRightY,
                                                      float marginLeft, float marginRight,
                                                      float marginTop, float marginBottom) {

        Rectangle pageSize = new Rectangle(upperRightX, upperRightY);
        Document document = new Document(pageSize, marginLeft, marginRight, marginTop, marginBottom);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            document.add(new Paragraph(paragraphContent));
            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }


    /**
     * Creates a PDF file: hello_maximum.pdf
     * Important notice: the PDF is valid (in conformance with
     * ISO-32000), but some PDF viewers won't be able to render
     * the PDF correctly due to their own limitations.
     */
    public static void createMaxPDF(String filePath, String paragraphContent, float upperRightX, float upperRightY) {

        Document document = new Document(new Rectangle(upperRightX, upperRightY));
        PdfWriter writer = null;

        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            writer.setUserunit(75f);

            document.open();
            document.add(new Paragraph(paragraphContent));
            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createLetterPDF(String filePath, String paragraphContent) {
        createLetterPDF(filePath, paragraphContent, PageSize.LETTER);
    }

    public static void createLetterLandscapePDF(String filePath, String paragraphContent) {
        createLetterPDF(filePath, paragraphContent, PageSize.LETTER.rotate());
    }

    public static void createLetterPDF(String filePath, String paragraphContent, Rectangle rectangle) {

        Document document = new Document(rectangle);
        PdfWriter writer = null;

        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            document.add(new Paragraph(paragraphContent));
            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
