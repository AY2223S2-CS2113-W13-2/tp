package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.commons.exceptions.DukeError;
import seedu.duke.logic.commands.GenerateFilterCommand;
import seedu.duke.data.exercisegenerator.GenerateExercise;
import seedu.duke.data.userdata.userplan.UserPlan;
import seedu.duke.ui.UiManager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * This class test the handling of commands and checks if commands throw appropriate errors.
 */
public class TestCommands {
    /**
     * Tests the GenerateFilterCommand and checks if command have a valid argument to number of exercises in the user
     * input. If number of exercise is not present in user input, an exception should be thrown, none otherwise.
     */
    @Test
    public void testUserFilterCommand () {

        String[] invalidCommands = {"this is an invalid command", "this is another invalid command"};
        assertThrows(DukeError.class, () -> {
            new GenerateFilterCommand(invalidCommands);
        });
        String[] validCommands = {"body", "3"};
        assertDoesNotThrow(() -> {
            new GenerateFilterCommand(validCommands);
        });
    }

    /**
     * Tests the executeCommand of GenerateFilterCommand and checks if command can execute and throw the appropriate
     * error such as when an event that the user inputs an invalid filter argument.
     */
    @Test
    public void testExecuteFilterCommand () {
        String[] invalidCommands = {"An", "invalid", "command", "3"};
        UiManager uiManager = new UiManager();
        GenerateExercise generateExercise = new GenerateExercise();
        assertThrows(DukeError.class, () -> {
            GenerateFilterCommand generateFilterCommand = new GenerateFilterCommand(invalidCommands);
            generateFilterCommand.executeCommand(uiManager, generateExercise);
        });
        String[] validCommands = {"easy", "upper", "3"};
        assertDoesNotThrow(() -> {
            GenerateFilterCommand generateFilterCommand = new GenerateFilterCommand(validCommands);
            generateFilterCommand.executeCommand(uiManager, generateExercise);
        });
    }

    //@author Khulon
    @Test
    public void testAddPlanCommand () {
        String[] invalidCommands = {"add", "invalid", "command",};
        new UserPlan();
        assertThrows(DukeError.class, () -> {
            UserPlan.addPlan(invalidCommands);
        });
        String[] validCommands = {"add", "monday", "home", "static"};
        assertDoesNotThrow(() -> {
            UserPlan.addPlan(validCommands);
        });
    }

    //@author Khulon
    @Test
    public void testDeletePlanCommand () throws DukeError {
        new UserPlan();
        String[] dummyCommand = {"add", "monday", "home", "static"};
        UserPlan.addPlan(dummyCommand);

        String[] invalidCommands = {"delete", "invalid", "command",};
        assertThrows(DukeError.class, () -> {
            UserPlan.deletePlan(invalidCommands);
        });
        String[] validCommands = {"delete", "monday", "home"};
        assertDoesNotThrow(() -> {
            UserPlan.deletePlan(validCommands);
        });
    }


}
