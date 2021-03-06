package module.stream;

import java.util.Objects;

/**
 * @author rumman
 * @since 8/25/18
 */
public class Task {
    private String taskName;
    private TaskType taskType;

    public Task(String taskName, TaskType taskType) {
        this.taskName = taskName;
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getTaskName(), task.getTaskName()) &&
                Objects.equals(getTaskType(), task.getTaskType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTaskName(), getTaskType());
    }

    @Override
    public String toString() {
        return taskName + " :: " + taskType;
    }
}