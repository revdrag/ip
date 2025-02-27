package duke.task;

/**
 * Todo task.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String writeToFile() {
        int completed = this.isDone ? 1 : 0;
        return "T " + "| " + completed + " | " + this.description + "\r\n";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
