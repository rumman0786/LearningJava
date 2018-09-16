package module.xml;

import org.junit.Test;

/**
 * @author rumman
 * @since 9/16/18
 */
public class XmlGeneratorTest {

    @Test
    public void testXmlGeneration() {
        XmlGenerator.generateXml("testFile.xml");
    }
}
