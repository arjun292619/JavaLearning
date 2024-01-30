package dev.lpa.setMethods;

public class Task implements Comparable<Task> {
    @Override
    public int compareTo(Task o) {
        int result = this.project.compareTo(o.project);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }

    public enum Status {IN_QUEUE, ASSIGNED, IN_PROGRESS}

    public enum Priority {HIGH, MEDIUM, LOW}

    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }


    public Task(String project, String description, String assignee, Priority priority) {
        this(project, description, assignee, priority, assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        this(project, description, null, priority);
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(project, description, priority, assignee, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!project.equals(task.project)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = project.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
