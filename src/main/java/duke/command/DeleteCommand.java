package duke.command;

import duke.DukeException;
import duke.management.NotesList;
import duke.management.TaskList;
import duke.task.Task;

/**
 * Delete Command Class.
 */
public class DeleteCommand extends Command {
    /**
     * Constructor for Delete Command.
     * @param command User command.
     */
    public DeleteCommand(String command) {
        super(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute(TaskList tasks, NotesList notes) {
        try {
            String[] commandArr = this.command.split(" ", 2);
            int index = Integer.parseInt(commandArr[1]) - 1;
            Task deleted = tasks.deleteTask(index);
            String result = "Ren removed the task: \n" + deleted.toString() + "\n";
            return result + "\nNow you have " + tasks.getSize() + " tasks in the list.";
        } catch (NumberFormatException e) {
            throw new DukeException(DukeException.INVALID_INDEX);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validateCommand() throws DukeException {
        String[] commandArr = this.command.split(" ", 2);
        if (commandArr.length < 2) {
            throw new DukeException(String.format(DukeException.NON_EMPTY, "mark"));
        }
    }
}
