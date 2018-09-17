package module.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author rumman
 * @since 8/23/18
 */
public class StreamExample {

    public static List<String> getTaskNames(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getTaskName)
                .collect(Collectors.toList());
    }

    public static List<?> getTaskNames(List<Task> tasks, Function<Task, ?> propertyMapper) {
        return tasks.stream()
                .map(propertyMapper)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Task> getTaskMap(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.toMap(Task::getTaskName, Function.identity()));
    }

    public static Map<TaskType, List<Task>> getGroupTasks(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getTaskType));
    }

    public static Map<TaskType, Long> getGroupCounts(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getTaskType, Collectors.counting()));
    }

    public static Map<Boolean, List<Task>> getPartitionByLength(List<Task> tasks) {
        return tasks.stream()
                .collect(Collectors.partitioningBy(t -> t.getTaskName().length() > 10));
    }

    public static String getAllTaskNames(List<Task> tasks) {
        return tasks.stream()
                .map(Task::getTaskName)
                .collect(Collectors.joining(", "));
    }

    public static List<Integer> getLimits() {

        List<Integer> integers = Arrays.asList(300, 12, 2, 3, 33, 76,56, 67);

        return integers.stream()
                .filter(i -> i % 2 == 0)
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Integer> getDistincts() {

        List<Integer> integers = Arrays.asList(300, 12, 12, 3, 33, 76,56, 67);

        return integers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }
}
