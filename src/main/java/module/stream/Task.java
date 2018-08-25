package module.stream;

/**
 * @author rumman
 * @since 8/25/18
 */
public class Task {
    private String taskName;
    private String taskType;

    public Task(String taskName, String taskType) {
        this.taskName = taskName;
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}