package module.xml;

import org.junit.Test;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author rumman
 * @since 9/1/18
 */
public class MyBeanXmlDecoder {

    @Test
    public void xmlDecoder() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/src/main/resources/META-INF/mybean.xml");
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        MyBean mb = (MyBean) xmlDecoder.readObject();
        System.out.println(mb.isMyBoolean());
        System.out.println(mb.getMyString());
//        for (String str : mb.getMyVector()) {
//            System.out.println(str);
//        }
    }
}
