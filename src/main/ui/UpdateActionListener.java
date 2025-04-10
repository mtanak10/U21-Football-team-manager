package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Player;
import model.Team;

// updates the player's fitness and status
public class UpdateActionListener implements ActionListener {
    private JFrame updateFrame;
    private Team team;

    // Requires: team is not null
    // Modifies: this.updateFrame
    // Effects: initializes the update frame and stores a reference to the team
    public UpdateActionListener(Team team) {
        updateFrame = new JFrame("Update Player Status");
        this.team = team;
        updateFrame.setSize(400, 300);
        updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateFrame.setLayout(new GridLayout(7, 2));

    }

    // Requires: e is a valid action event, typically generated by a button click
    // Modifies: this.updateFrame
    // Effects: displays a form to enter player name; opens a new frame for updating
    // if player exists, or shows an error message
    @Override
    public void actionPerformed(ActionEvent e) {
        updateFrame.getContentPane().removeAll();

        updateFrame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        updateFrame.add(nameField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                System.out.print(name);

                if (team.containsName(name)) {
                    Player p = team.getPlayer(name);
                    updateFrame.dispose();
                    addUpdateFrame(p);

                } else {
                    JOptionPane.showMessageDialog(updateFrame, "Player does not exist", "Fail",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        updateFrame.add(submitButton);

        updateFrame.setVisible(true);

    }

    // Requires: p is not null and represents a valid player
    // Modifies: JFrame newFrame
    // Effects: creates a new frame to enter player attribute updates
    public void addUpdateFrame(Player p) {
        JFrame newFrame = new JFrame("Update Player Status");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new GridLayout(7, 2));

        JButton submitButton = addFrames(newFrame, p);
        newFrame.dispose();
        newFrame.add(submitButton);

        newFrame.setVisible(true);
    }

    // Effects: add buttons to the frames
    private JButton addFrames(JFrame newFrame, Player p) {
        newFrame.add(new JLabel("Evaluation: "));
        JTextField evaluationField = new JTextField();
        newFrame.add(evaluationField);

        newFrame.add(new JLabel("Drinking Status: (y or n)"));
        JTextField drinkingStatusField = new JTextField();
        newFrame.add(drinkingStatusField);

        newFrame.add(new JLabel("Attendance Rate to Training: (y or n)"));
        JTextField attendanceRateField = new JTextField();
        newFrame.add(attendanceRateField);

        newFrame.add(new JLabel("Sleeping Status: (y or n)"));
        JTextField sleepingStatusField = new JTextField();
        newFrame.add(sleepingStatusField);

        newFrame.add(new JLabel("Goals: "));
        JTextField goalsField = new JTextField();
        newFrame.add(goalsField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e1 -> handleUpdateSubmit(evaluationField, drinkingStatusField,
                attendanceRateField,
                sleepingStatusField, goalsField, updateFrame, p));

        return submitButton;
    }

    // Requires: all JTextField parameters are not null, p is not null and
    // represents a valid player
    // Modifies: p, updateFrame
    // Effects: reads input fields, validates data, and updates the player
    // attributes; displays error messages if inputs are invalid
    public void handleUpdateSubmit(
            JTextField evaluationField,
            JTextField drinkingStatusField,
            JTextField attendanceRateField,
            JTextField sleepingStatusField, JTextField goalsField, JFrame updateFrame,
            Player p) {
        int evaluation;
        String drink = drinkingStatusField.getText().toLowerCase();
        String attendance = attendanceRateField.getText().toLowerCase();
        String sleep = sleepingStatusField.getText().toLowerCase();
        int goals;

        evaluation = checkEvaluation(evaluationField);
        goals = checkGoal(goalsField);
        if (evaluation > 5 || goals < 0 || evaluation < 1) {
            return;
        }

        changeStatus(evaluation, attendance, sleep, drink, goals, p);

        JOptionPane.showMessageDialog(updateFrame, "Player Statys Updated", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        updateFrame.dispose();

    }

    // Effects returns the evaluation, and throws evaluation when the integer is not
    // betwen 1 to 5.
    private int checkEvaluation(JTextField evaluationField) {
        try {
            int evaluation = Integer.parseInt(evaluationField.getText());
            if (evaluation < 1 || evaluation > 5) {
                throw new NumberFormatException();
            }
            return evaluation;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(updateFrame, "Invalid input. Please check your entries.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return 0;

        }

    }

    // Effets: checks if the goal is done or not and throwsan exception if the goal < 0
    private int checkGoal(JTextField goalsField) {

        try {
            int goals = Integer.parseInt(goalsField.getText());
            if (goals < 0) {
                throw new NumberFormatException();
            }
            return goals;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(updateFrame, "Invalid input. Please check your entries.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }

    // Effect: this changes the status of the palyers at once.
    private void changeStatus(int evaluation, String attendance, String sleep, String drink, int goals, Player p) {
        p.changeEvaluation(evaluation);
        handleAttendance(attendance, p);
        handleSleeping(sleep, p);
        handleDrinking(drink, p);
        p.score(goals);

    }

    // Effects: attend training and change the status for the player
    public void handleAttendance(String s, Player p) {
        if (s.equals("y")) {
            p.attendTraining();
        } else if (s.equals("n")) {
            p.missTraining();
        } else {
            JOptionPane.showMessageDialog(updateFrame, "Invalid attendance input. Please check your entries.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: change the drinking status and change the status for the player
    public void handleDrinking(String s, Player p) {
        if (s.equals("y")) {
            p.drink();
        } else if (s.equals("n")) {
            p.dontDrink();
        } else {
            JOptionPane.showMessageDialog(updateFrame, "Invalid drink input. Please check your entries.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: change the sleeping status and change the status for the player
    public void handleSleeping(String s, Player p) {
        if (s.equals("y")) {
            p.sleep();
        } else if (s.equals("n")) {
            p.dontSleep();
        } else {
            JOptionPane.showMessageDialog(updateFrame, "Invalid Sleep input. Please check your entries.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
