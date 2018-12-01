package module.export.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

    public static void createLetterLandscapeAltPDF(String filePath, float upperRightX, float upperRightY, String paragraphContent) {
        createLetterPDF(filePath, paragraphContent, new Rectangle(792, 612));
    }

    private static void createLetterPDF(String filePath, String paragraphContent, Rectangle rectangle) {

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

    public static void createSideMarginedPDF(String filePath, String paragraphContent) {
        Document document = new Document();
        document.setPageSize(PageSize.A5);
        document.setMargins(36, 72, 108, 180);
        document.setMarginMirroring(true);

        createMarginedPDF(filePath, paragraphContent, document);
    }

    public static void createTopBottomMarginedPDF(String filePath, String paragraphContent) {
        Document document = new Document();
        document.setPageSize(PageSize.A5);
        document.setMargins(36, 72, 108, 180);
        document.setMarginMirroringTopBottom(true);

        createMarginedPDF(filePath, paragraphContent, document);
    }

    private static void createMarginedPDF(String filePath, String paragraphContent, Document document) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            Paragraph paragraph = new Paragraph(paragraphContent);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createMemoryPDF(String filePath, String paragraphContent) {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(FileOutputStream fos = new FileOutputStream(filePath)) {

            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph(paragraphContent));
            document.close();

            fos.write(baos.toByteArray());

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void createVersionedPDF(String filePath, String paragraphContent, PdfName version) {
        Document document = new Document();

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);
            pdfWriter.setPdfVersion(version);

            document.open();
            document.add(new Paragraph(paragraphContent));
            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void pdfContentByteExample(String filePath, String paragraphContent) {
        Document document = new Document();

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);
            pdfWriter.setCompressionLevel(0);

            document.open();

            PdfContentByte canvas = pdfWriter.getDirectContentUnder();
            canvas.saveState();
            canvas.beginText();
            canvas.moveText(36, 788);
            canvas.setFontAndSize(BaseFont.createFont(), 12);
            canvas.showText(paragraphContent);
            canvas.endText();
            canvas.restoreState();

            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void pdfContentByteWithColumnExample(String filePath, String paragraphContent) {
        Document document = new Document();

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);
            pdfWriter.setCompressionLevel(0);

            document.open();

            Phrase phrase = new Phrase(paragraphContent);

            PdfContentByte pdfContentByte = pdfWriter.getDirectContentUnder();

            ColumnText.showTextAligned(pdfContentByte, Element.ALIGN_LEFT, phrase, 36, 788, 0);

            document.close();

            System.out.println(String.format("{%s} PDF written successfully.", filePath));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void getZippedPdfContent(String filePath, String paragraphContent) {

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath))) {

            for (int i = 1; i <= 3; i++) {
                ZipEntry entry = new ZipEntry("hello_" + i + ".pdf");
                zipOutputStream.putNextEntry(entry);

                Document document = new Document();

                PdfWriter writer = PdfWriter.getInstance(document, zipOutputStream);
                writer.setCloseStream(false);

                document.open();
                document.add(new Paragraph(paragraphContent));
                document.close();

                zipOutputStream.closeEntry();
            }

          } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
