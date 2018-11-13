package module.export.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
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
}
