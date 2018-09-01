package module.xml;

import java.io.Serializable;

/**
 * @author rumman
 * @since 9/1/18
 */
public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean myBoolean;
    private String myString;
//    private Vector<String> myVector;

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
//    public Vector<String> getMyVector() {
//        return myVector;
//    }
//    public void setMyVector(Vector<String> myVector) {
//        this.myVector = myVector;
//    }
}
