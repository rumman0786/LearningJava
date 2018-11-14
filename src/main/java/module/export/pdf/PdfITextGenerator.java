package module.export.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
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

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} PDF written successfully.", filePath));
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

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} PDF written successfully.", filePath));
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
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("{%s} PDF written successfully.", filePath));
    }
}
