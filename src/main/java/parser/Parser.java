package parser;

import command.Command;
import command.byeCommand;
import command.deleteCommand;
import command.doneCommand;
import command.eventDeadlineCommand;
import command.findCommand;
import command.listCommand;
import command.todoCommand;
import command.unknownCommand;
import exception.DukeInvalidArgumentException;
import task.TaskList;
import ui.UI;

/**
 * Parses the command given by the user
 * List of available commands:
 * bye
 * deadline DESCRIPTION /by YYYY-MM-DD HHmm
 * delete INDEX
 * done INDEX
 * event DESCRIPTION /at YYYY-MM-DD HHmm
 * find KEYWORD
 * list
 * todo DESCRIPTION
 */
public class Parser {
    /**
     * Returns a Command object based on the input.
     * If the command is not defined, return unknownCommand object.
     *
     * @param tasks the current list of Task
     * @param input the input given by the user
     * @return Command object
     * @throws DukeInvalidArgumentException If the argument given is in the wrong format
     */
    public static Command parse(TaskList tasks, String input) throws DukeInvalidArgumentException {
        if (input.trim().equals("bye")) {
            return new byeCommand();
        }
        if (input.trim().equals("list")) {
            return new listCommand();
        }
        if (input.startsWith("done")) {
            int index;
            try {
                index = Integer.parseInt(input.split("done")[1].trim());
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                throw new DukeInvalidArgumentException();
            }
            if (index < 1 || index > tasks.getTasks().size()) {
                throw new DukeInvalidArgumentException();
            }
            return new doneCommand(index);
        }
        if (input.startsWith("delete")) {
            int index;
            try {
                index = Integer.parseInt(input.split("delete")[1].trim());
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                throw new DukeInvalidArgumentException();
            }
            if (index < 1 || index > tasks.getTasks().size()) {
                throw new DukeInvalidArgumentException();
            }
            return new deleteCommand(index);
        }
        if (input.startsWith("todo")) {
            String description;
            try {
                description = input.trim().split("todo")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidArgumentException();
            }
            return new todoCommand(description);
        }
        if (input.startsWith("deadline")) {
            final String TYPE = "deadline";
            String deadlineDetails;
            try {
                deadlineDetails = input.trim().split("deadline")[1];
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidArgumentException();
            }
            String description, timeOfEvent;
            try {
                description = deadlineDetails.split("/by")[0].trim();
                timeOfEvent = deadlineDetails.split("/by")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidArgumentException();
            }
            return new eventDeadlineCommand(TYPE, description, timeOfEvent);
        }
        if (input.startsWith("event")) {
            final String TYPE = "event";
            String eventDetails;
            try {
                eventDetails = input.trim().split("event")[1];
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidArgumentException();
            }
            String description, timeOfEvent;
            try {
                description = eventDetails.split("/at")[0].trim();
                timeOfEvent = eventDetails.split("/at")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                throw new DukeInvalidArgumentException();
            }
            return new eventDeadlineCommand(TYPE, description, timeOfEvent);
        }
        if (input.startsWith("find")) {
            String filter;
            try {
                filter = input.split("find")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                UI.findWithoutArgumentMessage();
                return new listCommand();
            }
            return new findCommand(filter);
        }
        return new unknownCommand(input);
    }
}
