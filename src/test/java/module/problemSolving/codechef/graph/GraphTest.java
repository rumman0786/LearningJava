package module.problemSolving.codechef.graph;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author rumman
 * @since 12/18/18
 */
public class GraphTest {

    @Test
    public void testSumOfDigits() {
        svgToImage();
    }

    public static void svgToImage() {
        //Step -1: We read the input SVG document into Transcoder Input
        //We use Java NIO for this purpose
//        String svg_URI_input = Paths.get("chessboard.svg").toUri().toURL().toString();
        TranscoderInput svgImage = new TranscoderInput("/home/rumman/Desktop/image4.svg");
        //Step-2: Define OutputStream to PNG Image and attach to TranscoderOutput
        try {
            OutputStream pngOutputStream = new FileOutputStream("/home/rumman/Desktop/image4.png");
            TranscoderOutput pngImage = new TranscoderOutput(pngOutputStream);

            PNGTranscoder converter = new PNGTranscoder();

            converter.transcode(svgImage, pngImage);

            pngOutputStream.flush();
            pngOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
