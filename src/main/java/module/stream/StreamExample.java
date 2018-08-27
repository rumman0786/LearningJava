package module.stream;

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
}
