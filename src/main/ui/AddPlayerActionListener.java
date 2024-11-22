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

public class AddPlayerActionListener implements ActionListener {
    private Team team;
    private JFrame addPlayerFrame;

    public AddPlayerActionListener(Team team) {
        this.team = team;
        addPlayerFrame = new JFrame("Add Player");
        addPlayerFrame.setSize(400, 300);
        addPlayerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPlayerFrame.setLayout(new GridLayout(7, 2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Add Player button clicked"); // Debug statement

        addPlayerFrame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        addPlayerFrame.add(nameField);

        addPlayerFrame.add(new JLabel("Position (GK, DF, MF, FW):"));
        JTextField positionField = new JTextField();
        addPlayerFrame.add(positionField);

        addPlayerFrame.add(new JLabel("Evaluation (1-5):"));
        JTextField evaluationField = new JTextField();
        addPlayerFrame.add(evaluationField);

        addSubmitButton(addPlayerFrame, nameField, positionField, evaluationField);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlayerFrame.dispose(); // Close the add player window
            }
        });
        addPlayerFrame.add(cancelButton);

        addPlayerFrame.setVisible(true);
    }

    private void addSubmitButton(JFrame addPlayerFrame,
            JTextField nameField, JTextField positionField, JTextField evaluationField) {

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String position = positionField.getText().toUpperCase();
                int evaluation;

                evaluation = checkEvaluation(evaluationField, addPlayerFrame);
                if (evaluation > 5 || evaluation < 1) {
                    return;
                }

                if (!(position.equals("GK") || position.equals("DF") || position.equals("MF")
                        || position.equals("FW"))) {
                    JOptionPane.showMessageDialog(addPlayerFrame, "Position must be GK, DF, MF, or FW.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                addPlayer(name, position, evaluation);

                addPlayerFrame.dispose(); // Close the add player window
            }
        });
        addPlayerFrame.add(submitButton);
    }

    private void addPlayer(String name, String position, int evaluation) {

        Player player = new Player(name, position, evaluation);
        team.addPlayer(player);
        JOptionPane.showMessageDialog(addPlayerFrame, "Player added successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);

    }

    // Effects returns the evaluation, and throws evaluation when the integer is not
    // betwen 1 to 5.
    private int checkEvaluation(JTextField evaluationField, JFrame addPlayerFrame) {
        try {
            int evaluation = Integer.parseInt(evaluationField.getText());
            if (evaluation < 1 || evaluation > 5) {
                throw new NumberFormatException();
            }
            return evaluation;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(addPlayerFrame, "Invalid input. Please check your entries.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            return 0;

        }

    }

}
