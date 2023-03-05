package seedu.duke.commands;

import seedu.duke.exercisegenerator.GenerateExercise;
import seedu.duke.exersisedata.ExerciseData;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class GenerateRandomCommand extends Command {
    private final int count;

    public GenerateRandomCommand(String userInput){
        this.count = Integer.parseInt(userInput);
    }
    public void executeCommand(Ui ui, GenerateExercise exerciseGenerator){
        ArrayList<ExerciseData> exercises = exerciseGenerator.generateRandomSet(count);
        ui.printExerciseFromList(exercises);
    }
}
