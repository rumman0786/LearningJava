package module.comparator;

import java.util.Comparator;

/**
 * @author rumman
 * @since 9/8/18
 */
public class ComparatorProvider {

    public static Comparator<Developer> getClassicComparator() {

        Comparator<Developer> developerComparator = new Comparator<Developer>() {
            @Override
            public int compare(Developer developer1, Developer developer2) {
                return developer1.getName().compareTo(developer2.getName());
            }
        };

        return developerComparator;
    }

    public static Comparator<Developer> getLambdaComparator() {
        return  (o1, o2) ->  o1.getName().compareTo(o2.getName());
    }

    public static Comparator<Developer> getReadableLambdaComparator() {
        return Comparator.comparing(Developer::getName);
    }

    public static Comparator<Developer> getComparatorByNameAgeSalary() {
        return Comparator.comparing(Developer::getName)
                .thenComparing(Developer::getAge)
                .thenComparing(Developer::getSalary);
    }
}
