package module.xml;

import org.junit.Test;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author rumman
 * @since 9/1/18
 */
public class MyBeanXmlDecoder {

    @Test
    public void xmlDecoder() {
        String filePath = "/mybean.xml";
        InputStream fis = MyBeanXmlDecoder.class.getResourceAsStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        MyBean mb = (MyBean) xmlDecoder.readObject();

        System.out.println(mb.isMyBoolean());
        System.out.println(mb.getMyString());

        for (String str : mb.getMyList()) {
            System.out.println(str);
        }
    }
}
