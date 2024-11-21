package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Player;
import model.Team;

public class RemovePlayerActionListener implements ActionListener {
    private Team team;

    public RemovePlayerActionListener(Team team) {
        this.team = team;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame removePlayerFrame = new JFrame();
        removePlayerFrame.setSize(400, 300);
        removePlayerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removePlayerFrame.setLayout(new GridLayout(8, 2));

        removePlayerFrame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        removePlayerFrame.add(nameField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                System.out.print(name);

                if (team.containsName(name)) {
                    team.removePlayer(name);
                    JOptionPane.showMessageDialog(removePlayerFrame, "Player removed successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(removePlayerFrame, "Player does not exist", "Fail",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                removePlayerFrame.dispose();
            }
        });
        removePlayerFrame.add(submitButton);


        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePlayerFrame.dispose(); // Close the add player window
            }
        });
        removePlayerFrame.add(cancelButton);

        removePlayerFrame.setVisible(true);

    }

}
