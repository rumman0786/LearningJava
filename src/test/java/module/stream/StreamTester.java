package module.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static module.stream.TaskType.BLOGGING;
import static module.stream.TaskType.CODING;
import static module.stream.TaskType.READING;

/**
 * @author rumman
 * @since 8/25/18
 */
public class StreamTester {

    private final List<Task> TASKS = new ArrayList<>();
    private final String[] TASK_NAMES = {
            "Power of Now",
            "The One Thing",
            "Elon Musk",
            "Vlad Mihalcea",
            "Baeldung",
            "JOOQ",
            "Java",
            "Spring",
            "JUNIT"
    };

    @Before
    public void setUp() {
        TASKS.add(new Task("Power of Now", READING));
        TASKS.add(new Task("The One Thing", READING));
        TASKS.add(new Task("Elon Musk", READING));

        TASKS.add(new Task("Vlad Mihalcea", BLOGGING));
        TASKS.add(new Task("Baeldung", BLOGGING));
        TASKS.add(new Task("JOOQ", BLOGGING));

        TASKS.add(new Task("Java", CODING));
        TASKS.add(new Task("Spring", CODING));
        TASKS.add(new Task("JUNIT", CODING));
    }

    @Test
    public void testListTaskNames() {
        Assert.assertEquals(StreamExample.getTaskNames(TASKS).size(), 9);
        Assert.assertNotEquals(StreamExample.getTaskNames(new ArrayList<>()).size(), 9);

        Assert.assertArrayEquals(StreamExample.getTaskNames(TASKS).toArray(), TASK_NAMES);
    }

    @Test
    public void testListProperties() {
        Function<Task, String> taskNameMapper = t -> t.getTaskName();
        Function<Task, TaskType> taskTypeMapper = Task::getTaskType;

        Assert.assertEquals(StreamExample.getTaskNames(TASKS, taskNameMapper).size(), TASK_NAMES.length);
        Assert.assertEquals(StreamExample.getTaskNames(TASKS, taskTypeMapper).size(), TaskType.values().length);

        Assert.assertArrayEquals(StreamExample.getTaskNames(TASKS, taskNameMapper).toArray(), TASK_NAMES);
        Assert.assertArrayEquals(StreamExample.getTaskNames(TASKS, taskTypeMapper).toArray(), TaskType.values());
    }

    @Test
    public void testTaskMap() {
        Map<String, Task> taskMap = StreamExample.getTaskMap(TASKS);
        Task task = new Task("Java", CODING);
        Assert.assertEquals(taskMap.get("Java"), task);
    }
}
