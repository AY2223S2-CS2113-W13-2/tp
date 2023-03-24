package seedu.duke.logic.commands;

import seedu.duke.commons.exceptions.DukeError;
import seedu.duke.model.exercisegenerator.GenerateExercise;
import seedu.duke.ui.Ui;

/**
 * Handles the various user commands.
 */
public abstract class Command {

    public abstract void executeCommand (Ui ui, GenerateExercise exerciseGenerator) throws DukeError;

}
