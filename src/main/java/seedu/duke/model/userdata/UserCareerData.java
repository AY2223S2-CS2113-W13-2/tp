package seedu.duke.model.userdata;

import java.util.ArrayList;

import seedu.duke.ui.PrintExercises;

/**
 * This class consists of all user sessions that the user has completed in FitnessDuke and handles the addition of
 * new sessions made by the user
 */
public class UserCareerData {

    /**
     * ArrayList of Session that consists of all sessions completed by the user
     */
    private ArrayList<Session> totalUserCareerSessions;

    /**
     * Constructs an empty userCareer
     */
    public UserCareerData () {
        totalUserCareerSessions = new ArrayList<>();
    }

    /**
     * Gets all the user sessions completed in their career
     *
     * @return An arrayList consisting of all sessionData completed by the user
     */
    public ArrayList<Session> getTotalUserCareerSessions () {
        return totalUserCareerSessions;
    }

    /**
     * Adds a new workout session that has been completed by the user
     *
     * @param session Data of the session that has been completed
     */
    public void addWorkoutSession (Session session) {
        totalUserCareerSessions.add(session);
    }

    //@@author ChubbsBunns
    public void printAllFinishedWorkoutSessions () {
        PrintExercises exercisePrinter = new PrintExercises();
        for (int i = 0; i < totalUserCareerSessions.size(); i++) {
            System.out.println("Session " + (i + 1));
            String dateTime = totalUserCareerSessions.get(i).getDateAdded().toString();
            String[] dateSplit = dateTime.split("T", 2);
            assert dateSplit.length == 2;
            System.out.println("On this date: " + dateSplit[0]);
            exercisePrinter.printExercise(totalUserCareerSessions.get(i).getSessionExercises());
            if (i != totalUserCareerSessions.size() - 1) {
                System.out.println("\n ");
            }
        }

    }

}
