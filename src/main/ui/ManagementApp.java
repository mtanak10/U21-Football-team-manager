package ui;

import java.util.Scanner;

import model.Team;
import model.Player;

// Adapted from Teller App ui

public class ManagementApp {
    private Team team;
    private Scanner input;

    // constructor for the app and this wouald allow you to start running the app
    public ManagementApp() {
        team = new Team();
        runManagement();

    }

    // runs the management system
    public void runManagement() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMethod();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

    }

    // initializes the method
    public void init() {

        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // Implementing and arranging what is shown in the terminal it self the display
    // menu of the user
    public void displayMethod() {

        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add a Player");
        System.out.println("\tr -> Remove a Player");
        System.out.println("\tt -> View the Team");
        System.out.println("\tc -> Check the Availability of a Player");
        System.out.println("\tu -> Update Fitness");
        System.out.println("\tq -> quit");

    }

    public void processCommand(String command) {
        if (command.equals("a")) {
            doAddPlayer();
        } else if (command.equals("r")) {
            doRemovePlayer();
        } else if (command.equals("t")) {
            doViewTeam();
        } else if (command.equals("c")) {
            doCheckAvailability();
        } else if (command.equals("u")) {
            doUpdateFitness();
        } else {
            System.out.println("Try Again");
        }
    }

    // Requires the the player to have a position of "GK","DF", "MF" or "FW"
    // the evaluation has to be number from 1 to 5
    // Modifies the team
    // Effects: adds a player to the team
    public void doAddPlayer() {
        System.out.println("Enter the name of the Player");
        String name = input.next();

        System.out.println("Enter the Evaluation 1 - 5");
        int evaluation = input.nextInt();

        System.out.println("Enter the position: GK,DF, MF or FW");
        String position = input.next();
        position = position.toUpperCase();

        Boolean rightPosition = (position.equals("GK") || position.equals("DF") || position.equals("MF")
                || position.equals("FW"));

        if (rightPosition && (1 <= evaluation && evaluation <= 5)) {
            Player player = new Player(name, position, evaluation);
            team.addPlayer(player);
            System.out.println("------------------");
            System.out.println("PLAYER ADDED:");
            System.out.println("\tNAME: " + player.getName() + "   " + "POSITION: " + player.getPosition());
        } else {
            System.out.println("Invalid Input try again");
        }

        System.out.println("The team size is now " + team.getTotalPlayers());
        System.out.println("------------------");

    }

    public void doRemovePlayer() {

        System.out.println("Enter the name of the Player");
        String name = input.next();

        team.removePlayer(name);

        System.out.println("\n The team size is now: " + team.getTotalPlayers());

    }

    public void doViewTeam() {
        System.out.println("\tLIST OF PLAYERS");
        for (Player player : team.getTeam()) {

            System.out.println("");
            System.out.println("\tName: " + player.getName() + "   " + "Position: " + player.getPosition() + " Availability: " + player.isAvailable());

        }

    }

    public void doCheckAvailability() {
        System.out.println("Enter the name of the player");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                Player player = team.getTeam().get(i);
                if (player.isAvailable()) {
                    System.out.println("\\tTHIS PLAYER IS READY TO PLAY");
                } else {
                    System.out.println("\t!!CURRENTLY UNABLE TO PLAY!!");
                }
            } else {
                System.out.println("Player is not registered in the Team");
            }
        }
        System.out.println("DONE");
    }

    public void doUpdateFitness() {

        System.out.println("\nSelect from:");
        System.out.println("\te -> Change Evaluation");
        System.out.println("\td -> Change drinking status");
        System.out.println("\ta -> Change Attendance Rate to training");
        System.out.println("\ts -> Change Sleeping Status");
        System.out.println("\tg -> Score Goal Stats");

        String updateCommand = input.next();
        updateCommand = updateCommand.toLowerCase();

        processUpdateCommand(updateCommand);

    }

    public void processUpdateCommand(String command) {

        if (command.equals("e")) {
            doEvaluationChange();
        } else if (command.equals("d")) {
            doChangeDrinking();
        } else if (command.equals("a")) {
            doAttend();
        } else if (command.equals("s")) {
            doChangeSleeping();
        } else if (command.equals("g")) {
            doScore();
        } else {
            System.out.println("Try Again");
        }

    }

    public void doEvaluationChange() {

        Player player;

        System.out.println("Enter Player Name");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                player = team.getTeam().get(i);

                System.out.println("Enter the new evaluation of the player:");

                int evaluation = input.nextInt();
                if (evaluation <= 5 && evaluation > 0) {
                    player.changeEvaluation(evaluation);
                } else {
                    System.out.println("Try again");
                }

                System.out.println("Player's Current Evaluation is " + player.getEvaluation());

            }

        }

    }

    public void doChangeDrinking() {
        Player player;

        System.out.println("Enter Player Name");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                player = team.getTeam().get(i);

                System.out.println("\nSelect from:");
                System.out.println("\ty -> Went Drinking Before the Game");
                System.out.println("\tn -> Stayed In");

                String command = input.next();

                if (command.equals("y")) {
                    player.drink();
                    System.out.println("WENT DRINKING");
                } else if (command.equals("n")) {
                    player.dontDrink();
                } else {
                    System.out.println("Try Again");
                }
            }
        }
    }

    public void doAttend() {
        Player player;

        System.out.println("Enter Player Name");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                player = team.getTeam().get(i);

                System.out.println("\nSelect from:");
                System.out.println("\ty -> Attended Training");
                System.out.println("\tn -> Missed Training");

                String command = input.next();

                if (command.equals("y")) {
                    player.attendTraining();
                    System.out.println("Good Training");
                    System.out.println("Current Attendance Rate: " + player.getAttendanceTraining());

                } else if (command.equals("n")) {
                    player.missTraining();
                    System.out.println("Did not attend");
                    System.out.println("Current Attendance Rate: " + player.getAttendanceTraining());
                } else {
                    System.out.println("Try Again");
                }

            }

        }

    }

    public void doChangeSleeping() {
        Player player;

        System.out.println("Enter Player Name");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                player = team.getTeam().get(i);

                System.out.println("\nSelect from:");
                System.out.println("\ty -> Slept Well");
                System.out.println("\tn -> Did not sleep well");

                String command = input.next();

                if (command.equals("y")) {
                    player.sleep();
                    System.out.println("SLEPT WELL");
                } else if (command.equals("n")) {
                    player.dontSleep();
                    System.out.println("Did not have enough sleep");
                } else {
                    System.out.println("Try Again");
                }

            }

        }

    }

    public void doScore() {
        Player player;

        System.out.println("Enter Player Name");
        String name = input.next();
        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equals(name)) {
                player = team.getTeam().get(i);

                System.out.println("Enter the goal scored:");
                int goal = input.nextInt();

                player.score(goal);
                System.out.println("Player's Total Goal is " + player.getGoal());

            }

        }

    }

}
