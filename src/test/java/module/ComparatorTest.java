package module;

import module.comparator.ComparatorProvider;
import module.comparator.Developer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rumman
 * @since 9/8/18
 */
public class ComparatorTest {

    public static List<Developer> developers;

    @Before
    public void init() {
        List<Developer> initDevels = new ArrayList<>();
        initDevels.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        initDevels.add(new Developer("alvin", new BigDecimal("80000"), 20));
        initDevels.add(new Developer("jason", new BigDecimal("100000"), 10));
        initDevels.add(new Developer("iris", new BigDecimal("170000"), 55));
        initDevels.add(new Developer("iris", new BigDecimal("170000"), 70));
        initDevels.add(new Developer("iris", new BigDecimal("100000"), 30));

        developers = Collections.unmodifiableList(initDevels);
    }

    @Test
    public void testSort() {
        List<Developer> developersCloneListActual = new ArrayList<>(developers);
        List<Developer> developersCloneListExpected = new ArrayList<>(developers);
        List<Developer> developersCloneListExpected2 = new ArrayList<>(developers);

        developersCloneListExpected.sort(ComparatorProvider.getClassicComparator());
        developersCloneListActual.sort(ComparatorProvider.getLambdaComparator());
        developersCloneListExpected2.sort(ComparatorProvider.getReadableLambdaComparator());

        Assert.assertArrayEquals(developersCloneListExpected.toArray(), developersCloneListExpected2.toArray());
        Assert.assertArrayEquals(developersCloneListExpected.toArray(), developersCloneListActual.toArray());
        Assert.assertArrayEquals(developersCloneListExpected2.toArray(), developersCloneListActual.toArray());

        developersCloneListActual.forEach(System.out::println);
    }

    public void testMultipleSort() {
        developers.sort(ComparatorProvider.getComparatorByNameAgeSalary());
        developers.forEach(System.out::println);
    }
}
