package module.xml;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author rumman
 * @since 9/1/18
 */
public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean myBoolean;
    private String myString;
    private List<String> myList;
    private Map<String, String> myMap;

    public MyBean() {
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
}
