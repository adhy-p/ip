package parser;

import command.*;
import exception.DukeInvalidArgumentException;
import task.TaskList;
import ui.UI;

public class Parser {
    public static Command parse(TaskList tasks, String input) throws DukeInvalidArgumentException {
        if (input.trim().equals("bye")) {
            return new byeCommand();
        }
        if (input.trim().equals("list")) {
            return new listCommand();
        }
        if (input.startsWith("done")) {
            int index = -1;
            try {
                index = Integer.parseInt(input.split("done")[1].trim());
            }  catch (IndexOutOfBoundsException | NumberFormatException e) {
                UI.doneMessage();
            }
            if(index < 1 || index > tasks.getTasks().size()){
                throw new DukeInvalidArgumentException();
            }
            return new doneCommand(index);
        }
        if (input.startsWith("delete")) {
            int index = -1;
            try {
                index = Integer.parseInt(input.split("delete")[1].trim());
            }  catch (IndexOutOfBoundsException | NumberFormatException e) {
                UI.invalidIndexMessage();
            }
            if(index < 1 || index > tasks.getTasks().size()){
                throw new DukeInvalidArgumentException();
            }
            return new deleteCommand(index);
        }
        if (input.startsWith("todo")) {
            String description;
            try {
                description = input.trim().split("todo")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                UI.noDescriptionExceptionMessage();
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
                UI.noDescriptionExceptionMessage();
                throw new DukeInvalidArgumentException();
            }
            String description, timeOfEvent;
            try {
                description = deadlineDetails.split("/by")[0].trim();
                timeOfEvent = deadlineDetails.split("/by")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                UI.notEnoughArgumentsMessage();
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
                UI.noDescriptionExceptionMessage();
                throw new DukeInvalidArgumentException();
            }
            String description, timeOfEvent;
            try {
                description = eventDetails.split("/at")[0].trim();
                timeOfEvent = eventDetails.split("/at")[1].trim();
            } catch (IndexOutOfBoundsException e) {
                UI.notEnoughArgumentsMessage();
                throw new DukeInvalidArgumentException();
            }
            return new eventDeadlineCommand(TYPE, description, timeOfEvent);
        }

        // default
        return new unknownCommand(input);
    }
}
