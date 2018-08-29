package module.interfaceJ;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author rumman
 * @since 8/29/18
 */
public class InterfaceImplJ8Tester {

    private static List<String> names = Arrays.asList("Rumman", "Ashraf");

    @Test
    public void testPrintNames() {
        InterfaceImplJ8Example.listPrinter(names);
    }

    @Test
    public void testPrintNamesInterfaceDefault() {
        InterfaceImplJ8Example interfaceJ = new InterfaceImpl();
        interfaceJ.varArgPrinter(names);
    }

    private class InterfaceImpl implements InterfaceImplJ8Example{ }
}
