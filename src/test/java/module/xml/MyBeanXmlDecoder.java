package module.xml;

import org.junit.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rumman
 * @since 9/1/18
 */
public class MyBeanXmlDecoder {

    @Test
    public void xmlToBeanConversion() throws IOException {
        String filePath = "/mybean.xml";

        try (InputStream fis = MyBeanXmlDecoder.class.getResourceAsStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             XMLDecoder xmlDecoder = new XMLDecoder(bis)) {

            MyBean mb = (MyBean) xmlDecoder.readObject();

            System.out.println(mb.isMyBoolean());
            System.out.println(mb.getMyString());

            mb.getMyList().forEach(System.out::println);
            mb.getMyMap().values().forEach(System.out::println);
        }
    }

    @Test
    public void beanToXmlConversion() throws IOException {
        MyBean myBean = new MyBean();
        myBean.setMyString("CREATE");
        myBean.setMyBoolean(true);
        myBean.setMyList(new ArrayList<>(Arrays.asList("rumman", "ashraf")));

        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        myBean.setMyMap(map);

        String path = "./src/main/resources/mybeanOut.xml";
        try (FileOutputStream fos = new FileOutputStream(path);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             XMLEncoder xmlEncoder = new XMLEncoder(bos)) {

            xmlEncoder.writeObject(myBean);
        }
    }
}
