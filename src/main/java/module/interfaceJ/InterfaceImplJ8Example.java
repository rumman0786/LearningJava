package module.interfaceJ;

import java.util.Arrays;
import java.util.List;

public interface InterfaceImplJ8Example {

    static <T> void listPrinter(List<T> printable) {
        printable.forEach(System.out::println);
    }

    default <T> void varArgPrinter(T... elements) {
        Arrays.asList(elements).forEach(System.out::println);
    }
}
