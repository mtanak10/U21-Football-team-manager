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

public class UpdateActionListener implements ActionListener {
    private JFrame updateFrame;
    private Team team;

    public UpdateActionListener(Team team) {
        updateFrame = new JFrame("Update Player Status");
        this.team = team;
        updateFrame.setSize(400, 300);
        updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateFrame.setLayout(new GridLayout(7, 2));

    }

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

    public void addUpdateFrame(Player p) {
        JFrame newFrame = new JFrame("Update Player Status");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new GridLayout(7, 2));

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

        newFrame.dispose();
        newFrame.add(submitButton);

        newFrame.setVisible(true);
    }

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

        try {
            evaluation = Integer.parseInt(evaluationField.getText());
            if (evaluation < 1 || evaluation > 5) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(updateFrame, "Invalid input. Please check your entries.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            goals = Integer.parseInt(goalsField.getText());
            if (goals < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(updateFrame, "Invalid input. Please check your entries.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        p.changeEvaluation(evaluation);
        handleAttendance(attendance, p);
        System.out.println(attendance);
        handleSleeping(sleep, p);
        handleDrinking(drink, p);
        p.score(goals);

        JOptionPane.showMessageDialog(updateFrame, "Player Statys Updated", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        updateFrame.dispose();

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
